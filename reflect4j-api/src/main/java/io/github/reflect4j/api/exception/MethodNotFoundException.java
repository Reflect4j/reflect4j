package io.github.reflect4j.api.exception;

/// # MethodNotFoundException
///
/// Exception thrown when a requested method cannot be found in a class.
/// Extends [ElementNotFoundException] for consistent runtime exception handling.
///
/// @author Aliabbos Ashurov
/// @since 2025-09-19
public class MethodNotFoundException extends ElementNotFoundException {

    public MethodNotFoundException(Class<?> clazz, String methodName) {
        super("Method '" + methodName + "' not found in class: " + clazz.getName());
    }

    public MethodNotFoundException(String message) {
        super(message);
    }

    public MethodNotFoundException(Throwable cause) {
        super(cause);
    }

    public MethodNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
