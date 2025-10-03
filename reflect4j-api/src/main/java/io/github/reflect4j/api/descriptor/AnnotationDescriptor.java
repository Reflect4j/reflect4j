package io.github.reflect4j.api.descriptor;

import io.github.reflect4j.api.assertion.AnnotationAssertion;

import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Map;

/// # AnnotationDescriptor
///
/// Represents a descriptor for an annotation instance or annotation type.
///
/// Provides type-safe access to the annotation's metadata, including its type, attributes,
/// and meta-annotations (e.g., [java.lang.annotation.Retention], [java.lang.annotation.Target]).
///
/// This interface supports both low-level reflective access and high-level operations such as
/// signature-based queries, default values, and fluent inspection of meta-annotations.
///
/// @param <T> the annotation type represented by this descriptor
///
/// @author Aliabbos Ashurov
/// @since 1.0.0
public interface AnnotationDescriptor<T extends Annotation> extends Descriptor<T> {

    /// Returns the annotation type of this descriptor.
    ///
    /// @return the `Class` object representing the annotation type; never `null`
    Class<? extends Annotation> getAnnotationType();

    /// Returns a descriptor for the meta-annotation matching the specified fully-qualified signature
    /// if present on this annotation's type.
    ///
    /// This method enables **compile-time and runtime independence** from the meta-annotation class.
    /// The annotation class is resolved dynamically using the provided signature; if it is not present
    /// on the classpath, an empty descriptor (for which [#isPresent()] returns `false`)
    /// is returned instead of throwing an exception.
    ///
    /// The signature **must** include the "@" prefix (e.g., "@java.lang.annotation.Retention").
    ///
    /// @param signature the fully-qualified meta-annotation class name with "@" prefix; must not be `null`
    ///
    /// @return an [AnnotationDescriptor] for the meta-annotation if both the annotation type
    ///         and the meta-annotation are present and resolvable; otherwise, an empty descriptor
    ///         (never `null`)
    /// @throws NullPointerException                                        if the signature is `null`
    /// @throws io.github.reflect4j.api.exception.InvalidSignatureException if the signature does not start with "@"
    AnnotationDescriptor<?> getMetaAnnotation(String signature);

    /// Returns a descriptor for the meta-annotation of the specified type if present on this annotation's type.
    ///
    /// This method provides type-safe access when the meta-annotation class is available at compile time.
    /// If the meta-annotation is not present, an empty descriptor (for which [#isPresent()] returns
    /// `false`) is returned.
    ///
    /// @param <A>            the meta-annotation type
    /// @param annotationType the meta-annotation class to look for; must not be `null`
    ///
    /// @return an [AnnotationDescriptor] of type `A` if the meta-annotation is present;
    ///         otherwise, an empty descriptor (never `null`)
    /// @throws NullPointerException if the annotationType is `null`
    <A extends Annotation> AnnotationDescriptor<A> getMetaAnnotation(Class<A> annotationType);

    /// Returns descriptors for all meta-annotations present on this annotation's type.
    ///
    /// The returned list is **immutable**; attempts to modify it will result in
    /// [UnsupportedOperationException]. Implementations must return an unmodifiable view,
    /// for example by using [java.util.Collections#unmodifiableList(List)] or
    /// [java.util.List#copyOf(java.util.Collection)].
    ///
    /// Each descriptor in the list supports full introspection, including attribute access and
    /// nested meta-annotation queries, regardless of whether the annotation classes are present
    /// on the classpath (subject to implementation capabilities).
    ///
    /// @return an immutable list of [AnnotationDescriptor] instances, never `null`
    List<? extends AnnotationDescriptor<?>> getMetaAnnotations();

    /// Determines whether the annotation type is annotated with the specified meta-annotation type.
    ///
    /// @param annotationType the meta-annotation class to check; must not be `null`
    ///
    /// @return `true` if the meta-annotation is present, `false` otherwise
    /// @throws NullPointerException if the annotationType is `null`
    boolean hasMetaAnnotation(Class<? extends Annotation> annotationType);

    /// Determines whether the annotation type is annotated with an annotation
    /// matching the given fully-qualified signature.
    ///
    /// This allows for querying annotations without requiring a compile-time dependency
    /// on their classes. The signature **must** include the "@" prefix.
    /// For example: `"@java.lang.Override"`.
    ///
    /// @param signature the fully-qualified annotation class name, including "@"; must not be `null`
    ///
    /// @return `true` if a matching meta-annotation is present, `false` otherwise
    /// @throws NullPointerException                                        if the signature is `null`
    /// @throws io.github.reflect4j.api.exception.InvalidSignatureException if the signature does not start with "@"
    boolean hasMetaAnnotation(String signature);

    /// Returns the value of the specified annotation attribute.
    ///
    /// Type-safe access to annotation elements. If the attribute is absent and has no default,
    /// this method returns `null`.
    ///
    /// @param name the attribute name (method name in the annotation); must not be `null`
    /// @param type the expected type of the attribute value; must not be `null`
    /// @param <R>  the expected return type
    ///
    /// @return the value of the attribute, or `null` if not present and no default
    /// @throws NullPointerException if the name or type is `null`
    <R> R attribute(String name, Class<R> type);

    /// Returns the value of the specified annotation attribute, or the provided default if absent.
    ///
    /// @param name         the attribute name (method name in the annotation); must not be `null`
    /// @param type         the expected type of the attribute value; must not be `null`
    /// @param defaultValue the value to return if the attribute is missing
    /// @param <R>          the expected return type
    ///
    /// @throws NullPointerException if the name or type is `null`
    <R> R attribute(String name, Class<R> type, R defaultValue);

    /// Returns all annotation attributes and their corresponding values.
    ///
    /// The returned map includes all attributes declared on the annotation, including
    /// default values where applicable. The map is immutable.
    ///
    /// @return an immutable map from attribute name to value; never `null`
    Map<String, Object> attributes();

    /// Returns an assertion view over this annotation descriptor.
    ///
    /// The assertion view is type-safe and bound to the generic annotation
    /// type `T`, ensuring that attribute values and type checks are
    /// consistent with the descriptor's annotation.
    ///
    /// @return a non-`null` [AnnotationAssertion] bound to this descriptor
    @Override
    AnnotationAssertion<T> toAssertion();

    /// Casts the annotation type to the specified target type.
    ///
    /// @param targetType the target class to cast to; must not be `null`
    /// @param <R>        the target type
    ///
    /// @return the annotation type cast to `R`
    /// @throws NullPointerException if the targetType is `null`
    /// @throws ClassCastException   if the annotation type cannot be cast to `R`
    default <R> R cast(Class<R> targetType) {
        return targetType.cast(getAnnotationType());
    }
}
