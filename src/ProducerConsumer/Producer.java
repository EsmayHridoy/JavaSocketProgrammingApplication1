package ProducerConsumer;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {

    private BlockingQueue<String>q;
    private Thread thread;
    private String name;
    Producer(BlockingQueue<String>q,String name){
        this.name = name;
        this.q = q;
        thread = new Thread(this,name);

        thread.start();

    }

    @Override
    public void run() {
        int cakeNo = 1;
        while(true){
            if(q.size()>=4){
                System.out.println("Queue is full. Go for sleep");
                try {
                    thread.sleep(4000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            try {
                q.put("Cake"+cakeNo);
                System.out.println(name+": "+"cake"+cakeNo+" is made.");
                thread.sleep(500);
                cakeNo++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }
}
