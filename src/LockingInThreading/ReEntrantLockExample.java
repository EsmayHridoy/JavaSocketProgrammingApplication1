package LockingInThreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReEntrantLockExample {
    Lock lock = new ReentrantLock();

    private void homeLock(){
        lock.lock();

        try{
            System.out.println(Thread.currentThread().getName()+ " Entering to the home....");
            bedRoom();
        }catch (Exception e){
            System.out.println("Hey! "+Thread.currentThread().getName()+". Someone are currently in the room.");
        }finally {
            lock.unlock();
            System.out.println(Thread.currentThread().getName()+ " Get out from home");
        }
    }

    private void bedRoom(){
        lock.lock();
        try{
            System.out.println(Thread.currentThread().getName()+" Entering the bedroom.");
            System.out.println("Sleeping "+Thread.currentThread().getName());
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Awake "+Thread.currentThread().getName()+". Get out from bedroom");
            lock.unlock();
        }
    }


    public static void main(String[] args){
        ReEntrantLockExample object = new ReEntrantLockExample();


        Runnable task = new Runnable() {
            @Override
            public void run() {
                object.homeLock();
            }
        };


        Thread t1 = new Thread(task,"Rokon");
        Thread t2 = new Thread(task,"Esmay");

        t1.start();
        t2.start();
    }
}




/*

ReentrantLock

lock()
tryLock()
unlock()
lockInterruptibly();

 */
