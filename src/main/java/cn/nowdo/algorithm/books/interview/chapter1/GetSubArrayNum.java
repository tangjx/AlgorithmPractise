package cn.nowdo.algorithm.books.interview.chapter1;

import java.util.LinkedList;
import java.util.List;

/**
 * @Description
 * @Date 2020/9/27 17:05
 */
public class GetSubArrayNum {
    public static int getNum(int[] arr, int num) {
        if(arr == null || arr.length == 0 || num < 0) {
            return 0;
        }
        int i = 0;
        int j = 0;
        int res = 0;
        LinkedList<Integer> qmin = new LinkedList<>();
        LinkedList<Integer> qmax = new LinkedList<>();
        while (i < arr.length) {
            while (j < arr.length) {
                if(qmin.isEmpty() || qmin.peekLast() != j) {
                    while (!qmin.isEmpty() && arr[qmin.peekLast()] >= arr[j]) {
                        qmin.pollLast();
                    }
                    qmin.addLast(j);
                    while (!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[j]) {
                        qmax.pollLast();
                    }
                    qmax.addLast(j);
                }
                if (arr[qmax.getFirst()] - arr[qmin.getFirst()] > num) {
                    break;
                }
                j ++;
            }
            res += j - i;
            if (qmin.peekFirst() == i) {
                qmin.pollFirst();
            }
            if (qmax.peekFirst() == i) {
                qmax.pollFirst();
            }
            i ++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {1,2,3,4,5,6,7,8,9};
        int num = 1;
        System.out.println("get num result: " + getNum(arr, num));
    }
}
