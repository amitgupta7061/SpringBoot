
/**
 * 24_RegularExpressions.java - Pattern Matching and Regex
 */

import java.util.regex.*;

class RegularExpressions {
    public static void main(String[] args) {
        // === Basic Pattern Matching ===
        String text = "Hello World 123";

        // matches() - entire string must match
        System.out.println("Contains digits: " + text.matches(".*\\d+.*"));

        // === String methods with regex ===
        System.out.println("\n=== String Regex Methods ===");

        // split()
        String csv = "apple,banana,cherry";
        String[] fruits = csv.split(",");
        for (String f : fruits)
            System.out.println(f);

        // replaceAll()
        String result = "Hello 123 World 456".replaceAll("\\d+", "#");
        System.out.println("Replaced: " + result);

        // replaceFirst()
        String first = "cat cat cat".replaceFirst("cat", "dog");
        System.out.println("First replaced: " + first);

        // === Pattern and Matcher ===
        System.out.println("\n=== Pattern & Matcher ===");

        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher("abc 123 def 456");

        while (matcher.find()) {
            System.out.println("Found: " + matcher.group() + " at " + matcher.start());
        }

        // === Common Patterns ===
        System.out.println("\n=== Common Patterns ===");

        // Email validation
        String email = "test@example.com";
        boolean isEmail = email.matches("^[\\w.-]+@[\\w.-]+\\.[a-z]{2,}$");
        System.out.println("Valid email: " + isEmail);

        // Phone validation
        String phone = "123-456-7890";
        boolean isPhone = phone.matches("\\d{3}-\\d{3}-\\d{4}");
        System.out.println("Valid phone: " + isPhone);

        // === Regex Syntax ===
        /*
         * . - Any character
         * \d - Digit [0-9]
         * \D - Non-digit
         * \w - Word char [a-zA-Z0-9_]
         * \W - Non-word char
         * \s - Whitespace
         * \S - Non-whitespace
         * ^ - Start of string
         * $ - End of string
         * * - 0 or more
         * + - 1 or more
         * ? - 0 or 1
         * {n} - Exactly n times
         * {n,} - n or more times
         * {n,m} - Between n and m times
         * [] - Character class
         * | - OR
         * () - Grouping
         */

        // === Groups ===
        System.out.println("\n=== Groups ===");
        Pattern datePattern = Pattern.compile("(\\d{4})-(\\d{2})-(\\d{2})");
        Matcher dateMatcher = datePattern.matcher("Date: 2024-12-25");

        if (dateMatcher.find()) {
            System.out.println("Full: " + dateMatcher.group(0));
            System.out.println("Year: " + dateMatcher.group(1));
            System.out.println("Month: " + dateMatcher.group(2));
            System.out.println("Day: " + dateMatcher.group(3));
        }

        // === Case Insensitive ===
        Pattern ci = Pattern.compile("hello", Pattern.CASE_INSENSITIVE);
        System.out.println("Match: " + ci.matcher("HELLO").matches());
    }
}
