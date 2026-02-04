package collection;

import java.util.*;

public class QueueExample {

    public static void main(String[] args) {

        // ==================== QUEUE (LinkedList) ====================
        System.out.println("=== Queue (FIFO) ===");
        // - First In First Out
        // - add/offer at tail, remove/poll from head

        Queue<String> queue = new LinkedList<>();

        // Adding elements
        queue.add("First"); // Throws exception if full
        queue.offer("Second"); // Returns false if full
        queue.offer("Third");
        System.out.println("Queue: " + queue);

        // Accessing head (without removing)
        System.out.println("element(): " + queue.element()); // Throws if empty
        System.out.println("peek(): " + queue.peek()); // Returns null if empty

        // Removing head
        System.out.println("remove(): " + queue.remove()); // Throws if empty
        System.out.println("After remove: " + queue);
        System.out.println("poll(): " + queue.poll()); // Returns null if empty
        System.out.println("After poll: " + queue);

        // Size
        System.out.println("Size: " + queue.size());
        System.out.println("isEmpty: " + queue.isEmpty());

        // ==================== PRIORITYQUEUE ====================
        System.out.println("\n=== PriorityQueue (Min-Heap) ===");
        // - Elements ordered by natural ordering or Comparator
        // - Head is always the smallest element

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        minHeap.add(50);
        minHeap.add(20);
        minHeap.add(80);
        minHeap.add(10);
        minHeap.add(60);
        System.out.println("PriorityQueue (min-heap): " + minHeap);
        System.out.println("peek (min): " + minHeap.peek());

        // Polling in order
        System.out.print("Poll order: ");
        while (!minHeap.isEmpty()) {
            System.out.print(minHeap.poll() + " ");
        }
        System.out.println();

        // Max-Heap using reverseOrder
        System.out.println("\n=== PriorityQueue (Max-Heap) ===");
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        maxHeap.addAll(Arrays.asList(50, 20, 80, 10, 60));
        System.out.println("PriorityQueue (max-heap): " + maxHeap);
        System.out.println("peek (max): " + maxHeap.peek());

        // Custom Comparator
        System.out.println("\n=== PriorityQueue with Custom Comparator ===");
        PriorityQueue<String> byLength = new PriorityQueue<>(Comparator.comparingInt(String::length));
        byLength.addAll(Arrays.asList("Hi", "Hello", "Hey", "Greetings"));
        System.out.print("By length: ");
        while (!byLength.isEmpty()) {
            System.out.print(byLength.poll() + " ");
        }
        System.out.println();

        // ==================== DEQUE (Double-Ended Queue) ====================
        System.out.println("\n=== Deque (ArrayDeque) ===");
        // - Can add/remove from both ends
        // - Can be used as Stack or Queue

        Deque<String> deque = new ArrayDeque<>();

        // Add at both ends
        deque.addFirst("First");
        deque.addLast("Last");
        deque.offerFirst("New First");
        deque.offerLast("New Last");
        System.out.println("Deque: " + deque);

        // Access both ends
        System.out.println("getFirst(): " + deque.getFirst());
        System.out.println("getLast(): " + deque.getLast());
        System.out.println("peekFirst(): " + deque.peekFirst());
        System.out.println("peekLast(): " + deque.peekLast());

        // Remove from both ends
        System.out.println("removeFirst(): " + deque.removeFirst());
        System.out.println("removeLast(): " + deque.removeLast());
        System.out.println("After removes: " + deque);

        // ==================== DEQUE AS STACK ====================
        System.out.println("\n=== Deque as Stack (LIFO) ===");
        Deque<Integer> stack = new ArrayDeque<>();

        // Push (add to top)
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println("Stack: " + stack);
        System.out.println("peek (top): " + stack.peek());

        // Pop (remove from top)
        System.out.print("Pop order: ");
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
        System.out.println();

        // ==================== LEGACY STACK CLASS ====================
        System.out.println("\n=== Stack (Legacy) ===");
        Stack<String> legacyStack = new Stack<>();
        legacyStack.push("Bottom");
        legacyStack.push("Middle");
        legacyStack.push("Top");
        System.out.println("Stack: " + legacyStack);
        System.out.println("peek: " + legacyStack.peek());
        System.out.println("pop: " + legacyStack.pop());
        System.out.println("search('Bottom'): " + legacyStack.search("Bottom")); // 1-based from top
        // Note: Use ArrayDeque instead of Stack (legacy)

        // ==================== METHODS COMPARISON ====================
        System.out.println("\n=== Queue Methods Comparison ===");
        System.out.println("            | Throws Exception | Returns Special Value");
        System.out.println("------------|------------------|----------------------");
        System.out.println("Insert      | add(e)           | offer(e)");
        System.out.println("Remove      | remove()         | poll()");
        System.out.println("Examine     | element()        | peek()");
    }
}
