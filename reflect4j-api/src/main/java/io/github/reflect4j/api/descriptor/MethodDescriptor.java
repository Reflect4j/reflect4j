package io.github.reflect4j.api.descriptor;

import io.github.reflect4j.api.assertion.MethodAssertion;
import io.github.reflect4j.api.invoke.MethodInvocationResult;

import java.lang.reflect.Method;
import java.util.List;

/// # MethodDescriptor
///
/// Represents a descriptor for a [Method].
///
/// Provides metadata and reflective operations for methods, including
/// return type, parameters, declared exceptions, and modifiers. This interface
/// extends [MemberDescriptor] to inherit common member behavior such as
/// declaring class and annotations.
///
/// Implementations are intended to wrap a [Method] and provide a type-safe,
/// fluent API for introspection and invocation. Method invocations return
/// [MethodInvocationResult] objects, which encapsulate both the return value
/// and any exception thrown during execution, enabling safe and functional-style
/// handling.
///
/// @author Aliabbos Ashurov
/// @since 1.0.0
public interface MethodDescriptor extends MemberDescriptor<Method> {

    /// Returns the return type of this method.
    ///
    /// @return the [Class] object representing the return type; never `null`
    Class<?> getReturnType();

    /// Returns the parameter types of this method, in declaration order.
    ///
    /// The returned list is immutable.
    ///
    /// @return a list of [Class] objects representing the parameter types; never `null`
    List<Class<?>> getParameterTypes();

    /// Returns the number of parameters accepted by this method.
    ///
    /// This includes all declared parameters, including varargs parameters
    /// (which count as a single parameter). For example, a method declared as
    /// `void process(String... args)` has a parameter count of `1`.
    ///
    /// This method provides a convenient and efficient alternative to
    /// [#getParameterTypes()].size()`.
    ///
    /// @return the number of parameters; always non-negative
    int getParameterCount();

    /// Returns whether this method accepts a variable number of arguments.
    ///
    /// @return `true` if this method has a varargs parameter, `false` otherwise
    boolean isVarArgs();

    /// Returns whether this method is declared `abstract`.
    ///
    /// @return `true` if this method is abstract, `false` otherwise
    boolean isAbstract();

    /// Returns whether this method is declared `static`.
    ///
    /// @return `true` if this method is static, `false` otherwise
    boolean isStatic();

    /// Returns whether this method is declared `final`.
    ///
    /// @return `true` if this method is final, `false` otherwise
    boolean isFinal();

    /// Returns whether this method is declared `synchronized`.
    ///
    /// @return `true` if this method is synchronized, `false` otherwise
    boolean isSynchronized();

    /// Returns whether this method is declared `native`.
    ///
    /// @return `true` if this method is native, `false` otherwise
    boolean isNative();

    /// Returns whether this method is a compiler-generated bridge method.
    ///
    /// Bridge methods are created by the compiler to preserve polymorphism in
    /// the presence of generics.
    ///
    /// @return `true` if this method is a bridge method, `false` otherwise
    boolean isBridge();

    /// Returns whether this method is synthetic.
    ///
    /// Synthetic methods are compiler-generated methods not present in source code.
    ///
    /// @return `true` if this method is synthetic, `false` otherwise
    boolean isSynthetic();

    /// Returns whether this method is declared `public`.
    ///
    /// @return `true` if this method is public, `false` otherwise
    boolean isPublic();

    /// Returns whether this method is declared `protected`.
    ///
    /// @return `true` if this method is protected, `false` otherwise
    boolean isProtected();

    /// Returns whether this method is declared `private`.
    ///
    /// @return `true` if this method is private, `false` otherwise
    boolean isPrivate();

    /// Returns whether this method has package-private (default) access.
    ///
    /// A method is package-private if it has no explicit access modifier.
    ///
    /// @return `true` if this method is package-private, `false` otherwise
    boolean isPackagePrivate();

    /// Invokes this method on the specified target object with the given arguments.
    ///
    /// The operation returns a [MethodInvocationResult] that encapsulates
    /// both the result of the invocation and any exception thrown during execution.
    ///
    /// @param <R>    the expected return type
    /// @param target the target object on which to invoke the method; `null` if static
    /// @param args   the arguments to pass to the method; must not be `null`
    ///
    /// @return a [MethodInvocationResult] representing the outcome; never `null`
    /// @throws NullPointerException if args is `null`
    <R> MethodInvocationResult<R> invoke(Object target, Object... args);

    /// Returns an assertion view for this method descriptor.
    ///
    /// The returned [MethodAssertion] extends the base [io.github.reflect4j.api.assertion.Assertion]
    /// contract with method-specific checks such as return type, parameters, and modifiers.
    ///
    /// @return the method assertion; never `null`
    @Override
    MethodAssertion toAssertion();
}
