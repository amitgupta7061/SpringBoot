
/**
 * 07_Arrays.java
 * Arrays in Java - Single, Multi-dimensional, and Operations
 */

import java.util.Arrays;

class Arrays07 {

    public static void main(String[] args) {

        // ============ 1. ARRAY DECLARATION & INITIALIZATION ============
        System.out.println("=== Array Declaration ===");

        // Method 1: Declaration then initialization
        int[] numbers;
        numbers = new int[5]; // Array of 5 integers (default 0)

        // Method 2: Declaration + allocation
        int[] ages = new int[3];

        // Method 3: Declaration + initialization with values
        int[] scores = { 90, 85, 78, 92, 88 };

        // Method 4: Using new keyword with values
        int[] marks = new int[] { 75, 80, 70, 85 };

        // Alternative syntax (less common)
        int nums[] = { 1, 2, 3 };

        // ============ 2. ACCESSING ARRAY ELEMENTS ============
        System.out.println("\n=== Accessing Elements ===");

        int[] arr = { 10, 20, 30, 40, 50 };

        System.out.println("First element: " + arr[0]);
        System.out.println("Last element: " + arr[arr.length - 1]);
        System.out.println("Array length: " + arr.length);

        // Modify element
        arr[2] = 100;
        System.out.println("Modified element: " + arr[2]);

        // ============ 3. ITERATING OVER ARRAYS ============
        System.out.println("\n=== Iterating Arrays ===");

        int[] data = { 1, 2, 3, 4, 5 };

        // For loop
        System.out.print("For loop: ");
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();

        // For-each loop
        System.out.print("For-each: ");
        for (int num : data) {
            System.out.print(num + " ");
        }
        System.out.println();

        // Using Arrays.toString()
        System.out.println("Arrays.toString(): " + Arrays.toString(data));

        // ============ 4. MULTI-DIMENSIONAL ARRAYS ============
        System.out.println("\n=== 2D Arrays ===");

        // 2D Array declaration
        int[][] matrix = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };

        // Accessing 2D array elements
        System.out.println("Element [1][2]: " + matrix[1][2]); // 6

        // Iterating 2D array
        System.out.println("Matrix:");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        // For-each with 2D array
        System.out.println("\nUsing for-each:");
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }

        // Jagged array (different column sizes)
        System.out.println("\n=== Jagged Array ===");
        int[][] jagged = new int[3][];
        jagged[0] = new int[] { 1, 2 };
        jagged[1] = new int[] { 3, 4, 5 };
        jagged[2] = new int[] { 6 };

        for (int[] row : jagged) {
            System.out.println(Arrays.toString(row));
        }

        // 3D Array
        int[][][] cube = {
                { { 1, 2 }, { 3, 4 } },
                { { 5, 6 }, { 7, 8 } }
        };
        System.out.println("3D element [1][0][1]: " + cube[1][0][1]); // 6

        // ============ 5. ARRAYS CLASS UTILITY METHODS ============
        System.out.println("\n=== Arrays Utility Methods ===");

        int[] unsorted = { 5, 2, 8, 1, 9, 3 };

        // Sorting
        int[] sorted = Arrays.copyOf(unsorted, unsorted.length);
        Arrays.sort(sorted);
        System.out.println("Sorted: " + Arrays.toString(sorted));

        // Binary search (array must be sorted)
        int index = Arrays.binarySearch(sorted, 5);
        System.out.println("Index of 5: " + index);

        // Fill array
        int[] filled = new int[5];
        Arrays.fill(filled, 42);
        System.out.println("Filled: " + Arrays.toString(filled));

        // Copy array
        int[] original = { 1, 2, 3, 4, 5 };
        int[] copy = Arrays.copyOf(original, original.length);
        int[] partialCopy = Arrays.copyOfRange(original, 1, 4); // [2, 3, 4]
        System.out.println("Copy: " + Arrays.toString(copy));
        System.out.println("Partial copy: " + Arrays.toString(partialCopy));

        // Compare arrays
        int[] arr1 = { 1, 2, 3 };
        int[] arr2 = { 1, 2, 3 };
        int[] arr3 = { 1, 2, 4 };
        System.out.println("arr1 equals arr2: " + Arrays.equals(arr1, arr2)); // true
        System.out.println("arr1 equals arr3: " + Arrays.equals(arr1, arr3)); // false

        // ============ 6. COMMON ARRAY OPERATIONS ============
        System.out.println("\n=== Common Operations ===");

        int[] values = { 10, 25, 5, 30, 15 };

        // Find sum
        int sum = 0;
        for (int val : values) {
            sum += val;
        }
        System.out.println("Sum: " + sum);

        // Find max and min
        int max = values[0], min = values[0];
        for (int val : values) {
            if (val > max)
                max = val;
            if (val < min)
                min = val;
        }
        System.out.println("Max: " + max + ", Min: " + min);

        // Find average
        double avg = (double) sum / values.length;
        System.out.println("Average: " + avg);

        // Reverse array
        int[] reversed = new int[values.length];
        for (int i = 0; i < values.length; i++) {
            reversed[i] = values[values.length - 1 - i];
        }
        System.out.println("Reversed: " + Arrays.toString(reversed));

        // ============ 7. ARRAYS AS PARAMETERS ============
        System.out.println("\n=== Arrays as Parameters ===");

        int[] testArr = { 1, 2, 3, 4, 5 };
        printArray(testArr);
        modifyArray(testArr); // Arrays are passed by reference
        System.out.println("After modify: " + Arrays.toString(testArr));

        // ============ 8. STRING ARRAYS ============
        System.out.println("\n=== String Arrays ===");

        String[] names = { "Alice", "Bob", "Charlie" };

        for (String name : names) {
            System.out.println("Hello, " + name);
        }

        // Sort strings
        String[] fruits = { "Banana", "Apple", "Cherry" };
        Arrays.sort(fruits);
        System.out.println("Sorted fruits: " + Arrays.toString(fruits));
    }

    // Helper methods
    static void printArray(int[] arr) {
        System.out.println("Array: " + Arrays.toString(arr));
    }

    static void modifyArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] *= 2; // Doubles each element
        }
    }
}
