package LockingInThreading;

public class BankAccount {
    private int balance = 100;


    public void withdraw(int amount) throws InterruptedException {
        System.out.println(Thread.currentThread().getName()+ ": Attempting to withdraw with amount:  "+ amount);
        if(balance >= amount){
            System.out.println(Thread.currentThread().getName()+": Processing with withdrawal.");
            Thread.sleep(10000);
            balance-=amount;
            System.out.println(Thread.currentThread().getName()+": Withdrawal successful. Current balance: "+balance);
        }
        else{
            System.out.println(Thread.currentThread().getName()+": Insufficient balance. Current balance: "+balance);
        }
    }
}
