package oops;

/**
 * 10_OOP_Classes.java - Classes, Objects, Constructors
 */

class OOP_Classes {
    public static void main(String[] args) {
        // === Creating Objects ===
        Person p1 = new Person(); // Default constructor
        Person p2 = new Person("Alice", 25); // Parameterized

        p1.name = "Bob";
        p1.age = 30;
        p1.introduce();
        p2.introduce();

        // === Static vs Instance ===
        System.out.println("Person count: " + Person.count);

        // === Inner class demo ===
        Car car = new Car("Toyota");
        Car.Engine engine = car.new Engine();
        engine.start();
    }
}

// === Basic Class ===
class Person {
    // Instance variables
    String name;
    int age;

    // Static variable (shared by all objects)
    static int count = 0;

    // Default constructor
    Person() {
        count++;
    }

    // Parameterized constructor
    Person(String name, int age) {
        this.name = name; // 'this' refers to current object
        this.age = age;
        count++;
    }

    // Copy constructor
    Person(Person other) {
        this.name = other.name;
        this.age = other.age;
        count++;
    }

    // Instance method
    void introduce() {
        System.out.println("I'm " + name + ", " + age + " years old");
    }

    // Static method
    static void showCount() {
        System.out.println("Total persons: " + count);
    }
}

// === Class with Inner Class ===
class Car {
    String brand;

    Car(String brand) {
        this.brand = brand;
    }

    // Inner class
    class Engine {
        void start() {
            System.out.println(brand + " engine started");
        }
    }

    // Static nested class
    static class Wheel {
        void rotate() {
            System.out.println("Wheel rotating");
        }
    }
}
