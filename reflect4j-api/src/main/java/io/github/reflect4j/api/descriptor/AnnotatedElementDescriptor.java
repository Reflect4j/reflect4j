package io.github.reflect4j.api.descriptor;

import java.lang.annotation.Annotation;
import java.util.List;

/// # AnnotatedElementDescriptor
///
/// Common abstraction for descriptors representing class members such as fields,
/// methods, constructors, and classes.
///
/// Provides uniform access to annotations via rich [AnnotationDescriptor]
/// wrappers, enabling type-safe inspection, signature-based lookup (without compile-time
/// dependencies), and fluent assertions. All annotation-related operations are defined
/// here to avoid duplication in subclasses.
///
/// @param <T> the underlying reflective type (e.g., [java.lang.reflect.Method])
///
/// @author Aliabbos Ashurov
/// @since 1.0.0
public interface AnnotatedElementDescriptor<T> extends Descriptor<T> {

    /// Returns a descriptor for the annotation of the specified type if present on this element.
    ///
    /// This method provides type-safe access when the annotation class is available at compile time.
    /// If the annotation is not present, an empty descriptor (for which [#isPresent()]
    /// returns `false`) is returned.
    ///
    /// @param <A>  the annotation type
    /// @param type the annotation class to look for; must not be `null`
    ///
    /// @return an [AnnotationDescriptor] of type `A` if the annotation is present;
    ///         otherwise, an empty descriptor (never `null`)
    /// @throws NullPointerException if the type is `null`
    <A extends Annotation> AnnotationDescriptor<A> getAnnotation(Class<A> type);

    /// Returns a descriptor for the annotation matching the specified fully qualified class name
    /// if present on this element.
    ///
    /// This enables **compile-time and runtime independence** from the annotation class.
    /// The annotation class is resolved dynamically using the provided name; if it is not present
    /// on the classpath, an empty descriptor is returned instead of throwing an exception.
    ///
    /// The signature **must** be a fully qualified annotation class name **prefixed with '@'**,
    /// for example: `"@java.lang.Override"`.
    ///
    /// If the signature does not start with the '@' character, an [io.github.reflect4j.api.exception.InvalidSignatureException]
    /// is thrown immediately to prevent ambiguous or incorrect usage.
    ///
    /// @param signature the fully qualified annotation class name; must not be `null`
    ///
    /// @return an [AnnotationDescriptor] for the annotation if both the element and the
    ///         annotation class are resolvable; otherwise, an empty descriptor (never `null`)
    /// @throws NullPointerException                                        if the signature is `null`
    /// @throws io.github.reflect4j.api.exception.InvalidSignatureException if the signature does not start with "@"
    AnnotationDescriptor<?> getAnnotation(String signature);

    /// Returns whether an annotation of the specified type is present on this element.
    ///
    /// @param <A>  the annotation type
    /// @param type the annotation class to check; must not be `null`
    ///
    /// @return `true` if the annotation is present, `false` otherwise
    /// @throws NullPointerException if the type is `null`
    <A extends Annotation> boolean hasAnnotation(Class<A> type);

    /// Returns whether an annotation matching the specified signature is present on this element.
    ///
    /// This method supports **zero-dependency checks**: it returns `false` if the annotation
    /// class is not present on the classpath, rather than throwing an exception.
    ///
    /// The signature **must** be a fully qualified annotation class name **prefixed with '@'**,
    /// for example: `"@java.lang.Deprecated"`.
    ///
    /// If the signature does not start with `@`, an [io.github.reflect4j.api.exception.InvalidSignatureException] is thrown.
    ///
    /// @param signature the fully qualified annotation class name; must not be `null`
    ///
    /// @return `true` if the annotation is present and resolvable, `false` otherwise
    /// @throws NullPointerException                                        if the signature is `null`
    /// @throws io.github.reflect4j.api.exception.InvalidSignatureException if the signature does not start with "@"
    boolean hasAnnotation(String signature);

    /// Returns descriptors for all annotations present on this element.
    ///
    /// The returned list is **immutable**; attempts to modify it will result in
    /// [UnsupportedOperationException]. Implementations must return an unmodifiable view,
    /// for example by using [java.util.Collections#unmodifiableList(List)] or
    /// [java.util.List#copyOf(java.util.Collection)].
    ///
    /// Each descriptor supports full introspection (attributes, meta-annotations, assertions),
    /// even if the annotation classes are not present on the classpath (subject to implementation).
    ///
    /// @return an immutable list of [AnnotationDescriptor] instances, never `null`
    List<? extends AnnotationDescriptor<?>> getAnnotations();
}
