package org.example;

/**
 * @Description
 * @Date 2021/1/13 11:26
 */
public class SynchronizedDemo {
    public static void main(String[] args) {
        SynchronizedDemo d = new SynchronizedDemo();
//        synchronized(d) {
//            int i = SynchronizedDemo.exec(1, 2);
//            System.out.println(i);
//        }
        Tn tn1 = new Tn();
        Tn tn2 = new Tn();
        tn2.run();
        tn1.run();
    }



    public static synchronized int exec(int a, int b) {
        return a + b;
    }

    static int a = 1;

    static class Tn extends Thread {
        @Override
        public void run() {
            a = a + 1;
            System.out.println(a);
        }
    }
}
