/**
 * 03_Variables.java
 * Variables, Naming Conventions, and Scope
 */

class Variables {

    // Instance variable (belongs to object)
    int instanceVar = 10;

    // Static/Class variable (belongs to class, shared by all objects)
    static int staticVar = 20;

    // Constant (final + static)
    static final String CONSTANT = "I cannot be changed";

    public static void main(String[] args) {

        // ============ VARIABLE DECLARATION & INITIALIZATION ============

        // Declaration
        int a;

        // Initialization
        a = 5;

        // Declaration + Initialization
        int b = 10;

        // Multiple declarations
        int x, y, z;
        x = 1;
        y = 2;
        z = 3;

        // Multiple declaration + initialization
        int p = 1, q = 2, r = 3;

        System.out.println("a=" + a + ", b=" + b);
        System.out.println("x=" + x + ", y=" + y + ", z=" + z);

        // ============ NAMING CONVENTIONS ============

        // 1. camelCase for variables and methods
        int studentAge = 25;
        String firstName = "John";
        double accountBalance = 1000.50;

        // 2. PascalCase for classes
        // class StudentRecord { }

        // 3. UPPER_SNAKE_CASE for constants
        final int MAX_SIZE = 100;
        final double PI_VALUE = 3.14159;

        // 4. Package names - all lowercase
        // package com.example.myapp;

        // Valid variable names
        int myVar = 1;
        int _myVar = 2;
        int $myVar = 3;
        int myVar123 = 4;
        int my_var = 5;

        // Invalid variable names (commented - would cause errors)
        // int 123myVar; // Cannot start with number
        // int my-var; // Cannot use hyphen
        // int my var; // Cannot have spaces
        // int class; // Cannot use reserved keywords

        System.out.println("Student Age: " + studentAge);

        // ============ VARIABLE SCOPE ============

        // Local variable - exists only in the block
        {
            int localVar = 100;
            System.out.println("Inside block: " + localVar);
        }
        // System.out.println(localVar); // Error! localVar not accessible

        // Loop scope
        for (int i = 0; i < 3; i++) {
            int loopVar = i * 2;
            System.out.println("Loop var: " + loopVar);
        }
        // System.out.println(i); // Error! i not accessible

        // Accessing static variable
        System.out.println("Static var: " + staticVar);
        System.out.println("Constant: " + CONSTANT);

        // Accessing instance variable (need object)
        Variables obj = new Variables();
        System.out.println("Instance var: " + obj.instanceVar);

        // ============ DEFAULT VALUES ============

        Variables demo = new Variables();
        demo.showDefaultValues();
    }

    // Instance variables have default values
    int defaultInt; // 0
    double defaultDouble; // 0.0
    boolean defaultBoolean; // false
    char defaultChar; // '\u0000' (null character)
    String defaultString; // null
    int[] defaultArray; // null

    void showDefaultValues() {
        System.out.println("\n=== Default Values ===");
        System.out.println("int: " + defaultInt);
        System.out.println("double: " + defaultDouble);
        System.out.println("boolean: " + defaultBoolean);
        System.out.println("char: '" + defaultChar + "'");
        System.out.println("String: " + defaultString);
        System.out.println("Array: " + defaultArray);
    }
}
