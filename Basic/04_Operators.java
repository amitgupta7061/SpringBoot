/**
 * 04_Operators.java
 * All Types of Operators in Java
 */

class Operators {

    public static void main(String[] args) {

        // ============ 1. ARITHMETIC OPERATORS ============
        System.out.println("=== Arithmetic Operators ===");

        int a = 10, b = 3;

        System.out.println("a + b = " + (a + b)); // Addition: 13
        System.out.println("a - b = " + (a - b)); // Subtraction: 7
        System.out.println("a * b = " + (a * b)); // Multiplication: 30
        System.out.println("a / b = " + (a / b)); // Division: 3 (integer)
        System.out.println("a % b = " + (a % b)); // Modulus: 1 (remainder)

        // With floating point
        double x = 10.0, y = 3.0;
        System.out.println("x / y = " + (x / y)); // 3.333...

        // ============ 2. UNARY OPERATORS ============
        System.out.println("\n=== Unary Operators ===");

        int num = 5;

        System.out.println("+num = " + (+num)); // Positive: 5
        System.out.println("-num = " + (-num)); // Negative: -5
        System.out.println("++num = " + (++num)); // Pre-increment: 6
        System.out.println("num++ = " + (num++)); // Post-increment: 6 (then becomes 7)
        System.out.println("num = " + num); // Now: 7
        System.out.println("--num = " + (--num)); // Pre-decrement: 6
        System.out.println("num-- = " + (num--)); // Post-decrement: 6 (then becomes 5)
        System.out.println("num = " + num); // Now: 5
        System.out.println("!true = " + (!true)); // Logical NOT: false

        // ============ 3. ASSIGNMENT OPERATORS ============
        System.out.println("\n=== Assignment Operators ===");

        int c = 10;
        System.out.println("c = " + c);

        c += 5; // c = c + 5
        System.out.println("c += 5: " + c); // 15

        c -= 3; // c = c - 3
        System.out.println("c -= 3: " + c); // 12

        c *= 2; // c = c * 2
        System.out.println("c *= 2: " + c); // 24

        c /= 4; // c = c / 4
        System.out.println("c /= 4: " + c); // 6

        c %= 4; // c = c % 4
        System.out.println("c %= 4: " + c); // 2

        // ============ 4. RELATIONAL/COMPARISON OPERATORS ============
        System.out.println("\n=== Relational Operators ===");

        int p = 10, q = 20;

        System.out.println("p == q: " + (p == q)); // Equal to: false
        System.out.println("p != q: " + (p != q)); // Not equal: true
        System.out.println("p > q: " + (p > q)); // Greater than: false
        System.out.println("p < q: " + (p < q)); // Less than: true
        System.out.println("p >= q: " + (p >= q)); // Greater or equal: false
        System.out.println("p <= q: " + (p <= q)); // Less or equal: true

        // ============ 5. LOGICAL OPERATORS ============
        System.out.println("\n=== Logical Operators ===");

        boolean t = true, f = false;

        System.out.println("t && f: " + (t && f)); // AND: false
        System.out.println("t || f: " + (t || f)); // OR: true
        System.out.println("!t: " + (!t)); // NOT: false

        // Short-circuit evaluation
        int val = 5;
        boolean result = (val > 10) && (++val > 5); // Second part not evaluated
        System.out.println("val after &&: " + val); // Still 5

        result = (val < 10) || (++val > 5); // Second part not evaluated
        System.out.println("val after ||: " + val); // Still 5

        // ============ 6. BITWISE OPERATORS ============
        System.out.println("\n=== Bitwise Operators ===");

        int m = 5; // Binary: 0101
        int n = 3; // Binary: 0011

        System.out.println("m & n = " + (m & n)); // AND: 1 (0001)
        System.out.println("m | n = " + (m | n)); // OR: 7 (0111)
        System.out.println("m ^ n = " + (m ^ n)); // XOR: 6 (0110)
        System.out.println("~m = " + (~m)); // NOT: -6
        System.out.println("m << 1 = " + (m << 1)); // Left shift: 10 (1010)
        System.out.println("m >> 1 = " + (m >> 1)); // Right shift: 2 (0010)
        System.out.println("m >>> 1 = " + (m >>> 1)); // Unsigned right shift: 2

        // ============ 7. TERNARY OPERATOR ============
        System.out.println("\n=== Ternary Operator ===");

        int age = 18;
        String status = (age >= 18) ? "Adult" : "Minor";
        System.out.println("Status: " + status);

        // Nested ternary
        int score = 75;
        String grade = (score >= 90) ? "A" : (score >= 80) ? "B" : (score >= 70) ? "C" : (score >= 60) ? "D" : "F";
        System.out.println("Grade: " + grade);

        // ============ 8. INSTANCEOF OPERATOR ============
        System.out.println("\n=== instanceof Operator ===");

        String str = "Hello";
        Integer integer = 5;

        System.out.println("str instanceof String: " + (str instanceof String)); // true
        System.out.println("integer instanceof Integer: " + (integer instanceof Integer)); // true
        System.out.println("integer instanceof Number: " + (integer instanceof Number)); // true

        // ============ OPERATOR PRECEDENCE ============
        System.out.println("\n=== Operator Precedence ===");

        // Highest to Lowest (simplified):
        // 1. () parentheses
        // 2. ++, --, !, ~ (unary)
        // 3. *, /, %
        // 4. +, -
        // 5. <<, >>, >>>
        // 6. <, <=, >, >=, instanceof
        // 7. ==, !=
        // 8. &
        // 9. ^
        // 10. |
        // 11. &&
        // 12. ||
        // 13. ?:
        // 14. =, +=, -=, etc.

        int result1 = 10 + 5 * 2; // 20 (not 30)
        int result2 = (10 + 5) * 2; // 30
        System.out.println("10 + 5 * 2 = " + result1);
        System.out.println("(10 + 5) * 2 = " + result2);
    }
}
