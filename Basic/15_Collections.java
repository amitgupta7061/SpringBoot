
/**
 * 15_Collections.java - ArrayList, LinkedList, HashMap, HashSet, etc.
 */

import java.util.*;

class Collections15 {
    public static void main(String[] args) {
        // === ArrayList ===
        System.out.println("=== ArrayList ===");
        ArrayList<String> list = new ArrayList<>();
        list.add("Apple");
        list.add("Banana");
        list.add(1, "Orange"); // Insert at index

        System.out.println("Size: " + list.size());
        System.out.println("Get(0): " + list.get(0));
        list.set(0, "Mango"); // Update
        list.remove("Banana"); // Remove by value
        list.remove(0); // Remove by index

        for (String item : list)
            System.out.println(item);

        // === LinkedList ===
        System.out.println("\n=== LinkedList ===");
        LinkedList<Integer> linked = new LinkedList<>();
        linked.add(1);
        linked.addFirst(0);
        linked.addLast(2);
        System.out.println("First: " + linked.getFirst());
        System.out.println("Last: " + linked.getLast());

        // === HashSet (No duplicates) ===
        System.out.println("\n=== HashSet ===");
        HashSet<String> set = new HashSet<>();
        set.add("A");
        set.add("B");
        set.add("A"); // Ignored (duplicate)
        System.out.println("Contains A: " + set.contains("A"));
        System.out.println("Size: " + set.size()); // 2

        // === TreeSet (Sorted) ===
        System.out.println("\n=== TreeSet ===");
        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(30);
        treeSet.add(10);
        treeSet.add(20);
        System.out.println("Sorted: " + treeSet); // [10, 20, 30]

        // === HashMap ===
        System.out.println("\n=== HashMap ===");
        HashMap<String, Integer> map = new HashMap<>();
        map.put("Alice", 25);
        map.put("Bob", 30);

        System.out.println("Alice: " + map.get("Alice"));
        System.out.println("Contains Bob: " + map.containsKey("Bob"));

        // Iterate
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        // === TreeMap (Sorted by keys) ===
        TreeMap<String, Integer> treeMap = new TreeMap<>();
        treeMap.put("C", 3);
        treeMap.put("A", 1);
        treeMap.put("B", 2);
        System.out.println("\nTreeMap: " + treeMap); // Sorted

        // === Stack ===
        System.out.println("\n=== Stack ===");
        Stack<String> stack = new Stack<>();
        stack.push("A");
        stack.push("B");
        System.out.println("Pop: " + stack.pop());
        System.out.println("Peek: " + stack.peek());

        // === Queue ===
        System.out.println("\n=== Queue ===");
        Queue<String> queue = new LinkedList<>();
        queue.offer("First");
        queue.offer("Second");
        System.out.println("Poll: " + queue.poll());
        System.out.println("Peek: " + queue.peek());

        // === PriorityQueue ===
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(30);
        pq.offer(10);
        pq.offer(20);
        System.out.println("PQ poll: " + pq.poll()); // 10 (smallest)

        // === Collections utility ===
        System.out.println("\n=== Collections Utility ===");
        List<Integer> nums = new ArrayList<>(Arrays.asList(3, 1, 4, 1, 5));
        Collections.sort(nums);
        Collections.reverse(nums);
        Collections.shuffle(nums);
        System.out.println("Max: " + Collections.max(nums));
        System.out.println("Min: " + Collections.min(nums));
    }
}
