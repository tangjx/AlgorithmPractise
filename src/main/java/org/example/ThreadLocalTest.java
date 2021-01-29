package org.example;

import java.util.concurrent.*;

/**
 * @author atang
 * @Description
 * @Date 2021/1/28 10:54
 */
public class ThreadLocalTest {
    private ExecutorService executorService = Executors.newFixedThreadPool(10);


    private ExecutorService threadPool = new ThreadPoolExecutor(10, 10, 0,
            TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>(1024));
}
