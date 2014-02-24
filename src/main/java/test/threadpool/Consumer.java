package test.threadpool;

import java.util.concurrent.BlockingQueue;

/**
 * Created by chenhf on 14-2-24.
 */
public class Consumer implements Runnable{
    private BlockingQueue<String> queue;
    private int id;

    public Consumer(int id,BlockingQueue<String> queue)
    {
        this.id = id;
        this.queue = queue;
    }



    @Override
    public void run() {
        while(!Thread.currentThread().isInterrupted())
        {
            try {
                String e =  queue.take();
                String threadName = Thread.currentThread().getName();
                System.out.println("id = " + id + ", thread " + threadName + ": value=" + e );
            } catch (InterruptedException e1) {
                System.out.println(e1);
                e1.printStackTrace();
            }
        }

    }
}
