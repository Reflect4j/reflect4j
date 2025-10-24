package io.github.reflect4j.api.exception;

/// # ClassInstantiationException
///
/// Exception thrown when a class cannot be instantiated.
/// Extends ReflectionException for consistent runtime exception handling.
///
/// @author Aliabbos Ashurov
/// @since 2025-09-28
public class ClassInstantiationException extends ReflectionException {

    /// Creates an exception with a message including the class and the root cause.
    public ClassInstantiationException(Class<?> clazz, Throwable cause) {
        super("Failed to instantiate class: " + clazz.getName(), cause);
    }

    public ClassInstantiationException(String message) {
        super(message);
    }

    public ClassInstantiationException(Throwable cause) {
        super(cause);
    }
}
