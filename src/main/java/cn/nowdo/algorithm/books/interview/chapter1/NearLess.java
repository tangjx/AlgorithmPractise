package cn.nowdo.algorithm.books.interview.chapter1;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Description
 * @Date 2020/9/27 11:11
 */
public class NearLess {
    public int[][] getNearLessNoRepeat(int[] arr) {
        int[][] res = new int[arr.length][2];
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < arr.length; i ++) {
            while (!stack.isEmpty() && arr[i] < arr[stack.peek()]) {
                //弹出栈顶
                int index = stack.pop();
                //找出栈顶位置代表的值的左边最小和右边最小值
                int leftLess;
                if(stack.isEmpty()) {
                    leftLess = -1;
                } else {
                    leftLess = stack.peek();
                }
                res[index] = new int[]{leftLess, i};
            }
            stack.push(i);
        }
        //清理剩余数据
        while (!stack.isEmpty()) {
            int index = stack.pop();
            int leftLess;
            if(stack.isEmpty()) {
                leftLess = -1;
            } else {
                leftLess = stack.peek();
            }
            res[index] = new int[] {leftLess, -1};
        }
        return res;
    }

    public int[][] getNearless(int[] arr) {
        int[][] res = new int[arr.length][2];
        Stack<List<Integer>> stack = new Stack<>();
        for(int i = 0; i < arr.length; i ++) {
            while (!stack.isEmpty() && arr[stack.peek().get(0)] > arr[i]) {
                List<Integer> indexList = stack.pop();
                for(int j = 0; j < indexList.size(); j ++) {
                    res[indexList.get(j)][0] = stack.isEmpty()? -1 : stack.peek().get(stack.peek().size() - 1);
                    res[indexList.get(j)][1] = i;
                }
            }
            List<Integer> indexList;
            if(stack.isEmpty() || !stack.isEmpty() && arr[stack.peek().get(0)] < arr[i]) {
                indexList = new ArrayList<>();
                stack.push(indexList);
            } else {
                indexList = stack.peek();
            }
            indexList.add(i);
        }
        while (!stack.isEmpty()) {
            List<Integer> indexList = stack.pop();
            for(int j = 0; j < indexList.size(); j ++) {
                res[indexList.get(j)][0] = stack.isEmpty()? -1:stack.peek().get(stack.peek().size() - 1);
                res[indexList.get(j)][1] = -1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {3, 4, 1, 5, 6, 2, 7};
        NearLess nearLess = new NearLess();
        int[][] res = nearLess.getNearLessNoRepeat(arr);
        for(int i = 0; i < res.length; i++) {
            System.out.println("res:{" + res[i][0] + ", " + res[i][1] + "}");
        }

        int[] arr2 = new int[] {3, 1, 3, 4, 3, 5, 3, 2, 2};
        int[][] res2 = nearLess.getNearless(arr2);
        for(int i = 0; i < res2.length; i++) {
            System.out.println("res2:{" + res2[i][0] + ", " + res2[i][1] + "}");
        }
    }
}
