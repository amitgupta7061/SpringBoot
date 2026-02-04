package multithreading;

// Example of interthread communication using wait(), notify(), notifyAll()

// Shared data between producer and consumer
class SharedQueue {
    private int data;
    private boolean hasData = false;

    // Producer calls this to add data
    public synchronized void produce(int value) {
        // Wait if data is already present (consumer hasn't consumed yet)
        while (hasData) {
            try {
                wait(); // Release lock and wait
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Produce data
        data = value;
        hasData = true;
        System.out.println("Produced: " + value);

        // Notify consumer that data is available
        notify();
    }

    // Consumer calls this to consume data
    public synchronized int consume() {
        // Wait if no data is present
        while (!hasData) {
            try {
                wait(); // Release lock and wait
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Consume data
        hasData = false;
        System.out.println("Consumed: " + data);

        // Notify producer that it can produce more
        notify();

        return data;
    }
}

// Producer thread
class Producer extends Thread {
    private SharedQueue queue;

    public Producer(SharedQueue queue) {
        this.queue = queue;
    }

    public void run() {
        for (int i = 1; i <= 5; i++) {
            queue.produce(i);
            try {
                Thread.sleep(100); // Simulate production time
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

// Consumer thread
class Consumer extends Thread {
    private SharedQueue queue;

    public Consumer(SharedQueue queue) {
        this.queue = queue;
    }

    public void run() {
        for (int i = 1; i <= 5; i++) {
            queue.consume();
            try {
                Thread.sleep(200); // Simulate consumption time
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class interthreadcomm {

    public static void main(String[] args) {
        SharedQueue queue = new SharedQueue();

        Producer producer = new Producer(queue);
        Consumer consumer = new Consumer(queue);

        producer.start();
        consumer.start();

        try {
            producer.join();
            consumer.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Done!");
    }
}
