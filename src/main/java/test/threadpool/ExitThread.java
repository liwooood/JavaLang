package test.threadpool;

/**
 * Created by chenhf on 14-2-24.
 */
public class ExitThread extends Thread{
private Client client;
    public ExitThread(Client client)
    {
        this.client = client;
    }

    @Override
    public void run() {
        client.stop();;
    }
}
