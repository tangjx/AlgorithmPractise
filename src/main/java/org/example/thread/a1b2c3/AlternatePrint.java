package org.example.thread.a1b2c3;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;

/**
 * @Description
 * @Date 2021/1/31 18:53
 **/
public class AlternatePrint {
    static Thread t1 = null, t2 = null;

    public static void main(String[] args) {
        final char[] aI = "1234567".toCharArray();
        final char[] aC = "ABCDEFG".toCharArray();
        t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0 ; i < aC.length; i ++) {
                    //先打印一个字母
                    System.out.println(aC[i]);
                    //打印完，唤醒t2打印数字
                    LockSupport.unpark(t2);
                    //自己阻塞，准备唤醒
                    LockSupport.park();
                }
            }
        });
        t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < aI.length; i ++) {
                    //开始先阻塞等待
                    LockSupport.park();
                    //被唤醒后打印数字
                    System.out.println(aI[i]);
                    //唤醒t1,打印字母
                    LockSupport.unpark(t1);
                }
            }
        });
        t1.start();
        t2.start();
    }
}
