/**
 * 08_Strings.java - String Operations
 */

class Strings {
    public static void main(String[] args) {
        // === String Creation ===
        String s1 = "Hello"; // String literal (pool)
        String s2 = new String("Hi"); // New object (heap)

        // === String Comparison ===
        System.out.println("== : " + (s1 == "Hello")); // true
        System.out.println("equals: " + s1.equals("Hello")); // true
        System.out.println("equalsIgnoreCase: " + s1.equalsIgnoreCase("HELLO"));

        // === Common Methods ===
        String str = "Hello World Java";
        System.out.println("Length: " + str.length());
        System.out.println("charAt(0): " + str.charAt(0));
        System.out.println("substring(0,5): " + str.substring(0, 5));
        System.out.println("indexOf('o'): " + str.indexOf('o'));
        System.out.println("contains(\"World\"): " + str.contains("World"));
        System.out.println("toUpperCase: " + str.toUpperCase());
        System.out.println("toLowerCase: " + str.toLowerCase());
        System.out.println("trim: '" + "  Hi  ".trim() + "'");
        System.out.println("replace: " + str.replace("World", "Universe"));

        // Split & Join
        String[] parts = "a,b,c".split(",");
        String joined = String.join("-", "2024", "01", "15");

        // === String Formatting ===
        String formatted = String.format("Name: %s, Age: %d", "John", 25);
        System.out.printf("Pi: %.2f%n", 3.14159);

        // === StringBuilder (Mutable) ===
        StringBuilder sb = new StringBuilder("Hello");
        sb.append(" World").insert(0, "Say: ").reverse();
        System.out.println("StringBuilder: " + sb);

        // === StringBuffer (Thread-Safe) ===
        StringBuffer buffer = new StringBuffer("Hi");
        buffer.append(" There");

        // === Conversion ===
        int num = Integer.parseInt("123");
        String numStr = String.valueOf(42);
    }
}
