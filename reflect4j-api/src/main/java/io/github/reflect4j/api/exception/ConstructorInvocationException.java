package io.github.reflect4j.api.exception;

/// # ConstructorInvocationException
///
/// Exception thrown when invoking a constructor fails at runtime.
/// Extends [ReflectionException] for consistent runtime exception handling.
///
/// @author Aliabbos Ashurov
/// @since 2025-09-28
public class ConstructorInvocationException extends ReflectionException {

    /// Creates an exception with the specified class and root cause.
    public ConstructorInvocationException(Class<?> clazz, Throwable cause) {
        super("Failed to invoke constructor for class: " + clazz.getName(), cause);
    }

    public ConstructorInvocationException(String message) {
        super(message);
    }

    public ConstructorInvocationException(Throwable cause) {
        super(cause);
    }
}