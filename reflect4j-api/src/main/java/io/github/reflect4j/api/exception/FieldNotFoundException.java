package io.github.reflect4j.api.exception;

/// # FieldNotFoundException
///
/// Exception thrown when a requested field cannot be found in a class.
/// Extends [ElementNotFoundException] for consistent runtime exception handling.
///
/// @author Aliabbos Ashurov
/// @since 2025-09-19
public class FieldNotFoundException extends ElementNotFoundException {

    /// Creates an exception with the specified class and field name.
    public FieldNotFoundException(Class<?> clazz, String fieldName) {
        super("Field '" + fieldName + "' not found in class: " + clazz.getName());
    }

    public FieldNotFoundException(String message) {
        super(message);
    }

    public FieldNotFoundException(Throwable cause) {
        super(cause);
    }

    public FieldNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
