package io.github.reflect4j.annotations;

import java.lang.annotation.*;

/// # R4jIgnore
///
/// Explicitly excludes a type or member from Reflect4j processing.
/// Use for sensitive fields, internal APIs, or when a member should not be discovered or invoked reflectively.
///
///     - Applies to classes, methods, fields, and constructors.
///     - Always takes precedence over any inclusion logic in the library.
///     - `reason()` is optional but recommended for clarity.
///
/// **Example:**
/// ```java
/// public class User {
///
///       @R4jIgnore(reason = "Sensitive data")
///       private String password;
///}
///```
///
/// @author Aliabbos Ashurov
/// @since 1.0.0
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.CONSTRUCTOR, ElementType.METHOD, ElementType.FIELD, ElementType.TYPE })
public @interface R4jIgnore {

    /// Reason why this element is excluded (empty = unspecified).
    String reason() default "";
}
