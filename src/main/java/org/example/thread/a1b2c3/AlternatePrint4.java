package org.example.thread.a1b2c3;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

/**
 * @Description
 * @Date 2021/1/31 19:21
 **/
public class AlternatePrint4 {
    private Thread t1, t2;
    private final SynchronousQueue<Character> numsBlockingQueue = new SynchronousQueue<>();
    private final SynchronousQueue<Character> alphabertBlockingQueue = new SynchronousQueue<>();
    private final char[] aI = "1234567".toCharArray();
    private final char[] aC = "abcdefg".toCharArray();

    public static void main(String[] args) throws Exception{
        AlternatePrint4 alternatePrint3 = new AlternatePrint4();
        alternatePrint3.alternatePrint();
    }

    public void alternatePrint() throws Exception{
        t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < aI.length; i ++) {
                    try {
                        System.out.println(alphabertBlockingQueue.take());
                        numsBlockingQueue.put(aI[i]);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0 ; i < aC.length; i ++) {
                    try {
                        alphabertBlockingQueue.put(aC[i]);
                        System.out.println(numsBlockingQueue.take());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        t1.start();
        t2.start();

        System.in.read();
    }
}
