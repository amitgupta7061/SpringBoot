/**
 * 05_Conditionals.java
 * All Conditional Statements in Java
 */

class Conditionals {

    public static void main(String[] args) {

        // ============ 1. IF STATEMENT ============
        System.out.println("=== If Statement ===");

        int age = 20;

        if (age >= 18) {
            System.out.println("You are an adult");
        }

        // Single line if (no braces needed for single statement)
        if (age >= 18)
            System.out.println("You can vote");

        // ============ 2. IF-ELSE STATEMENT ============
        System.out.println("\n=== If-Else Statement ===");

        int number = 15;

        if (number % 2 == 0) {
            System.out.println(number + " is even");
        } else {
            System.out.println(number + " is odd");
        }

        // ============ 3. IF-ELSE-IF LADDER ============
        System.out.println("\n=== If-Else-If Ladder ===");

        int score = 75;

        if (score >= 90) {
            System.out.println("Grade: A");
        } else if (score >= 80) {
            System.out.println("Grade: B");
        } else if (score >= 70) {
            System.out.println("Grade: C");
        } else if (score >= 60) {
            System.out.println("Grade: D");
        } else {
            System.out.println("Grade: F");
        }

        // ============ 4. NESTED IF ============
        System.out.println("\n=== Nested If ===");

        int x = 10, y = 20;

        if (x > 5) {
            if (y > 15) {
                System.out.println("x > 5 AND y > 15");
            } else {
                System.out.println("x > 5 AND y <= 15");
            }
        } else {
            System.out.println("x <= 5");
        }

        // ============ 5. SWITCH STATEMENT (Classic) ============
        System.out.println("\n=== Switch Statement (Classic) ===");

        int day = 3;

        switch (day) {
            case 1:
                System.out.println("Monday");
                break;
            case 2:
                System.out.println("Tuesday");
                break;
            case 3:
                System.out.println("Wednesday");
                break;
            case 4:
                System.out.println("Thursday");
                break;
            case 5:
                System.out.println("Friday");
                break;
            case 6:
            case 7:
                System.out.println("Weekend"); // Fall-through for multiple cases
                break;
            default:
                System.out.println("Invalid day");
        }

        // Switch with String
        String fruit = "apple";

        switch (fruit) {
            case "apple":
                System.out.println("Red fruit");
                break;
            case "banana":
                System.out.println("Yellow fruit");
                break;
            case "orange":
                System.out.println("Orange fruit");
                break;
            default:
                System.out.println("Unknown fruit");
        }

        // ============ 6. ENHANCED SWITCH (Java 14+) ============
        System.out.println("\n=== Enhanced Switch (Java 14+) ===");

        int dayNum = 3;

        // Arrow syntax - no break needed
        String dayName = switch (dayNum) {
            case 1 -> "Monday";
            case 2 -> "Tuesday";
            case 3 -> "Wednesday";
            case 4 -> "Thursday";
            case 5 -> "Friday";
            case 6, 7 -> "Weekend";
            default -> "Invalid";
        };
        System.out.println("Day: " + dayName);

        // Switch with yield (for complex expressions)
        String description = switch (dayNum) {
            case 1, 2, 3, 4, 5 -> {
                System.out.println("It's a weekday");
                yield "Weekday";
            }
            case 6, 7 -> {
                System.out.println("It's weekend");
                yield "Weekend";
            }
            default -> {
                yield "Unknown";
            }
        };
        System.out.println("Type: " + description);

        // ============ 7. TERNARY OPERATOR (Conditional Expression) ============
        System.out.println("\n=== Ternary Operator ===");

        int a = 10, b = 20;

        int max = (a > b) ? a : b;
        System.out.println("Maximum: " + max);

        String result = (a % 2 == 0) ? "Even" : "Odd";
        System.out.println("a is: " + result);

        // Nested ternary (use sparingly)
        int num = 0;
        String sign = (num > 0) ? "Positive" : (num < 0) ? "Negative" : "Zero";
        System.out.println("Number is: " + sign);

        // ============ 8. LOGICAL OPERATORS IN CONDITIONS ============
        System.out.println("\n=== Logical Operators ===");

        int marks = 75;
        int attendance = 80;

        // AND (&&) - both conditions must be true
        if (marks >= 70 && attendance >= 75) {
            System.out.println("Eligible for certificate");
        }

        // OR (||) - at least one condition must be true
        if (marks >= 90 || attendance >= 95) {
            System.out.println("Eligible for distinction");
        } else {
            System.out.println("Not eligible for distinction");
        }

        // NOT (!) - reverses the condition
        boolean isHoliday = false;
        if (!isHoliday) {
            System.out.println("Go to work");
        }

        // ============ 9. COMPARING OBJECTS ============
        System.out.println("\n=== Comparing Objects ===");

        String s1 = "Hello";
        String s2 = "Hello";
        String s3 = new String("Hello");

        // == compares references
        System.out.println("s1 == s2: " + (s1 == s2)); // true (same string pool)
        System.out.println("s1 == s3: " + (s1 == s3)); // false (different objects)

        // .equals() compares content
        System.out.println("s1.equals(s3): " + s1.equals(s3)); // true

        // Null check
        String nullStr = null;
        if (nullStr != null && nullStr.length() > 0) {
            System.out.println("String is not empty");
        } else {
            System.out.println("String is null or empty");
        }
    }
}
