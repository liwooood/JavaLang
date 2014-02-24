package test.threadpool;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by chenhf on 14-2-20.
 */
public class Producer extends Thread{
    private BlockingQueue<String> queue;

    public Producer(BlockingQueue<String> queue)
    {
        this.queue = queue;
    }

    @Override
    public void run() {
        int i=0;
        while(true)
        {
            try {
                queue.put( String.valueOf(i++) );
                sleep(500);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }
    }


}
