package io.github.reflect4j.api.exception;

import java.util.Arrays;

/// # ConstructorNotFoundException
///
/// Exception thrown when a suitable constructor cannot be found for a class.
/// Extends [ElementNotFoundException] for consistent runtime exception handling.
///
/// @author Aliabbos Ashurov
/// @since 2025-09-19
public class ConstructorNotFoundException extends ElementNotFoundException {

    /// Creates an exception with the specified class and parameter types.
    public ConstructorNotFoundException(Class<?> clazz, Class<?>[] params) {
        super("No suitable constructor found for class: "
                + clazz.getName()
                + " with parameter types: "
                + Arrays.toString(params));
    }

    public ConstructorNotFoundException(String message) {
        super(message);
    }

    public ConstructorNotFoundException(Throwable cause) {
        super(cause);
    }

    public ConstructorNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}

