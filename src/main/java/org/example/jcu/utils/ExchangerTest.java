package org.example.jcu.utils;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description
 * 线程间交换数据
 * 典型的应用场景是银行数据录入，为了防止录入出错，分为A和B两个人分别录入，然后比较两个录入的数据是否一致
 * @Date 2021/1/31 20:47
 **/
public class ExchangerTest {
    private static final Exchanger<String> exgx = new Exchanger<>();
    private static ExecutorService threadPool = Executors.newFixedThreadPool(2);

    public static void main(String[] args) {
        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                try {

                    String A = "银行流水A";
                    exgx.exchange(A);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        threadPool.execute(new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    String B = "银行流水B";
                    String A = exgx.exchange("B");
                    System.out.println("A和B录入数据是否一致：" + A.equals(B) + ", A录入的数据是：" + A + "，B录入的数据是：" + B);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }));

        threadPool.shutdown();
    }
}
