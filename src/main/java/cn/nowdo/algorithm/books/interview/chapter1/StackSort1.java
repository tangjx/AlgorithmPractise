package cn.nowdo.algorithm.books.interview.chapter1;

import java.util.Stack;

public class StackSort1 {
    public static void main(String[] args) {
        Integer[] data = new Integer[] {3,4,5,2,2};
        Stack<Integer> dataStack = new Stack();
        Stack<Integer> sortedStack = new Stack();
        for(int i = 0; i < data.length; i ++) {
            dataStack.push(data[i]);
        }
        while (!dataStack.empty()) {
            Integer top = dataStack.pop();
            while (!sortedStack.isEmpty() && top > sortedStack.peek()) {
                dataStack.push(sortedStack.pop());
            }
            sortedStack.push(top);
        }

        while (!sortedStack.isEmpty()) {
            System.out.println(sortedStack.pop());
        }

    }
}
