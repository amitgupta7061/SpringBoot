/**
 * 14_ExceptionHandling.java - Try-Catch, Throw, Throws, Finally
 */

class ExceptionHandling {
    public static void main(String[] args) {
        // === Basic Try-Catch ===
        try {
            int result = 10 / 0;
        } catch (ArithmeticException e) {
            System.out.println("Cannot divide by zero!");
        }

        // === Multiple Catch Blocks ===
        try {
            int[] arr = { 1, 2, 3 };
            System.out.println(arr[5]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Index out of bounds!");
        } catch (Exception e) {
            System.out.println("Some error: " + e.getMessage());
        }

        // === Multi-catch (Java 7+) ===
        try {
            String s = null;
            s.length();
        } catch (NullPointerException | ArithmeticException e) {
            System.out.println("Caught: " + e.getClass().getSimpleName());
        }

        // === Finally Block ===
        try {
            System.out.println("Try block");
        } catch (Exception e) {
            System.out.println("Catch block");
        } finally {
            System.out.println("Finally always executes");
        }

        // === Throw Keyword ===
        try {
            validateAge(15);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // === Custom Exception ===
        try {
            checkBalance(100, 500);
        } catch (InsufficientFundsException e) {
            System.out.println(e.getMessage());
        }

        // === Throws declaration ===
        try {
            riskyMethod();
        } catch (Exception e) {
            System.out.println("Handled risky method");
        }
    }

    // Throwing an exception
    static void validateAge(int age) {
        if (age < 18) {
            throw new IllegalArgumentException("Must be 18+");
        }
    }

    // Throws declaration
    static void riskyMethod() throws Exception {
        throw new Exception("Something went wrong");
    }

    // Using custom exception
    static void checkBalance(double balance, double amount)
            throws InsufficientFundsException {
        if (amount > balance) {
            throw new InsufficientFundsException("Insufficient funds!");
        }
    }
}

// Custom Exception
class InsufficientFundsException extends Exception {
    InsufficientFundsException(String message) {
        super(message);
    }
}
