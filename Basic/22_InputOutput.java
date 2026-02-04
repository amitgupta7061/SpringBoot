
/**
 * 22_InputOutput.java - User Input (Scanner, BufferedReader)
 */

import java.util.Scanner;
import java.io.*;

class InputOutput {
    public static void main(String[] args) throws IOException {
        // === Scanner (Most Common) ===
        Scanner scanner = new Scanner(System.in);

        // Reading String
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        // Reading Integer
        System.out.print("Enter your age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        // Reading Double
        System.out.print("Enter price: ");
        double price = scanner.nextDouble();
        scanner.nextLine();

        // Reading Boolean
        System.out.print("Are you student (true/false)? ");
        boolean isStudent = scanner.nextBoolean();

        System.out.println("\n=== You entered ===");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Price: " + price);
        System.out.println("Student: " + isStudent);

        // === Scanner with hasNext ===
        System.out.print("\nEnter numbers (type 'exit' to stop): ");
        Scanner numScanner = new Scanner(System.in);
        int sum = 0;
        while (numScanner.hasNextInt()) {
            sum += numScanner.nextInt();
        }
        System.out.println("Sum: " + sum);

        // === BufferedReader (Faster for large input) ===
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("\nEnter a line: ");
        String line = reader.readLine();
        System.out.println("You entered: " + line);

        // Parse numbers from BufferedReader
        System.out.print("Enter a number: ");
        int num = Integer.parseInt(reader.readLine().trim());
        System.out.println("Number: " + num);

        // === Console (for password, may be null in IDEs) ===
        Console console = System.console();
        if (console != null) {
            String username = console.readLine("Username: ");
            char[] password = console.readPassword("Password: ");
            System.out.println("Logged in as: " + username);
        }

        // === Output formatting ===
        System.out.println("\n=== Output Formatting ===");

        // Printf
        System.out.printf("Name: %s, Age: %d%n", "John", 25);
        System.out.printf("Pi: %.2f%n", 3.14159);
        System.out.printf("Padded: %10d%n", 42);
        System.out.printf("Left aligned: %-10s|%n", "Hi");

        // String.format
        String formatted = String.format("Value: %05d", 7); // 00007
        System.out.println(formatted);

        scanner.close();
    }
}
