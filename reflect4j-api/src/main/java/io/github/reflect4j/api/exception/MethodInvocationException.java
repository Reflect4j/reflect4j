package io.github.reflect4j.api.exception;

/// # MethodInvocationException
///
/// Exception thrown when invoking a method fails at runtime.
/// Extends [ReflectionException] for consistent runtime exception handling.
///
/// @author Aliabbos Ashurov
/// @since 2025-09-28
public class MethodInvocationException extends ReflectionException {

    public MethodInvocationException(String message) {
        super(message);
    }

    public MethodInvocationException(Throwable cause) {
        super(cause);
    }

    public MethodInvocationException(String message, Throwable cause) {
        super(message, cause);
    }
}
