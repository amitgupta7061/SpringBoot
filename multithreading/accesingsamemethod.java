package multithreading;

// Shared counter class with synchronized method
class Counter {
    private int count = 0;

    // synchronized keyword ensures only one thread can execute this at a time
    public synchronized void increment() {
        count++;
    }

    public int getCount() {
        return count;
    }
}

// Thread class that increments the counter
class IncrementThread extends Thread {
    private Counter counter;

    public IncrementThread(Counter counter) {
        this.counter = counter;
    }

    public void run() {
        for (int i = 0; i < 1000; i++) {
            counter.increment();
        }
    }
}

public class accesingsamemethod {

    public static void main(String[] args) {
        // Shared counter object
        Counter counter = new Counter();

        // Two threads working on the SAME counter object
        IncrementThread t1 = new IncrementThread(counter);
        IncrementThread t2 = new IncrementThread(counter);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // With synchronization: always 2000
        // Without synchronization: could be less than 2000 (race condition)
        System.out.println("Final count: " + counter.getCount());
    }
}
