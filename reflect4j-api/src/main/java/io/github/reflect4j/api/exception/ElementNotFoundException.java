package io.github.reflect4j.api.exception;

/// # ElementNotFoundException
///
/// Exception thrown when a requested element is not found.
/// Extends ReflectionException to maintain consistent runtime exception behavior.
///
/// @author Aliabbos Ashurov
/// @since 23/10/25
public class ElementNotFoundException extends ReflectionException {

    public ElementNotFoundException(String message) {
        super(message);
    }

    public ElementNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public ElementNotFoundException(Throwable cause) {
        super(cause);
    }
}
