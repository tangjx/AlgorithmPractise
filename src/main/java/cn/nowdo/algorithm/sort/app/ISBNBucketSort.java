package cn.nowdo.algorithm.sort.app;

import java.util.Scanner;

public class ISBNBucketSort {
    public static void main(String[] args) {
        int[] books = new int[1001];
        int n, t, k = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("input n ... ");
        n = scanner.nextInt();
        System.out.println("input ISBN ... ");
        for (int i = 0; i < n; i ++) {
            t = scanner.nextInt();
            books[t] = 1;
        }

        for (int i = 0; i < books.length; i ++) {
            if (books[i] == 1) {
                k ++;
                System.out.printf("%d ", i);
            }
        }
    }
}
