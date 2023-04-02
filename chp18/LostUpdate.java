package chp18;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class LostUpdate {
    public static void main(String[] args) {
        //create a executor service
        ExecutorService executor = Executors.newFixedThreadPool(2);

        //create a balance object and execute the increment method 1000 times
        Balance balance = new Balance();
        for (int i = 0; i < 1000; i++) {
            executor.execute(balance::increment);
        }
        //shutdown the executor service
        executor.shutdown();
        try {
            if (executor.awaitTermination(1, TimeUnit.MINUTES)){
                System.out.println("Balance is " + balance.balance);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
class Balance {
    AtomicInteger balance = new AtomicInteger(0);
    public void increment() {
        balance.incrementAndGet();
    }
}