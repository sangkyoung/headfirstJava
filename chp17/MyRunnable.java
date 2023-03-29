package chp17;

public class MyRunnable implements Runnable {
    public void run() {
        go();
    }

    public void go() {
        doMore();
    }

    public void doMore() {
        System.out.println(Thread.currentThread().getName()+": top o' the stack");
        Thread.dumpStack();
    }
}