package multithreading;

// Example showing deadlock and how to avoid it

public class handledeadlock {

    // Two shared resources
    private static final Object RESOURCE_A = new Object();
    private static final Object RESOURCE_B = new Object();

    public static void main(String[] args) {
        System.out.println("=== DEADLOCK AVOIDED by acquiring locks in same order ===\n");

        // Thread 1: Acquires A then B
        Thread t1 = new Thread(() -> {
            synchronized (RESOURCE_A) {
                System.out.println("Thread-1: Locked Resource A");

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (RESOURCE_B) {
                    System.out.println("Thread-1: Locked Resource B");
                    System.out.println("Thread-1: Working with both resources");
                }
            }
        }, "Thread-1");

        // Thread 2: Also acquires A then B (SAME ORDER - NO DEADLOCK)
        // If we did B then A (opposite order), DEADLOCK would occur!
        Thread t2 = new Thread(() -> {
            synchronized (RESOURCE_A) { // Same order as Thread-1
                System.out.println("Thread-2: Locked Resource A");

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (RESOURCE_B) {
                    System.out.println("Thread-2: Locked Resource B");
                    System.out.println("Thread-2: Working with both resources");
                }
            }
        }, "Thread-2");

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\nBoth threads completed successfully - No Deadlock!");
    }
}

/*
 * ================== DEADLOCK SCENARIO (DON'T DO THIS) ==================
 * 
 * Thread-1: locks A, then tries to lock B
 * Thread-2: locks B, then tries to lock A
 * 
 * Result: Both threads wait forever for each other's lock
 * 
 * ================== HOW TO AVOID DEADLOCK ==================
 * 
 * 1. Lock Ordering: Always acquire locks in the SAME order
 * 2. Lock Timeout: Use tryLock() with timeout instead of synchronized
 * 3. Avoid Nested Locks: Don't hold multiple locks at once
 * 4. Use tryLock():
 * ReentrantLock lock = new ReentrantLock();
 * if (lock.tryLock(1, TimeUnit.SECONDS)) {
 * try { ... } finally { lock.unlock(); }
 * }
 */
