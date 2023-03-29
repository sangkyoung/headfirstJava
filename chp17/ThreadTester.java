package chp17;

public class ThreadTester {
    public static void main(String[] args) {
        Runnable threadJob = new MyRunnable();
        Thread thread = new Thread(threadJob);

        thread.start();

        System.out.println(Thread.currentThread().getName()+": back in main");
        Thread.dumpStack();
    }
}
