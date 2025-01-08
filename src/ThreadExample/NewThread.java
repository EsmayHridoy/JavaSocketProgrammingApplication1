package ThreadExample;

public class NewThread implements Runnable {
    String threadName;
    Thread thread;
    NewThread(String threadName){
        this.threadName = threadName;
        thread = new Thread(this,threadName);
        thread.start();
    }


    @Override
    public void run() {
        for(int i=20;i>0;i--){
            System.out.println(thread.getName() + " "+ i);
            try {
                thread.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Work done "+threadName);
    }
}
