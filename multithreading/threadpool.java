package multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

// Task 1: Calculate sum (implements Runnable)
class SumTask implements Runnable {
    public void run() {
        long sum = 0;
        for (int i = 1; i <= 10000000; i++) {
            sum += i;
        }
        System.out.println("Sum of first " + 10000000 + " natural numbers is: " + sum);
    }
}

// Task 2: Count numbers divisible by 7
class CountTask implements Runnable {
    public void run() {
        int cnt = 0;
        for (int i = 1; i <= 10000000; i++) {
            if (i % 7 == 0) {
                cnt++;
            }
        }
        System.out.println("Count of numbers divisible by 7 is: " + cnt);
    }
}

public class threadpool {

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        // Create a thread pool with 2 threads
        ExecutorService executor = Executors.newFixedThreadPool(2);

        // Submit tasks to the pool
        executor.submit(new SumTask());
        executor.submit(new CountTask());

        // Shutdown the executor (no new tasks accepted)
        executor.shutdown();

        // Wait for all tasks to complete
        try {
            executor.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long endTime = System.currentTimeMillis();
        System.out.println("Time taken: " + (endTime - startTime) + "ms");
    }
}

/*
 * ================== THREAD POOL TYPES ==================
 * 
 * 1. newFixedThreadPool(n) - Fixed number of threads
 * 2. newCachedThreadPool() - Creates threads as needed, reuses idle ones
 * 3. newSingleThreadExecutor() - Single thread for sequential execution
 * 4. newScheduledThreadPool(n) - For scheduled/periodic tasks
 * 
 * ================== BENEFITS ==================
 * 
 * - Thread reuse (no overhead of creating new threads)
 * - Controls max number of concurrent threads
 * - Better resource management
 * - Built-in task queue
 */
