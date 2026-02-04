
/**
 * 27_Annotations.java - Built-in and Custom Annotations
 */

import java.lang.annotation.*;
import java.lang.reflect.*;

class Annotations {
    public static void main(String[] args) throws Exception {
        // === Using Annotations ===
        MyClass obj = new MyClass();
        obj.newMethod();

        // === Reading Custom Annotations via Reflection ===
        Class<?> clazz = AnnotatedClass.class;

        // Class-level annotation
        if (clazz.isAnnotationPresent(Info.class)) {
            Info info = clazz.getAnnotation(Info.class);
            System.out.println("Author: " + info.author());
            System.out.println("Version: " + info.version());
        }

        // Method-level annotation
        for (Method method : clazz.getDeclaredMethods()) {
            if (method.isAnnotationPresent(Todo.class)) {
                Todo todo = method.getAnnotation(Todo.class);
                System.out.println("TODO on " + method.getName() +
                        ": " + todo.description() + " (Priority: " + todo.priority() + ")");
            }
        }
    }
}

// === Built-in Annotations Demo ===
class Parent {
    void oldMethod() {
    }

    @Deprecated(since = "1.5", forRemoval = true)
    void deprecatedMethod() {
    }
}

class MyClass extends Parent {
    @Override // Compile-time check for method overriding
    void oldMethod() {
        System.out.println("Overridden method");
    }

    @SuppressWarnings("deprecation") // Suppress deprecation warnings
    void newMethod() {
        deprecatedMethod(); // No warning
    }
}

// === Custom Annotations ===

// Retention: SOURCE, CLASS, or RUNTIME
// Target: TYPE, METHOD, FIELD, PARAMETER, etc.
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface Info {
    String author();

    String version() default "1.0";

    String[] tags() default {};
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Todo {
    String description();

    int priority() default 1;
}

// Using custom annotations
@Info(author = "John", version = "2.0", tags = { "util", "core" })
class AnnotatedClass {

    @Todo(description = "Implement this", priority = 2)
    void pendingMethod() {
        // TODO
    }

    @Todo(description = "Add logging")
    void anotherMethod() {
        // TODO
    }
}

/*
 * Common Built-in Annotations:
 * 
 * @Override - Check method overriding
 * 
 * @Deprecated - Mark as deprecated
 * 
 * @SuppressWarnings - Suppress compiler warnings
 * 
 * @FunctionalInterface - Mark as functional interface
 * 
 * @SafeVarargs - Suppress varargs warnings
 * 
 * Meta-Annotations:
 * 
 * @Retention - When annotation is available
 * 
 * @Target - Where annotation can be used
 * 
 * @Documented - Include in Javadoc
 * 
 * @Inherited - Subclasses inherit annotation
 * 
 * @Repeatable - Can be used multiple times
 */
