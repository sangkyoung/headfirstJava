package chp17;

import java.util.concurrent.*;

public class PredictableLatch {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        CountDownLatch latch = new CountDownLatch(1);

        executor.execute(() -> waitForLatch(latch));

        System.out.println(Thread.currentThread().getName()+": back in main");
        latch.countDown();

        executor.shutdown();
    }

    private static void waitForLatch(CountDownLatch latch){
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+": back in waitForLatch");
    }
}
