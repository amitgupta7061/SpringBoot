/**
 * 20_Multithreading.java - Threads, Runnable, Synchronization
 */

class Multithreading {
    public static void main(String[] args) throws InterruptedException {
        // === Creating Threads ===

        // Method 1: Extending Thread class
        MyThread t1 = new MyThread("Thread-1");
        t1.start();

        // Method 2: Implementing Runnable
        Thread t2 = new Thread(new MyRunnable(), "Thread-2");
        t2.start();

        // Method 3: Lambda (Java 8+)
        Thread t3 = new Thread(() -> {
            System.out.println("Lambda thread running");
        });
        t3.start();

        // === Thread Methods ===
        Thread current = Thread.currentThread();
        System.out.println("Main thread: " + current.getName());

        // Sleep
        Thread.sleep(100); // Pause for 100ms

        // Join - wait for thread to complete
        t1.join();
        System.out.println("Thread-1 finished");

        // === Thread States ===
        // NEW, RUNNABLE, BLOCKED, WAITING, TIMED_WAITING, TERMINATED

        // === Priority ===
        Thread t4 = new Thread(() -> System.out.println("Priority thread"));
        t4.setPriority(Thread.MAX_PRIORITY); // 1-10, default 5
        t4.start();

        // === Daemon Thread ===
        Thread daemon = new Thread(() -> {
            while (true) {
                /* Background task */ }
        });
        daemon.setDaemon(true); // Will stop when main thread ends
        daemon.start();

        // === Synchronization ===
        Counter counter = new Counter();
        Thread inc1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++)
                counter.increment();
        });
        Thread inc2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++)
                counter.increment();
        });
        inc1.start();
        inc2.start();
        inc1.join();
        inc2.join();
        System.out.println("Counter: " + counter.getCount()); // Should be 2000

        // === Wait and Notify ===
        SharedResource resource = new SharedResource();
        new Thread(() -> resource.produce()).start();
        new Thread(() -> resource.consume()).start();
    }
}

// Extend Thread
class MyThread extends Thread {
    MyThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println(getName() + " is running");
    }
}

// Implement Runnable
class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " running");
    }
}

// Synchronized counter
class Counter {
    private int count = 0;

    // Synchronized method
    public synchronized void increment() {
        count++;
    }

    public int getCount() {
        return count;
    }
}

// Wait/Notify example
class SharedResource {
    private boolean ready = false;

    public synchronized void produce() {
        System.out.println("Producing...");
        ready = true;
        notify(); // Wake up waiting thread
    }

    public synchronized void consume() {
        while (!ready) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        System.out.println("Consuming...");
    }
}
