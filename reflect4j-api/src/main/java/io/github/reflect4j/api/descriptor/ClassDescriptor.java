package io.github.reflect4j.api.descriptor;

import io.github.reflect4j.api.assertion.ClassAssertion;

import java.util.List;

/// # ClassDescriptor
///
/// A descriptor for a Java [Class] or interface.
///
/// Provides reflective access to type metadata, including fields, methods,
/// constructors, modifiers, superclasses, and implemented interfaces.
/// This abstraction unifies the representation of classes while enabling
/// type-safe queries, annotation inspection, and fluent assertions.
///
/// Single-element lookup methods such as [#getField(String)] and etc.
/// return `null` if the element is not found.
/// Bulk queries such as [#getFields()], [#getMethods()], and
/// [#getConstructors()] always return immutable, possibly empty lists.
///
/// @param <T> the type represented by this descriptor
///
/// @author Aliabbos Ashurov
/// @since 1.0.0
public interface ClassDescriptor<T> extends AnnotatedElementDescriptor<Class<T>> {

    /// Returns the package name of this class.
    ///
    /// @return the package name; never `null`
    String getPackageName();

    /// Returns the Java language modifiers for this class,
    /// encoded as in [java.lang.reflect.Modifier].
    ///
    /// @return the modifier bit mask
    int getModifiers();

    /// Returns the field with the given name if present.
    ///
    /// @param name the field name; must not be `null`
    ///
    /// @return an empty [FieldDescriptor] if not found; never `null`
    /// @throws NullPointerException if the name is `null`
    FieldDescriptor getField(String name);

    /// Returns all fields declared in this class.
    ///
    /// The returned list is immutable. If no fields are present,
    /// this method returns an empty list.
    ///
    /// @return an immutable list of field descriptors; never `null`
    List<FieldDescriptor> getFields();

    /// Returns a method matching the given signature if present.
    ///
    /// A signature must uniquely identify a method, typically combining
    /// its name and parameter types in a JVM-style descriptor form.
    ///
    /// @param signature the method signature; must not be `null`
    ///
    /// @return an empty [MethodDescriptor] if not found; never `null`
    /// @throws NullPointerException                                        if the signature is `null`
    /// @throws io.github.reflect4j.api.exception.InvalidSignatureException if the signature is not a valid JVM-style method descriptor
    MethodDescriptor getMethod(String signature);

    /// Returns the method with the given name and parameter types if present.
    ///
    /// @param name           the method name; must not be `null`
    /// @param parameterTypes the parameter types; must not be `null`
    ///
    /// @return an empty [MethodDescriptor] if not found; never `null`
    /// @throws NullPointerException if the name or parameterTypes is `null`
    MethodDescriptor getMethod(String name, Class<?>... parameterTypes);

    /// Returns all methods declared in this class.
    ///
    /// The returned list is immutable. If no methods are present,
    /// this method returns an empty list.
    ///
    /// @return an immutable list of method descriptors; never `null`
    List<MethodDescriptor> getMethods();

    /// Returns a constructor matching the given signature if present.
    ///
    /// @param signature the constructor signature; must not be `null`
    ///
    /// @return an empty [ConstructorDescriptor] if not found; never `null`
    /// @throws NullPointerException                                        if the signature is `null`
    /// @throws io.github.reflect4j.api.exception.InvalidSignatureException if the signature is not a valid JVM-style constructor descriptor
    ConstructorDescriptor<T> getConstructor(String signature);

    /// Returns the constructor with the specified parameter types if present.
    ///
    /// @param parameterTypes the constructor parameter types; must not be `null`
    ///
    /// @return an empty [ConstructorDescriptor] if not found; never `null`
    /// @throws NullPointerException if the parameterTypes is `null`
    ConstructorDescriptor<T> getConstructor(Class<?>... parameterTypes);

    /// Returns all constructors declared in this class.
    ///
    /// The returned list is immutable. If no constructors are present,
    /// this method returns an empty list.
    ///
    /// @return an immutable list of constructor descriptors; never `null`
    List<ConstructorDescriptor<T>> getConstructors();

    /// Returns whether this class is an interface.
    ///
    /// @return `true` if this class is an interface, `false` otherwise
    boolean isInterface();

    /// Returns whether this class is an enum type.
    ///
    /// @return `true` if this class is an enum, `false` otherwise
    boolean isEnum();

    /// Returns whether this class is an annotation type.
    ///
    /// @return `true` if this class is an annotation, `false` otherwise
    boolean isAnnotation();

    /// Returns whether this class is a record type.
    ///
    /// @return `true` if this class is a record, `false` otherwise
    boolean isRecord();

    /// Returns whether this class is abstract.
    ///
    /// @return `true` if this class is abstract, `false` otherwise
    boolean isAbstract();

    /// Returns whether this class is declared `final`.
    ///
    /// @return `true` if this class is final, `false` otherwise
    boolean isFinal();

    /// Returns whether this class is sealed.
    ///
    /// @return `true` if this class is sealed, `false` otherwise
    boolean isSealed();

    /// Returns whether this class is declared `public`.
    ///
    /// Top-level classes can be `public` or package-private.
    /// Nested classes may also be `private`, `protected`, or package-private.
    ///
    /// @return `true`f this class is public, `false` otherwise
    boolean isPublic();

    /// Returns whether this class is declared `protected`.
    ///
    /// Only nested classes can be `protected`.
    ///
    /// @return `true` if this class is protected`false` otherwise
    boolean isProtected();

    /// Returns whether this class is declared `private`.
    ///
    /// Only nested classes can be `private`.
    ///
    /// @return `true` if this class is private, `false` otherwise
    boolean isPrivate();

    /// Returns whether this class has package-private (default) access.
    ///
    /// A class is package-private if it has no explicit access modifier.
    ///
    /// @return `true` if this class is package-private, `false` otherwise
    boolean isPackagePrivate();

    /// Returns the direct superclass of this class as a descriptor, or an empty descriptor if none.
    ///
    /// For interfaces, primitive types, and `Object`, this method returns an empty descriptor
    /// (for which [#isPresent()] returns  `false`).
    ///
    /// @return the superclass descriptor; never`null``
    ClassDescriptor<?> getSuperclass();

    /// Returns descriptors for all interfaces implemented by this class.
    ///
    /// The returned list is immutable. If no interfaces are present,
    /// this method returns an empty list.
    ///
    /// @return an immutable list of interface descriptors; never `null`
    List<? extends ClassDescriptor<?>> getInterfaces();

    /// Returns an assertion view for this class descriptor.
    ///
    /// Assertions provide a fluent API for verifying structural
    /// and semantic properties of the class.
    ///
    /// @return the class assertion; never `null`
    @Override
    ClassAssertion<T> toAssertion();

    /// Casts this descriptor's underlying class to the specified target type.
    ///
    /// @param targetType the target type; must not be `null`
    /// @param <R>        the target type parameter
    ///
    /// @return the underlying [Class] cast to `R`
    /// @throws NullPointerException if the targetType is `null`
    /// @throws ClassCastException   if the underlying class cannot be cast to `R`
    default <R> R cast(Class<R> targetType) {
        return targetType.cast(unwrap());
    }
}
