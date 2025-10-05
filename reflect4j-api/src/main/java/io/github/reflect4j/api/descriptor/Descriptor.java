package io.github.reflect4j.api.descriptor;

import io.github.reflect4j.api.assertion.Assertion;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.Stream;

/// # Descriptor
///
/// Base abstraction for all descriptors in the reflection library.
///
/// A `Descriptor` wraps a reflective Java element (e.g. [java.lang.reflect.Method],
/// [java.lang.reflect.Field], [java.lang.Class], etc.)
/// and provides a uniform, type-safe API for accessing its metadata.
///
/// Descriptors are intended to be lightweight wrappers around reflection types
/// and can be freely created or discarded by clients.
///
/// @param <T> the underlying reflective type (e.g., `Method`, `Field`, `Class`, etc.)
///
/// @author Aliabbos Ashurov
/// @since 1.0.0
public interface Descriptor<T> {

    /// Returns the simple name of the underlying element.
    ///
    ///     - For classes: the simple class name.
    ///     - For methods/fields/constructors: the declared member name.
    ///     - For annotations: the annotation type name.
    ///
    /// @return the simple name, never `null`
    String getName();

    /// Returns the unique signature of this descriptor.
    ///
    /// The signature is a stable, fully qualified textual representation
    /// of the underlying element. Its format depends on the descriptor type:
    ///
    ///     - For a [ClassDescriptor]:
    ///     <pre>`com.example.MyClass`</pre>
    ///
    ///     - For a [FieldDescriptor]:
    ///     <pre>`com.example.MyClass#fieldName:java.lang.String`</pre>
    ///
    ///     - For a [MethodDescriptor]:
    ///     <pre>`com.example.MyClass#process(java.lang.String, int):void`</pre>
    ///
    ///     - For a [ConstructorDescriptor]:
    ///     <pre>`com.example.MyClass(int, java.lang.String)`</pre>
    ///
    ///     - For an [AnnotationDescriptor]:
    ///     <pre>`@com.example.MyAnnotation(value="some")`</pre>
    ///
    /// Signatures are intended for identity, comparison, and lookup purposes.
    /// They are guaranteed to be non-`null`, but the exact formatting is
    /// implementation-defined and may evolve while preserving uniqueness.
    ///
    /// @return the unique signature of this descriptor; never `null`
    String getSignature();

    /// Returns the underlying reflection element, or `null` if absent.
    ///
    /// @return the wrapped reflection object, possibly `null`
    T unwrap();

    /// Converts this descriptor into an [Assertion] for fluent assertion-style checks.
    ///
    /// For example, a [MethodDescriptor] would return a `MethodAssertion`,
    ///
    /// @return an `Assertion` corresponding to this descriptor; never `null`
    Assertion<T> toAssertion();

    /// Returns an [Optional](https://docs.oracle.com/en/java/javase/25/docs/api/java.base/java/util/Optional.html) of the underlying element.
    ///
    /// Useful for functional-style or safe access patterns.
    ///
    /// @return an `Optional` wrapping the underlying element; never `null`
    default Optional<T> toOptional() {
        return Optional.ofNullable(unwrap());
    }

    /// Executes the given consumer if the underlying element is present.
    ///
    /// @param action the action to perform if present; must not be `null`
    default void ifPresent(Consumer<? super T> action) {
        toOptional().ifPresent(action);
    }

    /// Returns a [Stream](https://docs.oracle.com/en/java/javase/25/docs/api/java.base/java/util/stream/Stream.html) containing the underlying element if present,
    /// or an empty stream if the element is `null`.
    ///
    /// This enables fluent streaming pipelines on single descriptors.
    ///
    /// @return a stream containing the element or empty if absent; never `null`
    default Stream<T> stream() {
        return toOptional().stream();
    }

    /// Returns whether the underlying element is non-null.
    ///
    /// @return `true` if present, `false` otherwise
    default boolean isPresent() {
        return unwrap() != null;
    }
}