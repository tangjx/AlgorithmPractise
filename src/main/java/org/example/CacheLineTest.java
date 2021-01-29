package org.example;

/**
 * @Description
 * @Date 2021/1/29 16:59
 */
public class CacheLineTest {
    //考虑一般缓存行是64个字节，一个long类型占8个字节
    static long[][] arr;
    public static void main(String[] args) {
        arr = new long[1024 * 1024][];
        for(int i = 0; i < 1024*1024; i ++) {
            arr[i] = new long[8];
            for(int j =0; j < 8; j ++) {
                arr[i][j] = 0L;
            }
        }
        long sum = 0L;
        long marked = System.currentTimeMillis();
        for(int i = 0; i < 1024 * 1024; i ++) {
            for(int j = 0; j < 8; j ++) {
                sum += arr[i][j];
            }
        }
        System.out.println("Loop times: " + (System.currentTimeMillis() - marked) + "ms");
        marked = System.currentTimeMillis();
        for(int i = 0; i < 8; i ++) {
            for(int j = 0; j < 1024 * 1024; j ++) {
                sum += arr[j][i];
            }
        }
//        for(int i = 0; i < 1024 * 1024; i ++) {
//            for(int j = 0; j < 8; j ++) {
//                sum += arr[i][j];
//            }
//        }
        System.out.println("Loop times: " + (System.currentTimeMillis() - marked) + "ms");
    }
}
