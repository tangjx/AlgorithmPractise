package org.example.thread.a1b2c3;

import java.sql.SQLOutput;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @Description
 * @Date 2021/1/31 19:21
 **/
public class AlternatePrint3 {
    private Thread t1, t2;
    private final BlockingQueue<Character> numsBlockingQueue = new ArrayBlockingQueue<>(1);
    private final BlockingQueue<Character> alphabertBlockingQueue = new ArrayBlockingQueue<>(1);
    private final char[] aI = "1234567".toCharArray();
    private final char[] aC = "abcdefg".toCharArray();

    public static void main(String[] args) throws Exception{
        AlternatePrint3 alternatePrint3 = new AlternatePrint3();
        alternatePrint3.alternatePrint();
    }

    public void alternatePrint() throws Exception{
//        alphabertBlockingQueue.add(aC[0]);
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
