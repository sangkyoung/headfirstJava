package chp18;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RyanMonicaTest {
    public static void main(String[] args) {
        // Create a BankAccount object
        BankAccount account = new BankAccount();
        // Create a Ryan and a Monica
        RyanAndMonicaJob ryan = new RyanAndMonicaJob("Ryan", account, 100);
        RyanAndMonicaJob monica = new RyanAndMonicaJob("Monica", account, 50);
        // Create two threads executor and give jobs and shutdown
        ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.execute(monica);
        executor.execute(ryan);
        executor.shutdown();
    }
}
