package io.github.reflect4j.api.exception;

/// # ClassNotFoundRuntimeException
///
/// Exception thrown when a requested class cannot be found at runtime.
/// Extends [ElementNotFoundException] for consistent runtime exception handling.
/// Lightweight, immutable, and safe for production.
///
/// @author Aliabbos Ashurov
/// @since 2025-09-28
public class ClassNotFoundRuntimeException extends ElementNotFoundException {

    /// Creates an exception with the specified class name and cause.
    public ClassNotFoundRuntimeException(String className, Throwable cause) {
        super("Class not found: " + className, cause);
    }
    
    public ClassNotFoundRuntimeException(String message) {
        super(message);
    }

    public ClassNotFoundRuntimeException(Throwable cause) {
        super(cause);
    }
}
