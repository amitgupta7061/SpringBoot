package collection;

import java.util.*;

public class ListExample {

    public static void main(String[] args) {

        // ==================== ARRAYLIST ====================
        System.out.println("=== ArrayList ===");
        // - Dynamic array, fast random access O(1)
        // - Slow insert/delete in middle O(n)

        ArrayList<String> arrayList = new ArrayList<>();

        // Adding elements
        arrayList.add("Apple");
        arrayList.add("Banana");
        arrayList.add("Cherry");
        arrayList.add(1, "Mango"); // Add at specific index
        System.out.println("ArrayList: " + arrayList);

        // Accessing elements
        System.out.println("Get index 0: " + arrayList.get(0));
        System.out.println("First index of 'Banana': " + arrayList.indexOf("Banana"));

        // Modifying elements
        arrayList.set(0, "Apricot");
        System.out.println("After set(0, 'Apricot'): " + arrayList);

        // Size and check
        System.out.println("Size: " + arrayList.size());
        System.out.println("Contains 'Mango': " + arrayList.contains("Mango"));
        System.out.println("isEmpty: " + arrayList.isEmpty());

        // Removing elements
        arrayList.remove("Mango");
        arrayList.remove(0); // Remove by index
        System.out.println("After remove: " + arrayList);

        // Sublist
        List<String> subList = arrayList.subList(0, 1);
        System.out.println("Sublist(0,1): " + subList);

        // ==================== LINKEDLIST ====================
        System.out.println("\n=== LinkedList ===");
        // - Doubly linked list
        // - Fast insert/delete O(1) at ends
        // - Slow random access O(n)

        LinkedList<Integer> linkedList = new LinkedList<>();

        // Adding elements
        linkedList.add(10);
        linkedList.add(20);
        linkedList.addFirst(5); // Add at beginning
        linkedList.addLast(30); // Add at end
        System.out.println("LinkedList: " + linkedList);

        // Accessing elements
        System.out.println("getFirst: " + linkedList.getFirst());
        System.out.println("getLast: " + linkedList.getLast());
        System.out.println("peek: " + linkedList.peek()); // Head element

        // Removing elements
        linkedList.removeFirst();
        linkedList.removeLast();
        System.out.println("After remove first/last: " + linkedList);

        // Poll (retrieve and remove)
        System.out.println("poll: " + linkedList.poll());
        System.out.println("After poll: " + linkedList);

        // ==================== COMMON LIST OPERATIONS ====================
        System.out.println("\n=== Common List Operations ===");

        List<Integer> numbers = new ArrayList<>(Arrays.asList(5, 2, 8, 1, 9, 3));
        System.out.println("Original: " + numbers);

        // Sorting
        Collections.sort(numbers);
        System.out.println("Sorted: " + numbers);

        Collections.sort(numbers, Collections.reverseOrder());
        System.out.println("Reverse sorted: " + numbers);

        // Shuffle
        Collections.shuffle(numbers);
        System.out.println("Shuffled: " + numbers);

        // Min, Max
        System.out.println("Min: " + Collections.min(numbers));
        System.out.println("Max: " + Collections.max(numbers));

        // Frequency
        numbers.add(5);
        System.out.println("Frequency of 5: " + Collections.frequency(numbers, 5));

        // Reverse
        Collections.reverse(numbers);
        System.out.println("Reversed: " + numbers);

        // Convert to array
        Integer[] arr = numbers.toArray(new Integer[0]);
        System.out.println("Array: " + Arrays.toString(arr));

        // Clear
        numbers.clear();
        System.out.println("After clear, isEmpty: " + numbers.isEmpty());

        // ==================== ITERATION ====================
        System.out.println("\n=== Iteration Methods ===");

        List<String> fruits = Arrays.asList("Apple", "Banana", "Cherry");

        // For-each loop
        System.out.print("For-each: ");
        for (String fruit : fruits) {
            System.out.print(fruit + " ");
        }
        System.out.println();

        // Iterator
        System.out.print("Iterator: ");
        Iterator<String> it = fruits.iterator();
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
        System.out.println();

        // forEach with lambda
        System.out.print("forEach lambda: ");
        fruits.forEach(f -> System.out.print(f + " "));
        System.out.println();

        // Stream
        System.out.print("Stream: ");
        fruits.stream().forEach(f -> System.out.print(f + " "));
        System.out.println();
    }
}
