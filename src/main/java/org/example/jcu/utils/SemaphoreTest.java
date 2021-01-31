package org.example.jcu.utils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @Description
 * 控制并发线程数
 * @Date 2021/1/31 20:54
 **/
public class SemaphoreTest {
    private static ExecutorService threadPool = Executors.newFixedThreadPool(30);
    private static Semaphore s = new Semaphore(10);

    public static void main(String[] args) {
        for(int i = 0; i < 30; i ++) {
            threadPool.execute(new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        s.acquire();
                        System.out.println("save data");
                        Thread.sleep(10 * 100);
                        s.release();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }));
        }
    }
}
