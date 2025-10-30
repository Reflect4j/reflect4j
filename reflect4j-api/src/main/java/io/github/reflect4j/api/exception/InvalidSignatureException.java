package io.github.reflect4j.api.exception;

/// # InvalidSignatureException
///
/// @author Aliabbos Ashurov
/// @since 2025-09-19
public class InvalidSignatureException extends ReflectionException {

    public InvalidSignatureException(String message) {
        super(message);
    }

    public InvalidSignatureException(Throwable cause) {
        super(cause);
    }

    public InvalidSignatureException(String message, Throwable cause) {
        super(message, cause);
    }
}