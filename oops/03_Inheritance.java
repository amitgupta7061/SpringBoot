package oops;

/**
 * 11_OOP_Inheritance.java - Inheritance and Method Overriding
 */

class Inheritance {
    public static void main(String[] args) {
        Dog dog = new Dog("Buddy", 3);
        dog.eat(); // Inherited from Animal
        dog.bark(); // Dog's own method
        dog.makeSound(); // Overridden method

        Cat cat = new Cat("Whiskers");
        cat.makeSound();

        // Polymorphism - Parent reference, child object
        Animal animal = new Dog("Rex", 5);
        animal.makeSound(); // Calls Dog's version
        // animal.bark(); // Error! Parent can't see child methods

        // instanceof check
        if (animal instanceof Dog) {
            Dog d = (Dog) animal; // Downcasting
            d.bark();
        }
    }
}

// Parent/Super/Base class
class Animal {
    String name;

    Animal() {
        System.out.println("Animal created");
    }

    Animal(String name) {
        this.name = name;
    }

    void eat() {
        System.out.println(name + " is eating");
    }

    void makeSound() {
        System.out.println("Animal sound");
    }
}

// Child/Sub/Derived class
class Dog extends Animal {
    int age;

    Dog(String name, int age) {
        super(name); // Call parent constructor
        this.age = age;
    }

    void bark() {
        System.out.println(name + " says Woof!");
    }

    // Method overriding
    @Override
    void makeSound() {
        super.makeSound(); // Call parent method
        System.out.println(name + " barks!");
    }
}

class Cat extends Animal {
    Cat(String name) {
        super(name);
    }

    @Override
    void makeSound() {
        System.out.println(name + " meows!");
    }
}
