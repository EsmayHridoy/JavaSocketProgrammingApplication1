package LockingInThreading;

public class MainMethodExplicitLock {
    public static void main(String[] args){
        BankAccount2 bankAccount = new BankAccount2();
        Runnable task = new Runnable() {
            @Override
            public void run() {
                try {
                    bankAccount.withdraw(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread t1 = new Thread(task,"Thread#1");
        Thread t2 = new Thread(task,"Thread#2");
        t1.start();
        t2.start();
    }
}
