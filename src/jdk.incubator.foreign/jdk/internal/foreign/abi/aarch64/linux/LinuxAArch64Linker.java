/*
 * Copyright (c) 2020, 2021, Oracle and/or its affiliates. All rights reserved.
 * Copyright (c) 2019, 2021, Arm Limited. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
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
package jdk.internal.foreign.abi.aarch64.linux;

import jdk.incubator.foreign.CLinker;
import jdk.incubator.foreign.FunctionDescriptor;
import jdk.incubator.foreign.MemoryAddress;
import jdk.incubator.foreign.MemorySegment;
import jdk.incubator.foreign.NativeSymbol;
import jdk.incubator.foreign.ResourceScope;
import jdk.incubator.foreign.VaList;
import jdk.internal.foreign.abi.SharedUtils;
import jdk.internal.foreign.abi.aarch64.CallArranger;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.util.Objects;
import java.util.function.Consumer;

/**
 * ABI implementation based on ARM document "Procedure Call Standard for
 * the ARM 64-bit Architecture".
 */
public final class LinuxAArch64Linker implements CLinker {
    private static LinuxAArch64Linker instance;

    static final long ADDRESS_SIZE = 64; // bits

    public static LinuxAArch64Linker getInstance() {
        if (instance == null) {
            instance = new LinuxAArch64Linker();
        }
        return instance;
    }

    @Override
    public final MethodHandle downcallHandle(FunctionDescriptor function) {
        Objects.requireNonNull(function);
        MethodType type = SharedUtils.inferMethodType(function, false);
        MethodHandle handle = CallArranger.LINUX.arrangeDowncall(type, function);
        if (!type.returnType().equals(MemorySegment.class)) {
            // not returning segment, just insert a throwing allocator
            handle = MethodHandles.insertArguments(handle, 1, SharedUtils.THROWING_ALLOCATOR);
        }
        return SharedUtils.wrapDowncall(handle, function);
    }

    @Override
    public final NativeSymbol upcallStub(MethodHandle target, FunctionDescriptor function, ResourceScope scope) {
        Objects.requireNonNull(scope);
        Objects.requireNonNull(target);
        Objects.requireNonNull(function);
        SharedUtils.checkExceptions(target);
        MethodType type = SharedUtils.inferMethodType(function, true);
        if (!type.equals(target.type())) {
            throw new IllegalArgumentException("Wrong method handle type: " + target.type());
        }
        return CallArranger.LINUX.arrangeUpcall(target, target.type(), function, scope);
    }

    public static VaList newVaList(Consumer<VaList.Builder> actions, ResourceScope scope) {
        LinuxAArch64VaList.Builder builder = LinuxAArch64VaList.builder(scope);
        actions.accept(builder);
        return builder.build();
    }

    public static VaList newVaListOfAddress(MemoryAddress ma, ResourceScope scope) {
        return LinuxAArch64VaList.ofAddress(ma, scope);
    }

    public static VaList emptyVaList() {
        return LinuxAArch64VaList.empty();
    }

}
