/**
 * 06_Loops.java
 * All Types of Loops in Java
 */

class Loops {

    public static void main(String[] args) {

        // ============ 1. FOR LOOP ============
        System.out.println("=== For Loop ===");

        // Basic for loop
        for (int i = 1; i <= 5; i++) {
            System.out.println("Iteration: " + i);
        }

        // Counting backwards
        System.out.println("\nCounting backwards:");
        for (int i = 5; i >= 1; i--) {
            System.out.print(i + " ");
        }
        System.out.println();

        // Step by 2
        System.out.println("\nStep by 2:");
        for (int i = 0; i <= 10; i += 2) {
            System.out.print(i + " ");
        }
        System.out.println();

        // Multiple variables
        System.out.println("\nMultiple variables:");
        for (int i = 0, j = 10; i <= 5; i++, j--) {
            System.out.println("i=" + i + ", j=" + j);
        }

        // ============ 2. WHILE LOOP ============
        System.out.println("\n=== While Loop ===");

        int count = 1;
        while (count <= 5) {
            System.out.println("Count: " + count);
            count++;
        }

        // Sum of numbers
        System.out.println("\nSum calculation:");
        int sum = 0;
        int n = 1;
        while (n <= 10) {
            sum += n;
            n++;
        }
        System.out.println("Sum (1 to 10): " + sum);

        // ============ 3. DO-WHILE LOOP ============
        System.out.println("\n=== Do-While Loop ===");

        // Executes at least once
        int num = 1;
        do {
            System.out.println("Number: " + num);
            num++;
        } while (num <= 5);

        // Even when condition is false initially
        int x = 10;
        do {
            System.out.println("This prints once even though x > 5");
        } while (x < 5);

        // ============ 4. FOR-EACH LOOP (Enhanced For) ============
        System.out.println("\n=== For-Each Loop ===");

        // With array
        int[] numbers = { 10, 20, 30, 40, 50 };
        for (int number : numbers) {
            System.out.println("Number: " + number);
        }

        // With String array
        String[] fruits = { "Apple", "Banana", "Orange" };
        for (String fruit : fruits) {
            System.out.println("Fruit: " + fruit);
        }

        // ============ 5. NESTED LOOPS ============
        System.out.println("\n=== Nested Loops ===");

        // Multiplication table
        System.out.println("Multiplication Table (1-3):");
        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 3; j++) {
                System.out.print(i * j + "\t");
            }
            System.out.println();
        }

        // Pattern: Right triangle
        System.out.println("\nRight Triangle Pattern:");
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }

        // ============ 6. BREAK STATEMENT ============
        System.out.println("\n=== Break Statement ===");

        // Exit loop when condition met
        for (int i = 1; i <= 10; i++) {
            if (i == 5) {
                System.out.println("Breaking at " + i);
                break;
            }
            System.out.println("i = " + i);
        }

        // ============ 7. CONTINUE STATEMENT ============
        System.out.println("\n=== Continue Statement ===");

        // Skip current iteration
        for (int i = 1; i <= 5; i++) {
            if (i == 3) {
                System.out.println("Skipping " + i);
                continue;
            }
            System.out.println("i = " + i);
        }

        // ============ 8. LABELED BREAK & CONTINUE ============
        System.out.println("\n=== Labeled Break ===");

        // Break from outer loop
        outer: for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 3; j++) {
                if (i == 2 && j == 2) {
                    System.out.println("Breaking outer at i=" + i + ", j=" + j);
                    break outer;
                }
                System.out.println("i=" + i + ", j=" + j);
            }
        }

        System.out.println("\n=== Labeled Continue ===");

        // Continue outer loop
        outerLoop: for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 3; j++) {
                if (j == 2) {
                    continue outerLoop;
                }
                System.out.println("i=" + i + ", j=" + j);
            }
        }

        // ============ 9. INFINITE LOOPS ============
        System.out.println("\n=== Infinite Loop Examples (commented) ===");

        // Infinite for loop
        // for (;;) { }

        // Infinite while loop
        // while (true) { }

        // Infinite do-while loop
        // do { } while (true);

        // Controlled infinite loop
        int counter = 0;
        while (true) {
            System.out.println("Counter: " + counter);
            counter++;
            if (counter >= 3) {
                break;
            }
        }

        // ============ 10. PRACTICAL EXAMPLES ============
        System.out.println("\n=== Practical Examples ===");

        // Find factorial
        int factorial = 1;
        int number = 5;
        for (int i = 1; i <= number; i++) {
            factorial *= i;
        }
        System.out.println("Factorial of " + number + " = " + factorial);

        // Fibonacci series
        System.out.print("Fibonacci: ");
        int a = 0, b = 1;
        for (int i = 0; i < 10; i++) {
            System.out.print(a + " ");
            int temp = a + b;
            a = b;
            b = temp;
        }
        System.out.println();

        // Prime number check
        int checkNum = 17;
        boolean isPrime = true;
        for (int i = 2; i <= Math.sqrt(checkNum); i++) {
            if (checkNum % i == 0) {
                isPrime = false;
                break;
            }
        }
        System.out.println(checkNum + " is prime: " + isPrime);
    }
}
