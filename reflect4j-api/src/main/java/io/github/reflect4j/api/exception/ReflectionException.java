package io.github.reflect4j.api.exception;

import java.io.Serial;

/// Base class for all Reflect4j runtime exceptions.
///
/// Extends [RuntimeException] to avoid forcing checked exception handling
/// in client code, following best practices of libraries like Spring and Hibernate.
///
/// @author Aliabbos Ashurov
/// @since 2025-09-28
public class ReflectionException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1L;
    
    public ReflectionException(String message) {
        super(message);
    }
    
    public ReflectionException(String message, Throwable cause) {
        super(message, cause);
    }
    
    public ReflectionException(Throwable cause) {
        super(cause);
    }

    /// Lightweight version: no stack trace creation for high-performance scenarios.
    /// Uncomment only if you are creating exceptions in tight loops.
    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
}
