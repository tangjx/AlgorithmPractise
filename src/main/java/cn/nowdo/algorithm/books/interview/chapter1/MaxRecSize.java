package cn.nowdo.algorithm.books.interview.chapter1;

import java.util.Stack;

/**
 * @Description
 * @Date 2020/9/27 14:45
 */
public class MaxRecSize {
    public int maxRecSize(int[][] map) {
        if(map == null || map.length == 0 || map[0].length == 0) {
            return 0;
        }
        int maxArea = 0;
        int[] height = new int[map[0].length];
        for(int i = 0; i < map.length; i ++) {
            for(int j = 0; j < height.length; j ++) {
                height[j] = map[i][j] == 0? 0 : height[j] + 1;
            }
            maxArea = Math.max(maxRecFromBottom(height), maxArea);
        }
        return maxArea;
    }

    public int maxRecFromBottom(int[] height) {
        if(height == null || height.length == 0) {
            return 0;
        }
        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < height.length; i ++) {
            while (!stack.isEmpty() && height[i] < height[stack.peek()]) {
                int top = stack.pop();
                int j = stack.isEmpty()? -1 : stack.peek();
                int curArea = (i - j - 1) * height[top];
                maxArea = Math.max(curArea, maxArea);
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            int top = stack.pop();
            int j = stack.isEmpty()? -1 : stack.peek();
            int curArea = (height.length - j - 1) * height[top];
            maxArea = Math.max(curArea, maxArea);
        }
        return maxArea;
    }

    public static void main(String[] args) {
        MaxRecSize maxRecSize = new MaxRecSize();
        int[][] map = new int[][]{{1,0,1,1},{1,1,1,1},{1,1,1,0}};
        System.out.println("max sub rec size:" + maxRecSize.maxRecSize(map) );
    }
}
