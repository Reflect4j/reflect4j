package io.github.reflect4j.api.descriptor;

import io.github.reflect4j.api.invoke.FieldAccessResult;

import java.lang.reflect.Field;

/// # FieldDescriptor
///
/// Represents a descriptor for a [Field].
///
/// Provides metadata access and reflective operations for fields, including
/// type information, modifiers, and get/set operations. This interface extends
/// [MemberDescriptor] to inherit common member behavior such as declaring
/// class and annotations.
///
/// Implementations are intended to wrap a [Field] and provide a type-safe,
/// fluent API for accessing and manipulating field data. Field operations return
/// [FieldAccessResult] objects, which encapsulate both the value and any
/// exception thrown during access, enabling safe and functional-style handling.
///
/// @author Aliabbos Ashurov
/// @since 1.0.0
public interface FieldDescriptor extends MemberDescriptor<Field> {

    /// Returns the type of this field.
    ///
    /// @return the [Class] representing the field type; never `null`
    Class<?> getType();

    /// Sets the value of this field on the specified object instance.
    ///
    /// The operation returns a [FieldAccessResult] that encapsulates
    /// the result of the set operation and any exception thrown during execution.
    ///
    /// @param <T>   the type of the value to set
    /// @param obj   the target object on which to set the field; `null` if static
    /// @param value the value to set
    ///
    /// @return a [FieldAccessResult] representing the outcome; never `null`
    /// @throws NullPointerException if value is `null` for a non-nullable field type
    <T> FieldAccessResult<T> set(Object obj, T value);

    /// Retrieves the value of this field from the specified object instance.
    ///
    /// @param obj the target object from which to retrieve the field value; `null` if static
    ///
    /// @return the field value
    Object get(Object obj);

    /// Returns whether this field is declared `static`.
    ///
    /// @return `true` if this field is static, `false` otherwise
    boolean isStatic();

    /// Returns whether this field is declared `final`.
    ///
    /// @return `true` if this field is final, `false` otherwise
    boolean isFinal();

    /// Returns whether this field is declared `volatile`.
    ///
    /// @return `true` if this field is volatile, `false` otherwise
    boolean isVolatile();

    /// Returns whether this field is declared `transient`.
    ///
    /// @return `true` if this field is transient, `false` otherwise
    boolean isTransient();

    /// Returns whether this field is `public`.
    ///
    /// @return `true` if public, `false` otherwise
    boolean isPublic();

    /// Returns whether this field is `protected`.
    ///
    /// @return `true` if protected, `false` otherwise
    boolean isProtected();

    /// Returns whether this field is `private`.
    ///
    /// @return `true` if private, `false` otherwise
    boolean isPrivate();

    /// Returns whether this field has package-private (default) access.
    ///
    /// A field is package-private if it has no explicit access modifier.
    ///
    /// @return `true` if package-private, `false` otherwise
    boolean isPackagePrivate();
}
