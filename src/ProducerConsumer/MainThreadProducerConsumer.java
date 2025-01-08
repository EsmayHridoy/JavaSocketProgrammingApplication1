package ProducerConsumer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class MainThreadProducerConsumer {
    public static void main(String[] args){
        BlockingQueue<String>q = new ArrayBlockingQueue<>(4);
        new Consumer(q,"Mr.Esmay Consumer");
        new Producer(q, "Mr. Rayhan Producer");
    }
}
