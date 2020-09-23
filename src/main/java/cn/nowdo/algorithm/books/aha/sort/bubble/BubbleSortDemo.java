package cn.nowdo.algorithm.books.aha.sort.bubble;

import java.util.Scanner;

/**
 *
 */
public class BubbleSortDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //输入数据组长度
        System.out.println("input array length ...");
        int length = scanner.nextInt();
        //创建并初始化数据
        int[] array = new int[length];
        System.out.println("input arrays ...");
        for (int i = 0; i < array.length; i ++) {
            array[i] = scanner.nextInt();
        }
        for (int i = 0; i < array.length -1; i ++) {
            for (int j = 0; j < array.length -1 - i; j ++) {
                if(array[j] > array[j + 1]) {
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }
            }
        }
        System.out.println("sort complete:");
        for(int i = 0; i < array.length; i++) {
            System.out.printf("%d ", array[i]);
        }
    }
}
