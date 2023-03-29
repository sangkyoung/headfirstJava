package chp17;

import java.util.concurrent.*;

public class ClosingTime {
    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newFixedThreadPool(2);
        threadPool.execute(() -> longJob("Job 1"));
        threadPool.execute(() -> shortJob("Job 2"));

        threadPool.shutdown();
        try {
            boolean finished = threadPool.awaitTermination(1, TimeUnit.SECONDS);
            System.out.println("Finished? " + finished);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        threadPool.shutdownNow();
    }
    private static void longJob(String jobName) {
        for(int i=0;i<3;i++){
            System.out.println(jobName+" ["+i+"] is running on "+Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
    private static void shortJob(String jobName) {
        for(int i=0;i<3;i++){
            System.out.println(jobName+" ["+i+"] is running on "+Thread.currentThread().getName());
        }
    }
}
