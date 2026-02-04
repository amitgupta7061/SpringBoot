
/**
 * 16_Generics.java - Generic Classes, Methods, and Bounded Types
 */

import java.util.*;

class Generics {
    public static void main(String[] args) {
        // === Generic Class ===
        Box<String> stringBox = new Box<>("Hello");
        Box<Integer> intBox = new Box<>(42);

        System.out.println(stringBox.getValue());
        System.out.println(intBox.getValue());

        // === Generic Method ===
        printArray(new Integer[] { 1, 2, 3 });
        printArray(new String[] { "A", "B", "C" });

        // === Multiple Type Parameters ===
        Pair<String, Integer> pair = new Pair<>("Age", 25);
        System.out.println(pair.getKey() + ": " + pair.getValue());

        // === Bounded Type ===
        NumberBox<Integer> numBox = new NumberBox<>(10);
        System.out.println("Double value: " + numBox.getDoubleValue());

        // === Wildcards ===
        List<Integer> intList = Arrays.asList(1, 2, 3);
        List<Double> doubleList = Arrays.asList(1.1, 2.2, 3.3);

        printList(intList);
        printList(doubleList);
        sumOfList(intList);
    }

    // Generic method
    static <T> void printArray(T[] array) {
        for (T element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    // Unbounded wildcard (?)
    static void printList(List<?> list) {
        for (Object item : list) {
            System.out.print(item + " ");
        }
        System.out.println();
    }

    // Upper bounded wildcard (extends)
    static void sumOfList(List<? extends Number> list) {
        double sum = 0;
        for (Number n : list) {
            sum += n.doubleValue();
        }
        System.out.println("Sum: " + sum);
    }
}

// Generic class
class Box<T> {
    private T value;

    Box(T value) {
        this.value = value;
    }

    T getValue() {
        return value;
    }

    void setValue(T value) {
        this.value = value;
    }
}

// Multiple type parameters
class Pair<K, V> {
    private K key;
    private V value;

    Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    K getKey() {
        return key;
    }

    V getValue() {
        return value;
    }
}

// Bounded type parameter
class NumberBox<T extends Number> {
    private T value;

    NumberBox(T value) {
        this.value = value;
    }

    double getDoubleValue() {
        return value.doubleValue();
    }
}
