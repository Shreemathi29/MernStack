/*
 *  Copyright (c) 2020, Oracle and/or its affiliates. All rights reserved.
 *  ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */
package jdk.internal.foreign.abi.x64.windows;

import jdk.incubator.foreign.*;
import jdk.internal.foreign.Scoped;
import jdk.internal.foreign.ResourceScopeImpl;
import jdk.internal.foreign.abi.SharedUtils;
import jdk.internal.foreign.abi.SharedUtils.SimpleVaArg;

import java.lang.invoke.VarHandle;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

import static jdk.internal.foreign.PlatformLayouts.Win64.C_POINTER;

// see vadefs.h (VC header)
//
// in short
// -> va_list is just a pointer to a buffer with 64 bit entries.
// -> non-power-of-two-sized, or larger than 64 bit types passed by reference.
// -> other types passed in 64 bit slots by normal function calling convention.
//
// X64 va_arg impl:
//
//    typedef char* va_list;
//
//    #define __crt_va_arg(ap, t)                                               \
//        ((sizeof(t) > sizeof(__int64) || (sizeof(t) & (sizeof(t) - 1)) != 0) \
//            ? **(t**)((ap += sizeof(__int64)) - sizeof(__int64))             \
//            :  *(t* )((ap += sizeof(__int64)) - sizeof(__int64)))
//
public non-sealed class WinVaList implements VaList, Scoped {
    public static final Class<?> CARRIER = MemoryAddress.class;
    private static final long VA_SLOT_SIZE_BYTES = 8;
    private static final VarHandle VH_address = C_POINTER.varHandle();

    private static final VaList EMPTY = new SharedUtils.EmptyVaList(MemoryAddress.NULL);

    private MemorySegment segment;
    private final ResourceScope scope;

    private WinVaList(MemorySegment segment, ResourceScope scope) {
        this.segment = segment;
        this.scope = scope;
    }

    public static final VaList empty() {
        return EMPTY;
    }

    @Override
    public int nextVarg(ValueLayout.OfInt layout) {
        return (int) read(int.class, layout);
    }

    @Override
    public long nextVarg(ValueLayout.OfLong layout) {
        return (long) read(long.class, layout);
    }

    @Override
    public double nextVarg(ValueLayout.OfDouble layout) {
        return (double) read(double.class, layout);
    }

    @Override
    public MemoryAddress nextVarg(ValueLayout.OfAddress layout) {
        return (MemoryAddress) read(MemoryAddress.class, layout);
    }

    @Override
    public MemorySegment nextVarg(GroupLayout layout, SegmentAllocator allocator) {
        Objects.requireNonNull(allocator);
        return (MemorySegment) read(MemorySegment.class, layout, allocator);
    }

    private Object read(Class<?> carrier, MemoryLayout layout) {
        return read(carrier, layout, SharedUtils.THROWING_ALLOCATOR);
    }

    private Object read(Class<?> carrier, MemoryLayout layout, SegmentAllocator allocator) {
        Objects.requireNonNull(layout);
        Object res;
        if (carrier == MemorySegment.class) {
            TypeClass typeClass = TypeClass.typeClassFor(layout, false);
            res = switch (typeClass) {
                case STRUCT_REFERENCE -> {
                    MemoryAddress structAddr = (MemoryAddress) VH_address.get(segment);
                    MemorySegment struct = MemorySegment.ofAddress(structAddr, layout.byteSize(), scope());
                    MemorySegment seg = allocator.allocate(layout);
                    seg.copyFrom(struct);
                    yield seg;
                }
                case STRUCT_REGISTER ->
                    allocator.allocate(layout).copyFrom(segment.asSlice(0, layout.byteSize()));
                default -> throw new IllegalStateException("Unexpected TypeClass: " + typeClass);
            };
        } else {
            VarHandle reader = layout.varHandle();
            res = reader.get(segment);
        }
        segment = segment.asSlice(VA_SLOT_SIZE_BYTES);
        return res;
    }

    @Override
    public void skip(MemoryLayout... layouts) {
        Objects.requireNonNull(layouts);
        ((ResourceScopeImpl)scope).checkValidStateSlow();
        Stream.of(layouts).forEach(Objects::requireNonNull);
        segment = segment.asSlice(layouts.length * VA_SLOT_SIZE_BYTES);
    }

    static WinVaList ofAddress(MemoryAddress addr, ResourceScope scope) {
        MemorySegment segment = MemorySegment.ofAddress(addr, Long.MAX_VALUE, scope);
        return new WinVaList(segment, scope);
    }

    static Builder builder(ResourceScope scope) {
        return new Builder(scope);
    }

    @Override
    public ResourceScope scope() {
        return scope;
    }

    @Override
    public VaList copy() {
        ((ResourceScopeImpl)scope).checkValidStateSlow();
        return new WinVaList(segment, scope);
    }

    @Override
    public MemoryAddress address() {
        return segment.address();
    }

    public static non-sealed class Builder implements VaList.Builder {

        private final ResourceScope scope;
        private final List<SimpleVaArg> args = new ArrayList<>();

        public Builder(ResourceScope scope) {
            ((ResourceScopeImpl)scope).checkValidStateSlow();
            this.scope = scope;
        }

        private Builder arg(Class<?> carrier, MemoryLayout layout, Object value) {
            Objects.requireNonNull(layout);
            Objects.requireNonNull(value);
            args.add(new SimpleVaArg(carrier, layout, value));
            return this;
        }

        @Override
        public Builder addVarg(ValueLayout.OfInt layout, int value) {
            return arg(int.class, layout, value);
        }

        @Override
        public Builder addVarg(ValueLayout.OfLong layout, long value) {
            return arg(long.class, layout, value);
        }

        @Override
        public Builder addVarg(ValueLayout.OfDouble layout, double value) {
            return arg(double.class, layout, value);
        }

        @Override
        public Builder addVarg(ValueLayout.OfAddress layout, Addressable value) {
            return arg(MemoryAddress.class, layout, value.address());
        }

        @Override
        public Builder addVarg(GroupLayout layout, MemorySegment value) {
            return arg(MemorySegment.class, layout, value);
        }

        public VaList build() {
            if (args.isEmpty()) {
                return EMPTY;
            }
            SegmentAllocator allocator = SegmentAllocator.newNativeArena(scope);
            MemorySegment segment = allocator.allocate(VA_SLOT_SIZE_BYTES * args.size());
            List<MemorySegment> attachedSegments = new ArrayList<>();
            attachedSegments.add(segment);
            MemorySegment cursor = segment;

            for (SimpleVaArg arg : args) {
                if (arg.carrier == MemorySegment.class) {
                    MemorySegment msArg = ((MemorySegment) arg.value);
                    TypeClass typeClass = TypeClass.typeClassFor(arg.layout, false);
                    switch (typeClass) {
                        case STRUCT_REFERENCE -> {
                            MemorySegment copy = allocator.allocate(arg.layout);
                            copy.copyFrom(msArg); // by-value
                            attachedSegments.add(copy);
                            VH_address.set(cursor, copy.address());
                        }
                        case STRUCT_REGISTER ->
                            cursor.copyFrom(msArg.asSlice(0, VA_SLOT_SIZE_BYTES));
                        default -> throw new IllegalStateException("Unexpected TypeClass: " + typeClass);
                    }
                } else {
                    VarHandle writer = arg.varHandle();
                    writer.set(cursor, arg.value);
                }
                cursor = cursor.asSlice(VA_SLOT_SIZE_BYTES);
            }

            return new WinVaList(segment, scope);
        }
    }
}
