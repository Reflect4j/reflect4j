package io.github.reflect4j.api.descriptor;

/// # MemberDescriptor
///
/// Represents a reflective descriptor for class members such as fields,
/// methods, and constructors. A `MemberDescriptor` extends
/// [AnnotatedElementDescriptor] to provide both annotation access
/// and member-specific metadata.
///
/// This abstraction unifies access to core reflective information such as:
/// - The declaring class in which the member is defined
/// - The raw modifier bit mask, as defined in [java.lang.reflect.Modifier]
/// - Annotations present on the member
///
/// Implementations are intended to wrap instances of
/// [java.lang.reflect.Member] and expose a uniform, type-safe API
/// for reflective analysis and invocation.
///
/// @param <T> the underlying reflective type (e.g., [java.lang.reflect.Method], [java.lang.reflect.Field], or [java.lang.reflect.Constructor])
///
/// @author Aliabbos Ashurov
/// @since 1.0.0
public interface MemberDescriptor<T> extends AnnotatedElementDescriptor<T> {

    /// Returns the class in which this member is declared.
    ///
    /// For example:
    /// - For a field: the class that declares the field
    /// - For a method: the class that declares the method
    /// - For a constructor: the class in which the constructor is defined
    ///
    /// @return the declaring [Class]; never `null`
    Class<?> getDeclaringClass();

    /// Returns the raw modifier bit mask of this member.
    ///
    /// The returned value corresponds to constants defined in
    /// [java.lang.reflect.Modifier]. It may be used to determine
    /// properties such as visibility (`public`, `protected`, `private`),
    /// whether the member is `static` or `final`, and other modifier flags.
    ///
    /// @return the modifier bit mask
    /// @see java.lang.reflect.Modifier
    int getModifiers();
}
