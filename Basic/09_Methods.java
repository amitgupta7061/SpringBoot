/**
 * 09_Methods.java - Functions/Methods in Java
 */

class Methods {
    public static void main(String[] args) {
        // === Calling Methods ===
        greet(); // No parameter, no return
        greetPerson("Alice"); // With parameter
        int sum = add(5, 3); // With return value
        System.out.println("Sum: " + sum);

        // Overloaded methods
        System.out.println(add(1, 2));
        System.out.println(add(1.5, 2.5));
        System.out.println(add(1, 2, 3));

        // Variable arguments
        System.out.println("Varargs sum: " + sumAll(1, 2, 3, 4, 5));

        // Recursion
        System.out.println("Factorial: " + factorial(5));

        // Pass by value demo
        int x = 10;
        modifyValue(x);
        System.out.println("After modify: " + x); // Still 10
    }

    // No parameter, no return
    static void greet() {
        System.out.println("Hello!");
    }

    // With parameter
    static void greetPerson(String name) {
        System.out.println("Hello, " + name);
    }

    // With return value
    static int add(int a, int b) {
        return a + b;
    }

    // Method overloading (same name, different parameters)
    static double add(double a, double b) {
        return a + b;
    }

    static int add(int a, int b, int c) {
        return a + b + c;
    }

    // Variable arguments (varargs)
    static int sumAll(int... numbers) {
        int total = 0;
        for (int n : numbers)
            total += n;
        return total;
    }

    // Recursion
    static int factorial(int n) {
        if (n <= 1)
            return 1;
        return n * factorial(n - 1);
    }

    // Java is pass-by-value
    static void modifyValue(int num) {
        num = 100; // Only modifies local copy
    }
}
