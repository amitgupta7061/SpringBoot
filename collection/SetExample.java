package collection;

import java.util.*;

public class SetExample {

    public static void main(String[] args) {

        // ==================== HASHSET ====================
        System.out.println("=== HashSet ===");
        // - No duplicates, unordered
        // - O(1) for add, remove, contains
        // - Uses hashCode() and equals()

        HashSet<String> hashSet = new HashSet<>();

        // Adding elements
        hashSet.add("Apple");
        hashSet.add("Banana");
        hashSet.add("Cherry");
        hashSet.add("Apple"); // Duplicate - won't be added
        System.out.println("HashSet: " + hashSet);

        // Check and size
        System.out.println("Contains 'Banana': " + hashSet.contains("Banana"));
        System.out.println("Size: " + hashSet.size());
        System.out.println("isEmpty: " + hashSet.isEmpty());

        // Remove
        hashSet.remove("Banana");
        System.out.println("After remove 'Banana': " + hashSet);

        // ==================== LINKEDHASHSET ====================
        System.out.println("\n=== LinkedHashSet ===");
        // - No duplicates, maintains INSERTION ORDER
        // - Slightly slower than HashSet

        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();

        linkedHashSet.add("Zebra");
        linkedHashSet.add("Apple");
        linkedHashSet.add("Mango");
        System.out.println("LinkedHashSet (insertion order): " + linkedHashSet);

        // ==================== TREESET ====================
        System.out.println("\n=== TreeSet ===");
        // - No duplicates, SORTED ORDER
        // - O(log n) for add, remove, contains
        // - Uses Comparable or Comparator

        TreeSet<Integer> treeSet = new TreeSet<>();

        // Adding elements
        treeSet.add(50);
        treeSet.add(20);
        treeSet.add(80);
        treeSet.add(10);
        treeSet.add(60);
        System.out.println("TreeSet (sorted): " + treeSet);

        // Navigation methods
        System.out.println("first(): " + treeSet.first());
        System.out.println("last(): " + treeSet.last());
        System.out.println("lower(50): " + treeSet.lower(50)); // Strictly less than
        System.out.println("higher(50): " + treeSet.higher(50)); // Strictly greater than
        System.out.println("floor(55): " + treeSet.floor(55)); // Less than or equal
        System.out.println("ceiling(55): " + treeSet.ceiling(55)); // Greater than or equal

        // Subset
        System.out.println("headSet(50): " + treeSet.headSet(50)); // Elements < 50
        System.out.println("tailSet(50): " + treeSet.tailSet(50)); // Elements >= 50
        System.out.println("subSet(20, 60): " + treeSet.subSet(20, 60)); // [20, 60)

        // Poll (retrieve and remove)
        System.out.println("pollFirst(): " + treeSet.pollFirst());
        System.out.println("pollLast(): " + treeSet.pollLast());
        System.out.println("After polls: " + treeSet);

        // Descending order
        System.out.println("descendingSet(): " + treeSet.descendingSet());

        // ==================== TREESET WITH CUSTOM COMPARATOR ====================
        System.out.println("\n=== TreeSet with Comparator ===");

        TreeSet<String> reverseSet = new TreeSet<>(Comparator.reverseOrder());
        reverseSet.add("Apple");
        reverseSet.add("Mango");
        reverseSet.add("Banana");
        System.out.println("Reverse order: " + reverseSet);

        // Custom comparator by length
        TreeSet<String> byLength = new TreeSet<>(Comparator.comparingInt(String::length));
        byLength.add("Hi");
        byLength.add("Hello");
        byLength.add("Hey");
        System.out.println("By length: " + byLength);

        // ==================== SET OPERATIONS ====================
        System.out.println("\n=== Set Operations ===");

        Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(4, 5, 6, 7, 8));

        // Union
        Set<Integer> union = new HashSet<>(set1);
        union.addAll(set2);
        System.out.println("Union: " + union);

        // Intersection
        Set<Integer> intersection = new HashSet<>(set1);
        intersection.retainAll(set2);
        System.out.println("Intersection: " + intersection);

        // Difference (set1 - set2)
        Set<Integer> difference = new HashSet<>(set1);
        difference.removeAll(set2);
        System.out.println("Difference (set1 - set2): " + difference);

        // ==================== ITERATION ====================
        System.out.println("\n=== Iteration ===");

        Set<String> colors = new HashSet<>(Arrays.asList("Red", "Green", "Blue"));

        // For-each
        System.out.print("For-each: ");
        for (String color : colors) {
            System.out.print(color + " ");
        }
        System.out.println();

        // Iterator
        System.out.print("Iterator: ");
        Iterator<String> it = colors.iterator();
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
        System.out.println();

        // forEach lambda
        System.out.print("forEach lambda: ");
        colors.forEach(c -> System.out.print(c + " "));
        System.out.println();

        // Convert to List
        List<String> colorList = new ArrayList<>(colors);
        System.out.println("Converted to List: " + colorList);
    }
}
