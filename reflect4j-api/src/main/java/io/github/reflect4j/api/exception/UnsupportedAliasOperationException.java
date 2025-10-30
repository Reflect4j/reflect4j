package io.github.reflect4j.api.exception;

/// # UnsupportedAliasOperationException
///
/// Exception thrown when an unsupported alias operation is invoked.
/// Extends ReflectionException to maintain consistent runtime exception behavior.
///
/// @author Aliabbos Ashurov
/// @since 2025-10-02
public class UnsupportedAliasOperationException extends ReflectionException {

    public UnsupportedAliasOperationException(String message) {
        super(message);
    }

    public UnsupportedAliasOperationException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnsupportedAliasOperationException(Throwable cause) {
        super(cause);
    }
}
