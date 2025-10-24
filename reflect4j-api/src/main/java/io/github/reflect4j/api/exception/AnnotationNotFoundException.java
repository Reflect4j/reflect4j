package io.github.reflect4j.api.exception;

import java.lang.reflect.AnnotatedElement;

/// # AnnotationNotFoundException
///
/// Exception thrown when a requested annotation is not found on a specific element.
/// Extends ElementNotFoundException for consistent runtime exception handling.
///
/// @author Aliabbos Ashurov
/// @since 2025-09-19
public class AnnotationNotFoundException extends ElementNotFoundException {

    /// Creates an exception with a detailed message including annotation and element.
    public AnnotationNotFoundException(Class<?> annotationClass, AnnotatedElement element) {
        super("Annotation @" + annotationClass.getName() + " not found on element: " + element);
    }
    
    public AnnotationNotFoundException(String message) {
        super(message);
    }
    
    public AnnotationNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
    
    public AnnotationNotFoundException(Throwable cause) {
        super(cause);
    }
}
