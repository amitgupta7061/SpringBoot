/**
 * 26_RecordsAndSealed.java - Records (Java 14+) and Sealed Classes (Java 17+)
 */

class RecordsAndSealed {
    public static void main(String[] args) {
        // === RECORDS (Immutable data classes) ===
        System.out.println("=== Records ===");

        // Create record instance
        PersonRecord person = new PersonRecord("Alice", 25);

        // Auto-generated accessor methods (no "get" prefix)
        System.out.println("Name: " + person.name());
        System.out.println("Age: " + person.age());

        // Auto-generated toString()
        System.out.println("ToString: " + person);

        // Auto-generated equals() and hashCode()
        PersonRecord person2 = new PersonRecord("Alice", 25);
        System.out.println("Equals: " + person.equals(person2));

        // Record with validation
        Point point = new Point(10, 20);
        System.out.println("Point: " + point);

        // Record with additional methods
        Rectangle rect = new Rectangle(5, 10);
        System.out.println("Area: " + rect.area());

        // === SEALED CLASSES ===
        System.out.println("\n=== Sealed Classes ===");

        Shape shape = new ShapeCircle(5);
        printArea(shape);

        Shape square = new ShapeSquare(4);
        printArea(square);
    }

    // Pattern matching with sealed classes
    static void printArea(Shape shape) {
        double area = switch (shape) {
            case ShapeCircle c -> Math.PI * c.radius() * c.radius();
            case ShapeSquare s -> s.side() * s.side();
            case ShapeRectangle r -> r.width() * r.height();
        };
        System.out.println("Area: " + area);
    }
}

// === RECORD definitions ===

// Basic record - generates constructor, accessors, equals, hashCode, toString
record PersonRecord(String name, int age) {
}

// Record with validation (compact constructor)
record Point(int x, int y) {
    // Compact constructor for validation
    public Point {
        if (x < 0 || y < 0) {
            throw new IllegalArgumentException("Coordinates must be positive");
        }
    }
}

// Record with additional methods
record Rectangle(double width, double height) {
    // Additional method
    public double area() {
        return width * height;
    }

    // Static factory method
    public static Rectangle square(double side) {
        return new Rectangle(side, side);
    }
}

// === SEALED CLASSES ===

// Sealed class - restricts which classes can extend it
sealed interface Shape permits ShapeCircle, ShapeSquare, ShapeRectangle {
}

// Permitted subclasses
record ShapeCircle(double radius) implements Shape {
}

record ShapeSquare(double side) implements Shape {
}

record ShapeRectangle(double width, double height) implements Shape {
}
