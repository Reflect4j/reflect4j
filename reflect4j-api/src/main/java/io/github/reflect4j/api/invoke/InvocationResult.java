package io.github.reflect4j.api.invoke;

/// # InvocationResult
///
/// Represents the result of a reflective invocation operation, such as a
/// method call, constructor invocation, or field access.
///
/// Provides a unified way to access the result value, check for exceptions,
/// and determine whether the operation succeeded.
///
/// @param <T> the type of the value produced by the operation (method return type, constructor instance type, or field type)
///
/// @author Aliabbos Ashurov
/// @since 1.0.0
///
public interface InvocationResult<T> {

    /// Returns the actual result value of this operation.
    ///
    /// For methods, this is the return value. For constructors, it is the
    /// created instance. For fields, it is the field value. Returns `null`
    /// if the operation failed or the result is void.
    ///
    /// @return the result value, or `null` if the operation failed or is void
    T getValue();

    /// Returns the exception thrown during the operation, if any.
    ///
    /// If the operation completed successfully, this method returns `null`.
    /// Checked exceptions are typically wrapped as unchecked exceptions by the library.
    ///
    /// @return the exception thrown during the operation, or `null` if successful
    Throwable getException();

    /// Returns whether the operation completed successfully without throwing an exception.
    ///
    /// @return `true` if the operation succeeded, `false` otherwise
    boolean isSuccess();
}
