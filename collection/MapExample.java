package collection;

import java.util.*;

public class MapExample {

    public static void main(String[] args) {

        // ==================== HASHMAP ====================
        System.out.println("=== HashMap ===");
        // - Key-value pairs, unordered
        // - O(1) for get, put, remove
        // - Allows one null key, multiple null values

        HashMap<String, Integer> hashMap = new HashMap<>();

        // Adding entries
        hashMap.put("Apple", 100);
        hashMap.put("Banana", 50);
        hashMap.put("Cherry", 75);
        hashMap.put("Apple", 120); // Updates existing key
        System.out.println("HashMap: " + hashMap);

        // Getting values
        System.out.println("get('Apple'): " + hashMap.get("Apple"));
        System.out.println("get('Mango'): " + hashMap.get("Mango")); // null

        // getOrDefault
        System.out.println("getOrDefault('Mango', 0): " + hashMap.getOrDefault("Mango", 0));

        // Check key/value
        System.out.println("containsKey('Banana'): " + hashMap.containsKey("Banana"));
        System.out.println("containsValue(50): " + hashMap.containsValue(50));

        // Size
        System.out.println("Size: " + hashMap.size());
        System.out.println("isEmpty: " + hashMap.isEmpty());

        // Remove
        hashMap.remove("Cherry");
        System.out.println("After remove('Cherry'): " + hashMap);

        // putIfAbsent - adds only if key doesn't exist
        hashMap.putIfAbsent("Apple", 999); // Won't change
        hashMap.putIfAbsent("Mango", 80); // Will add
        System.out.println("After putIfAbsent: " + hashMap);

        // ==================== LINKEDHASHMAP ====================
        System.out.println("\n=== LinkedHashMap ===");
        // - Maintains INSERTION ORDER
        // - Slightly slower than HashMap

        LinkedHashMap<String, Integer> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("Zebra", 1);
        linkedHashMap.put("Apple", 2);
        linkedHashMap.put("Mango", 3);
        System.out.println("LinkedHashMap (insertion order): " + linkedHashMap);

        // ==================== TREEMAP ====================
        System.out.println("\n=== TreeMap ===");
        // - SORTED by keys
        // - O(log n) for get, put, remove
        // - No null keys allowed

        TreeMap<String, Integer> treeMap = new TreeMap<>();
        treeMap.put("Cherry", 75);
        treeMap.put("Apple", 100);
        treeMap.put("Banana", 50);
        System.out.println("TreeMap (sorted by key): " + treeMap);

        // Navigation methods
        System.out.println("firstKey(): " + treeMap.firstKey());
        System.out.println("lastKey(): " + treeMap.lastKey());
        System.out.println("lowerKey('Banana'): " + treeMap.lowerKey("Banana"));
        System.out.println("higherKey('Banana'): " + treeMap.higherKey("Banana"));
        System.out.println("floorKey('Blueberry'): " + treeMap.floorKey("Blueberry"));
        System.out.println("ceilingKey('Blueberry'): " + treeMap.ceilingKey("Blueberry"));

        // First/Last entry
        System.out.println("firstEntry(): " + treeMap.firstEntry());
        System.out.println("lastEntry(): " + treeMap.lastEntry());

        // SubMap
        System.out.println("headMap('Cherry'): " + treeMap.headMap("Cherry"));
        System.out.println("tailMap('Banana'): " + treeMap.tailMap("Banana"));

        // Descending
        System.out.println("descendingMap(): " + treeMap.descendingMap());

        // ==================== COMMON MAP OPERATIONS ====================
        System.out.println("\n=== Common Map Operations ===");

        Map<String, Integer> scores = new HashMap<>();
        scores.put("Alice", 90);
        scores.put("Bob", 85);
        scores.put("Charlie", 95);

        // Get all keys
        System.out.println("keySet(): " + scores.keySet());

        // Get all values
        System.out.println("values(): " + scores.values());

        // Get all entries
        System.out.println("entrySet(): " + scores.entrySet());

        // Compute - compute value if key exists
        scores.compute("Alice", (k, v) -> v + 10);
        System.out.println("After compute Alice+10: " + scores);

        // computeIfAbsent - add if key doesn't exist
        scores.computeIfAbsent("David", k -> 80);
        System.out.println("After computeIfAbsent David: " + scores);

        // computeIfPresent - update if key exists
        scores.computeIfPresent("Bob", (k, v) -> v + 5);
        System.out.println("After computeIfPresent Bob+5: " + scores);

        // merge - combine values
        scores.merge("Alice", 5, Integer::sum);
        System.out.println("After merge Alice+5: " + scores);

        // replace
        scores.replace("Charlie", 100);
        System.out.println("After replace Charlie=100: " + scores);

        // ==================== ITERATION ====================
        System.out.println("\n=== Iteration ===");

        Map<String, Integer> fruits = new HashMap<>();
        fruits.put("Apple", 10);
        fruits.put("Banana", 20);
        fruits.put("Cherry", 30);

        // For-each with entrySet
        System.out.println("For-each entrySet:");
        for (Map.Entry<String, Integer> entry : fruits.entrySet()) {
            System.out.println("  " + entry.getKey() + " = " + entry.getValue());
        }

        // For-each with keySet
        System.out.println("For-each keySet:");
        for (String key : fruits.keySet()) {
            System.out.println("  " + key + " = " + fruits.get(key));
        }

        // forEach with lambda
        System.out.println("forEach lambda:");
        fruits.forEach((k, v) -> System.out.println("  " + k + " = " + v));

        // Stream
        System.out.println("Stream filter values > 15:");
        fruits.entrySet().stream()
                .filter(e -> e.getValue() > 15)
                .forEach(e -> System.out.println("  " + e.getKey() + " = " + e.getValue()));

        // ==================== HASHTABLE (Legacy) ====================
        System.out.println("\n=== Hashtable (Legacy - Thread-safe) ===");
        Hashtable<String, Integer> hashtable = new Hashtable<>();
        hashtable.put("One", 1);
        hashtable.put("Two", 2);
        System.out.println("Hashtable: " + hashtable);
        // Note: Hashtable is synchronized but slower. Use ConcurrentHashMap instead.
    }
}
