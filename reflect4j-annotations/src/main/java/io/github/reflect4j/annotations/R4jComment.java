package io.github.reflect4j.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/// # R4jComment
///
/// Attach a human- and machine-readable comment to classes, members or annotations. Useful for generated docs,
/// annotation processors, and runtime metadata for tooling.
///
/// - Kept RUNTIME retention so Reflect4j and tools can access it at runtime.
/// - category() groups comments (e.g., "entity", "dto", "internal").
///
/// Example:
/// ```java
/// @R4jComment(value = "Entity class", category = "class")
/// public class MyClass {
///
///    @R4jComment("field used for X")
///    private String value;
///}
///```
///
/// @author Aliabbos Ashurov
/// @apiNote The annotation itself does not change program behavior. It is metadata for tools and reflect utilities.
/// @since 1.0.0
@Target({ ElementType.TYPE, ElementType.METHOD, ElementType.FIELD, ElementType.CONSTRUCTOR, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.SOURCE)
public @interface R4jComment {

    /// The comment text.
    String value();

    /// Category tag for comment filtering (empty = uncategorized).
    String category() default "";
}
