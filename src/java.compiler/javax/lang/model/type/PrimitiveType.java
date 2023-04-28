/*
 * Copyright (c) 2005, 2021, Oracle and/or its affiliates. All rights reserved.
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

package javax.lang.model.type;


/**
 * Represents a primitive type.  These include
 * {@code boolean}, {@code byte}, {@code short}, {@code int},
 * {@code long}, {@code char}, {@code float}, and {@code double}.
 *
 * @author Joseph D. Darcy
 * @author Scott Seligman
 * @author Peter von der Ah&eacute;
 * @jls 4.2 Primitive Types and Values
 * @see javax.lang.model.util.Types#getPrimitiveType(TypeKind)
 * @since 1.6
 */
public interface PrimitiveType extends TypeMirror {
}
