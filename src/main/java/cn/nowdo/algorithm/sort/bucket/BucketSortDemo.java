package cn.nowdo.algorithm.sort.bucket;

import java.util.Scanner;

public class BucketSortDemo {
    /**
     * 简化版的桶排序
     * 试题描述: 期末考试完了老师要将同学们的分数按照从高到低排序，班上只有5个同学，这5个同学分别考了5分，3分，5分，2分和8分，要求将分数按从大到小排序
     *
     */
    public static void main(String[] args) {
        //标记数组
        int[] books = new int[11];
        for (int i = 0; i < 11; i ++) {
            //每个标记出现的次数初始化为0
            books[i] = 0;
        }
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        for (int j = 0; j < count; j ++) {
            int score = scanner.nextInt();
            books[score] ++;
        }
        System.out.println("排序结果: ");
        for (int i = 10; i >= 0; i --) {
            for(int j = 1; j <= books[i]; j ++) {
                System.out.printf("%d ", i);
            }
        }
    }
}
