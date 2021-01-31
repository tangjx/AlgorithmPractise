package org.example.jcu.utils;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @Description
 * 门闩同步器
 * 等待多线程或多步骤完成的同步器
 * 典型场景：解析具有多个sheet的excel文件，主线程需要等待每个解析sheet的子线程都执行完毕，才能返回excel解析完毕
 * 如果某个线程
 * @Date 2021/1/31 20:26
 **/
public class CountDownLatchTest {
    static CountDownLatch c = new CountDownLatch(2);

    public static void main(String[] args) throws InterruptedException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(1);
                c.countDown();
                System.out.println(2);
                c.countDown();
            }
        }).start();
        c.await();
        //阻塞一段时间后，就不再阻塞当前线程
//        c.await(1000, TimeUnit.SECONDS);
        System.out.println(3);
    }

}
