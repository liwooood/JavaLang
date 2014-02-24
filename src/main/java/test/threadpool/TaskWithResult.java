package test.threadpool;

import java.util.concurrent.Callable;

/**
 * Created by chenhf on 14-2-24.
 */
public class TaskWithResult implements Callable<String> {
    @Override
    public String call() throws Exception {
        System.out.println();
        return "result";
    }
}
