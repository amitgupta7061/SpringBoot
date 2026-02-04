package oops;

/**
 * 13_OOP_Abstraction.java - Abstract Classes and Interfaces
 */

class OOP_Abstraction {
    public static void main(String[] args) {
        // Cannot instantiate abstract class
        // Shape s = new Shape(); // Error!

        // Use concrete implementations
        Shape circle = new Circle(5);
        Shape rectangle = new Rectangle(4, 6);

        circle.draw();
        System.out.println("Circle area: " + circle.area());

        rectangle.draw();
        System.out.println("Rectangle area: " + rectangle.area());

        // Interface usage
        Flyable bird = new Bird();
        Flyable plane = new Airplane();

        bird.fly();
        plane.fly();

        // Multiple interface implementation
        Duck duck = new Duck();
        duck.fly();
        duck.swim();
    }
}

// === ABSTRACT CLASS ===
abstract class Shape {
    String color = "Red";

    // Abstract method (no body) - must be implemented by subclass
    abstract double area();

    // Concrete method - can be used as-is or overridden
    void draw() {
        System.out.println("Drawing " + color + " shape");
    }
}

class Circle extends Shape {
    double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    @Override
    double area() {
        return Math.PI * radius * radius;
    }
}

class Rectangle extends Shape {
    double width, height;

    Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    double area() {
        return width * height;
    }
}

// === INTERFACE ===
interface Flyable {
    // Constants (public static final by default)
    int MAX_HEIGHT = 10000;

    // Abstract method (public abstract by default)
    void fly();

    // Default method (Java 8+)
    default void land() {
        System.out.println("Landing...");
    }

    // Static method (Java 8+)
    static void info() {
        System.out.println("Flyable interface");
    }
}

interface Swimmable {
    void swim();
}

class Bird implements Flyable {
    @Override
    public void fly() {
        System.out.println("Bird flying with wings");
    }
}

class Airplane implements Flyable {
    @Override
    public void fly() {
        System.out.println("Airplane flying with engines");
    }
}

// Multiple interface implementation
class Duck implements Flyable, Swimmable {
    @Override
    public void fly() {
        System.out.println("Duck flying");
    }

    @Override
    public void swim() {
        System.out.println("Duck swimming");
    }
}
