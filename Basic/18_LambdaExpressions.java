
/**
 * 18_LambdaExpressions.java - Functional Interfaces, Lambdas, Method References
 */

import java.util.*;
import java.util.function.*;

class LambdaExpressions {
    public static void main(String[] args) {
        // === Lambda Syntax ===
        // (parameters) -> expression
        // (parameters) -> { statements; }

        // === Basic Lambda ===
        Runnable task = () -> System.out.println("Hello from lambda!");
        task.run();

        // === Lambda with Comparator ===
        List<String> names = Arrays.asList("Charlie", "Alice", "Bob");

        // Before lambda
        Collections.sort(names, new Comparator<String>() {
            public int compare(String a, String b) {
                return a.compareTo(b);
            }
        });

        // With lambda
        Collections.sort(names, (a, b) -> a.compareTo(b));
        System.out.println("Sorted: " + names);

        // === Functional Interfaces ===

        // Predicate<T> - takes T, returns boolean
        Predicate<Integer> isPositive = n -> n > 0;
        System.out.println("Is 5 positive: " + isPositive.test(5));

        // Function<T, R> - takes T, returns R
        Function<String, Integer> strLength = s -> s.length();
        System.out.println("Length: " + strLength.apply("Hello"));

        // Consumer<T> - takes T, returns void
        Consumer<String> printer = s -> System.out.println(s);
        printer.accept("Consumer example");

        // Supplier<T> - takes nothing, returns T
        Supplier<Double> random = () -> Math.random();
        System.out.println("Random: " + random.get());

        // BiFunction<T, U, R> - takes T and U, returns R
        BiFunction<Integer, Integer, Integer> add = (a, b) -> a + b;
        System.out.println("Sum: " + add.apply(3, 5));

        // === Foreach with Lambda ===
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5);
        nums.forEach(n -> System.out.print(n + " "));
        System.out.println();

        // === Method References ===
        // Class::staticMethod
        nums.forEach(System.out::println);

        // object::instanceMethod
        String prefix = "Item: ";
        Consumer<String> prefixer = prefix::concat;

        // Class::instanceMethod
        Function<String, String> upper = String::toUpperCase;
        System.out.println(upper.apply("hello"));

        // Class::new (constructor reference)
        Supplier<ArrayList<String>> listFactory = ArrayList::new;
        ArrayList<String> newList = listFactory.get();

        // === Custom Functional Interface ===
        Calculator calc = (a, b) -> a + b;
        System.out.println("Calc: " + calc.calculate(10, 20));
    }
}

// Custom functional interface
@FunctionalInterface
interface Calculator {
    int calculate(int a, int b);

    // Can have default and static methods
    default void info() {
        System.out.println("Calculator");
    }
}
