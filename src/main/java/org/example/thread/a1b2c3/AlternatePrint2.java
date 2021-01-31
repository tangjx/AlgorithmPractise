package org.example.thread.a1b2c3;

import java.util.concurrent.locks.LockSupport;

/**
 * @Description
 * 多次执行，这种方式有死锁的情况
 * @Date 2021/1/31 18:53
 **/
public class AlternatePrint2 {
    static Thread t1 = null, t2 = null;

    public static void main(String[] args) {
        final Object lock = new Object();
        final char[] aI = "1234567".toCharArray();
        final char[] aC = "ABCDEFG".toCharArray();
        t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0 ; i < aC.length; i ++) {
                    //先打印一个字母
                    synchronized (lock) {
                        System.out.println(aC[i]);
                        lock.notify();
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });
        t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < aI.length; i ++) {
                    synchronized (lock) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(aI[i]);
                        lock.notify();
                    }
                }
            }
        });
        t2.start();
        t1.start();
    }
}
