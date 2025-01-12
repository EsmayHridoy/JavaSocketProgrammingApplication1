package ReadWriteLocking;

public class ReadWriteLockingTest {

    public static void main(String[] args) throws InterruptedException {
        ReadWriteCounter object = new ReadWriteCounter();

        Runnable readTask = new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<10;i++){
                    System.out.println(Thread.currentThread().getName()+" are reading count. Count = "
                            + object.getCount());
                }
            }
        };

        Runnable writeTask = new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<10;i++){
                    System.out.println(Thread.currentThread().getName()+" are trying to write something");
                    object.increment();
                }
            }
        };


        Thread t1 = new Thread(writeTask,"Thread#1");
        Thread t2 = new Thread(readTask, "Thread#2");
        Thread t3 = new Thread(readTask, "Thread#3");


        t1.start();
        t2.start();
        t3.start();


        t1.join();
        t2.join();
        t3.join();

        System.out.println("The count is " + object.getCount());
    }
}
