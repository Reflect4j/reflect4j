package io.github.reflect4j.commons;

import java.util.Arrays;
import java.util.Objects;

/// # Params
///
/// Represents a type-safe abstraction for method or constructor parameter types
/// used in reflection operations. This class simplifies handling parameter
/// type arrays and provides fluent factory methods.
///
/// The `Params` class encapsulates an array of `Class<?>` objects representing
/// the types of parameters for methods or constructors. It is immutable and
/// provides convenient factory methods for common use cases.
///
/// This class is typically used in conjunction with reflection utility methods
/// to perform dynamic method or constructor lookups.
///
/// @author Aliabbos Ashurov
/// @since 1.0.0
public final class Params {

    private static final Class<?>[] EMPTY_TYPES = new Class<?>[0];
    private static final Params EMPTY = new Params(EMPTY_TYPES);

    private final Class<?>[] types;

    /// Private constructor to enforce factory method usage
    private Params(Class<?>... types) {
        this.types = (types == null || types.length == 0)
                ? EMPTY_TYPES
                : types.clone();
    }

    /// Returns a [Params] instance with one or more types
    ///
    /// @param types the parameter types
    /// @return a [Params] instance encapsulating the given types
    public static Params of(Class<?>... types) {
        return new Params(types);
    }

    /// Returns an empty parameter list (no arguments)
    ///
    /// @return a [Params] instance representing zero parameters
    public static Params empty() {
        return EMPTY;
    }

    /// Checks whether the given parameter type exists in this list.
    ///
    /// @param type the parameter type to check for, must not be `null`
    /// @return `true` if this parameter list contains the given type, otherwise `false`
    /// @throws NullPointerException if `type` is `null`
    public boolean contains(Class<?> type) {
        Objects.requireNonNull(type, "type must not be null");
        for (Class<?> t : types) {
            if (t.equals(type)) {
                return true;
            }
        }
        return false;
    }

    /// Returns the array of parameter types for reflection usage
    ///
    /// @return an array of [Class] objects representing the parameter types
    public Class<?>[] getTypes() {
        return types.length == 0 ? EMPTY_TYPES : types.clone();
    }

    /// Returns the number of parameter types.
    ///
    /// @return the size of this parameter list
    public int size() {
        return types.length;
    }

    /// Returns whether this parameter list contains no types.
    ///
    /// @return `true` if there are no parameter types, otherwise `false`
    public boolean isEmpty() {
        return types.length == 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Params other)) return false;
        return Arrays.equals(types, other.types);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(types);
    }

    @Override
    public String toString() {
        return "Params=[" + Arrays.toString(types) + "]";
    }
}