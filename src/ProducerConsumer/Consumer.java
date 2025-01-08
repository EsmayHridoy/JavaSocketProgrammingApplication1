package ProducerConsumer;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {
    private BlockingQueue<String>q;
    private Thread thread;
    private String name;
    Consumer(BlockingQueue<String>q,String name){
        this.name = name;
        this.q = q;
        thread = new Thread(this, name);

        thread.start();

    }

    @Override
    public void run() {

        while(true){
            if(q.size()<1){
                System.out.println("There is no product. Go for sleep");
                try {
                    thread.sleep(6000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            try {
                System.out.println(name+" is eating "+q.take());
                thread.sleep(900);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }


    }
}
