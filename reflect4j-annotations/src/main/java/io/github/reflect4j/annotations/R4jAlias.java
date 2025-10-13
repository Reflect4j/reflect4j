package io.github.reflect4j.annotations;

import java.lang.annotation.*;

/// # R4jAlias
///
/// Defines alternative names (aliases) for types, fields, methods, or constructors.
/// Useful for flexible or tolerant reflection lookups when member names vary.
///
///  - `value()` provides one or more alias names (empty array allowed for marker use).
///  - `primary()` determines whether aliases are checked before or after the real member name.
///  - `caseSensitive()` controls alias name comparison sensitivity.
///
///
/// **Example:**
/// ```java
///  public class MyClass {
///
///       @R4jAlias({"instanceVar", "f"})
///       private String field;
///
///       @R4jAlias(value = {"MyClass.process"}, primary = true)
///       public void process(){}
///}
///```
///
/// @author Aliabbos Ashurov
/// @since 1.0.0
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE, ElementType.FIELD, ElementType.METHOD, ElementType.CONSTRUCTOR })
public @interface R4jAlias {

    /// Alias names for the annotated element. Zero-length array is allowed for marker usage.
    String[] value() default {};

    /// When `true`, the alias list will be treated as higher priority than the real name
    /// when resolving lookups. When `false`, the library will first try the element’s
    /// real name, then its aliases.
    boolean primary() default false;

    /// Whether alias matching is case-sensitive.
    boolean caseSensitive() default true;
}