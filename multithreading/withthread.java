package multithreading;

// Method 1: Extending Thread class
class SumThread extends Thread {
    public void run() {
        long sum = 0;
        for (int i = 1; i <= 10000000; i++) {
            sum += i;
        }
        System.out.println("Sum of first " + 10000000 + " natural numbers is: " + sum);
    }
}

// Method 2: Implementing Runnable interface
class CountDivisibleBy7 implements Runnable {
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

public class withthread {

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        // Using extends Thread - can call start() directly
        SumThread t1 = new SumThread();

        // Using implements Runnable - need to wrap in Thread object
        Thread t2 = new Thread(new CountDivisibleBy7());

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long endTime = System.currentTimeMillis();
        System.out.println("Time taken: " + (endTime - startTime) + "ms");
    }
}
