package LockingInThreading;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount2 {
    private int balance = 100;
    private final Lock lock = new ReentrantLock();

    public void withdraw(int amount) throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + ": attempting to withdraw. Current amount: "+ balance);

        if(lock.tryLock(5001,TimeUnit.MILLISECONDS)){
            if(balance>=amount){
                System.out.println(Thread.currentThread().getName()+": Processing with withdrawal. Amount: " + amount);
                Thread.sleep(5000);
                balance-=amount;
                System.out.println(Thread.currentThread().getName()+": Withdrawal successful."+"Amount: "+amount+
                        " Current balance: "+balance);
                lock.unlock();
            }
            else{
                System.out.println(Thread.currentThread().getName()+": Insufficient balance. Current balance: "+balance);
            }
        }else{
            System.out.println("Account is busy. Please try again later");
        }
    }
}
