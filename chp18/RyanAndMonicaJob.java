package chp18;

public class RyanAndMonicaJob implements Runnable {
    private final String name;
    private final BankAccount account;
    private final int amountToSpend;

    public RyanAndMonicaJob(String name, BankAccount account, int amountToSpend) {
        this.name = name;
        this.account = account;
        this.amountToSpend = amountToSpend;
    }

    @Override
    public void run() {
        goShopping(amountToSpend);
    }

    private void goShopping(int amount) {
        //synchronized(account){
            // make sure we have enough money
            if (account.getBalance() >= amount) {
                System.out.println(name + " is going to spend " + amount);
                account.spend(name,amount);
                System.out.println(name + " finished shopping");
            }else {
                System.out.println("Sorry, not enough for " + name);
            }
        //}
    }
}
