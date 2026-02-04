/**
 * 02_DataTypes.java
 * All Primitive and Reference Data Types in Java
 */

class DataTypes {

    public static void main(String[] args) {

        // ============ PRIMITIVE DATA TYPES ============

        // 1. byte - 8 bits (-128 to 127)
        byte myByte = 100;
        System.out.println("Byte: " + myByte);

        // 2. short - 16 bits (-32,768 to 32,767)
        short myShort = 5000;
        System.out.println("Short: " + myShort);

        // 3. int - 32 bits (-2^31 to 2^31-1) - Most commonly used
        int myInt = 100000;
        System.out.println("Int: " + myInt);

        // 4. long - 64 bits (-2^63 to 2^63-1) - Use 'L' suffix
        long myLong = 15000000000L;
        System.out.println("Long: " + myLong);

        // 5. float - 32 bits floating point - Use 'f' suffix
        float myFloat = 5.75f;
        System.out.println("Float: " + myFloat);

        // 6. double - 64 bits floating point - Most commonly used for decimals
        double myDouble = 19.99;
        System.out.println("Double: " + myDouble);

        // 7. boolean - true or false
        boolean isJavaFun = true;
        boolean isFishTasty = false;
        System.out.println("Boolean: " + isJavaFun);

        // 8. char - 16 bits Unicode character
        char myChar = 'A';
        char unicodeChar = '\u0041'; // Also 'A'
        System.out.println("Char: " + myChar + ", Unicode: " + unicodeChar);

        // ============ REFERENCE DATA TYPES ============

        // String - Sequence of characters
        String myString = "Hello Java";
        System.out.println("String: " + myString);

        // Array - Collection of similar elements
        int[] numbers = { 1, 2, 3, 4, 5 };
        System.out.println("Array element: " + numbers[0]);

        // ============ TYPE CASTING ============

        // Implicit Casting (Widening) - Automatic
        // byte -> short -> int -> long -> float -> double
        int numInt = 100;
        double numDouble = numInt; // Automatic casting
        System.out.println("Implicit cast: " + numDouble);

        // Explicit Casting (Narrowing) - Manual
        // double -> float -> long -> int -> short -> byte
        double anotherDouble = 9.78;
        int anotherInt = (int) anotherDouble; // Manual casting
        System.out.println("Explicit cast: " + anotherInt); // 9 (decimal lost)

        // ============ WRAPPER CLASSES ============

        Integer wrappedInt = 100; // Autoboxing
        int primitiveInt = wrappedInt; // Unboxing

        Double wrappedDouble = 10.5;
        Boolean wrappedBool = true;
        Character wrappedChar = 'A';

        // Useful methods
        int parsed = Integer.parseInt("123");
        String intToString = Integer.toString(100);
        int maxInt = Integer.MAX_VALUE;
        int minInt = Integer.MIN_VALUE;

        System.out.println("Parsed: " + parsed);
        System.out.println("Max Int: " + maxInt);
        System.out.println("Min Int: " + minInt);

        // ============ CONSTANTS ============

        final double PI = 3.14159; // Cannot be changed
        // PI = 3.14; // This would cause error
        System.out.println("Constant PI: " + PI);

        // ============ TYPE INFERENCE (Java 10+) ============

        var message = "Hello"; // Compiler infers String
        var number = 42; // Compiler infers int
        var decimal = 3.14; // Compiler infers double
        System.out.println("Var: " + message + ", " + number + ", " + decimal);
    }
}
