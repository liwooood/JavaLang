package test.threadpool;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by chenhf on 14-2-20.
 */
public class Client {
    private BlockingQueue<String> queue = new LinkedBlockingQueue<String>();
    private ExecutorService threadPool = Executors.newFixedThreadPool(3);


    public void start()
    {
        Producer producer = new Producer(queue);
        producer.start();

        for (int i=0; i<6; i++)
        {
            Consumer consumer = new Consumer(i, queue);

            threadPool.execute(consumer);
        }



    }

    public void stop()
    { threadPool.shutdown();
        System.out.println("client stop...");

    }


    public static void main(String[] args) {
        Client client = new Client();

       Runtime.getRuntime().addShutdownHook(new ExitThread(client));


        client.start();
    }
}
