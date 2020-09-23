package cn.nowdo.algorithm.books.aha.sort.quick;

import java.util.Scanner;

public class QuickSortDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //数组长度
        System.out.println("input array length ...");
        int length = scanner.nextInt();
        //创建数组及初始化
        int[] array = new int[length];
        System.out.println("input arrays  ...");
        for (int i = 0; i < array.length; i ++) {
            array[i] = scanner.nextInt();
        }
        quickSort(array, 0, array.length -1);
        for(int i = 0; i < array.length; i ++) {
            System.out.printf("%d ", array[i]);
        }
    }

    public static void quickSort(int[] array, int left, int right) {
        if(left > right) {
            return;
        }
        //哨兵
        int guardL = left, guardR = right;
        int mark;
        //基准数
        mark = array[left];
        while ( guardL != guardR) {
            while (array[guardR] >= mark && guardR > guardL) {
                guardR --;
            }
            while (array[guardL] <= mark && guardL < guardR) {
                guardL ++;
            }
            //交换位置
            if(guardL < guardR) {
                int temp = array[guardL];
                array[guardL] = array[guardR];
                array[guardR] = temp;
            }
        }
        array[left] = array[guardL];
        array[guardL] = mark;
        quickSort(array, left, guardL - 1);
        quickSort(array, guardL + 1, right);
    }
}
