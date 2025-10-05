package io.github.reflect4j.api.descriptor;

import io.github.reflect4j.api.assertion.ConstructorAssertion;
import io.github.reflect4j.api.invoke.ConstructorInvocationResult;

import java.lang.reflect.Constructor;
import java.util.List;

/// # ConstructorDescriptor
///
/// Represents a descriptor for a [Constructor].
///
/// Provides metadata and reflective access for constructors, including parameter
/// types, declared exceptions, and runtime invocation. Constructors are never
/// `static`, `final`, or `abstract`, so this interface omits such checks.
///
/// Implementations are intended to wrap a [Constructor] instance and expose
/// a fluent, type-safe API for inspection and invocation. Invocation returns
/// a [ConstructorInvocationResult], which encapsulates both the constructed
/// instance and any exception raised during the call.
///
/// @param <T> the type of the class declaring this constructor
///
/// @author Aliabbos Ashurov
/// @since 1.0.0
public interface ConstructorDescriptor<T> extends MemberDescriptor<Constructor<T>> {

    /// Returns the parameter types of this constructor in declaration order.
    ///
    /// @return an immutable list of parameter types; never `null`
    List<Class<?>> getParameterTypes();

    /// Returns the number of parameters accepted by this constructor.
    ///
    /// Includes varargs as a single parameter (e.g., `new Foo(String...)` has count 1).
    ///
    /// @return the parameter count; always non-negative
    int getParameterCount();

    /// Returns whether this constructor accepts a variable number of arguments.
    ///
    /// @return `true` if the constructor is varargs, `false` otherwise
    boolean isVarArgs();

    /// Returns whether this constructor is synthetic.
    ///
    /// A synthetic constructor is one introduced by the compiler and not
    /// explicitly declared in source code.
    ///
    /// @return `true` if synthetic, `false` otherwise
    boolean isSynthetic();

    /// Returns whether this constructor is declared `public`.
    ///
    /// @return `true` if public, `false` otherwise
    boolean isPublic();

    /// Returns whether this constructor is declared `protected`.
    ///
    /// @return `true` if protected, `false` otherwise
    boolean isProtected();

    /// Returns whether this constructor is declared `private`.
    ///
    /// @return `true` if private, `false` otherwise
    boolean isPrivate();

    /// Returns whether this constructor has package-private (default) access.
    ///
    /// A constructor is package-private if it has no explicit access modifier.
    ///
    /// @return `true` if package-private, `false` otherwise
    boolean isPackagePrivate();

    /// Invokes this constructor reflectively with the given arguments.
    ///
    /// The operation creates a new instance of the declaring class.
    /// The returned [ConstructorInvocationResult] encapsulates both the
    /// created object (if successful) and any exception thrown during
    /// instantiation.
    ///
    /// @param args the arguments to pass to the constructor; must not be `null`
    /// @param <R>  the type of the created instance
    ///
    /// @return a [ConstructorInvocationResult] representing the outcome; never `null`
    /// @throws NullPointerException if args is `null`
    <R> ConstructorInvocationResult<R> invoke(Object... args);

    /// Returns an assertion view for this constructor descriptor.
    ///
    /// The returned [ConstructorAssertion] extends the base
    /// [io.github.reflect4j.api.assertion.Assertion] contract with
    /// constructor-specific checks such as parameter count, modifiers,
    /// and exception declarations.
    ///
    /// @return the constructor assertion; never `null`
    @Override
    ConstructorAssertion<T> toAssertion();
}
