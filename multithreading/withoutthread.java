package multithreading;

public class withoutthread {

    public static void sum() {
        long sum = 0;
        for (int i = 1; i <= 10000000; i++) {
            sum += i;
        }
        System.out.println("Sum of first " + 10000000 + " natural numbers is: " + sum);
    }

    public static void cntNumDivisibleBy7() {
        int cnt = 0;
        for (int i = 1; i <= 10000000; i++) {
            if (i % 7 == 0) {
                cnt++;
            }
        }
        System.out.println("Count of numbers divisible by 7 is: " + cnt);
    }

    public static void main(String[] args) {
        long currtTime = System.currentTimeMillis();
        sum();
        cntNumDivisibleBy7();
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken: " + (endTime - currtTime) + "ms");
    }
}
