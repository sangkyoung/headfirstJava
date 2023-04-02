package chp18;

import java.util.concurrent.atomic.AtomicInteger;

public class BankAccount {
    private AtomicInteger balance = new AtomicInteger(100);

    public int getBalance() {
        return balance.get();
    }

    public void spend(String name,int amount) {
        //get the current balance
        int currentBalance = balance.get();
        //check if the current balance is enough
        if(currentBalance >= amount) {
            //if it is, spend the money
            Boolean success = balance.compareAndSet(currentBalance, currentBalance - amount);
            if(success) {
                System.out.println(name + " spend " + amount);
            }else {
                System.out.println("Sorry " + name + " failed to spend " + amount);
            }
        }else{
            System.out.println("Sorry, not enough for " + name);
        }
    }
}
