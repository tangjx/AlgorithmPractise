package cn.nowdo.algorithm.sort.app;

import java.util.Scanner;

public class ISBNBubbleSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("input array length ...");
        int length = scanner.nextInt();
        int[] array = new int[length];
        System.out.println("input arrays ...");
        for(int i = 0; i < array.length; i ++) {
            array[i] = scanner.nextInt();
        }
        int temp;
        for ( int i = 0; i < array.length; i ++) {
            for (int j = 0; j < array.length - 1 -i; j ++) {
                if(array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }

        System.out.println("ISBN ...");
        for (int i = 0; i < array.length; i ++) {
            if((i > 0 && array[i] != array[i -1]) || i == 0) {
                System.out.printf("%d ", array[i]);
            }
        }
    }
}
