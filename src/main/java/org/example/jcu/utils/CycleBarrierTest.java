package org.example.jcu.utils;

import java.util.concurrent.CyclicBarrier;

/**
 * @Description
 * 同步屏障
 * 典型应用场景是多线程计算数据，然后合并数据
 * @Date 2021/1/31 20:58
 **/
public class CycleBarrierTest {

    static CyclicBarrier c = new CyclicBarrier(2, new A());

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    c.await();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println(1);
            }
        }).start();

        try {
            c.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(2);
    }

    static class A implements Runnable {
        @Override
        public void run() {
            System.out.println(3);
        }
    }
}
