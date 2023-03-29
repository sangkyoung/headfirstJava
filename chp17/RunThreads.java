package chp17;

import java.util.concurrent.*;

public class RunThreads {
    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newFixedThreadPool(2);
        threadPool.execute(() -> runJob("Job 1"));
        threadPool.execute(() -> runJob("Job 2"));
        threadPool.shutdown();
    }
    public static void runJob(String jobName) {
        for(int i=0;i<20;i++){
            System.out.println(jobName+" ["+i+"] is running on "+Thread.currentThread().getName());
        }
    }
}
