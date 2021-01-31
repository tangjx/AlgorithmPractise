package org.example.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description
 * @Date 2021/1/31 18:07
 **/
public class FixedThreadPoolTest {
    public static void main(String[] args) {
        int processeNums = Runtime.getRuntime().availableProcessors();
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(processeNums * 5);
        for(int i = 0; i < 10; i ++) {
            fixedThreadPool.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName());
                }
            });
        }
//        fixedThreadPool.shutdown();
    }
}
