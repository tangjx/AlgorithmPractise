package cn.nowdo.algorithm.books.interview.chapter1;

import java.util.Stack;

/**
 * @Description
 * @Date 2020/9/23 11:39
 */
public class GetMinStack2 {
    private Stack<Integer> dataStack;
    private Stack<Integer> minStack;

    public GetMinStack2() {
        dataStack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(Integer newNum) {
        dataStack.push(newNum);
        if(minStack.empty()) {
            minStack.push(newNum);
        } else if(newNum <= minStack.peek()) {
            minStack.push(newNum);
        } else if(newNum > minStack.peek()) {
            minStack.push(minStack.peek());
        }
    }

    public Integer pop() {
        if(dataStack.isEmpty()) {
            throw new RuntimeException("data stack is empty");
        }
        Integer num = dataStack.pop();
        minStack.pop();
        return num;
    }

    public Integer getMin() {
        if(minStack.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return minStack.peek();
    }

    public static void main(String[] args) {
        GetMinStack2 stack = new GetMinStack2();
        Integer[] array = new Integer[] {3,4,5,1,2,1};
        for(int i = 0; i < array.length; i++) {
            stack.push(array[i]);
        }
        for(int i = 0; i < array.length; i ++) {
            System.out.println("stack min :" + stack.getMin());
            System.out.println("stack pop :" + stack.pop());
        }
    }
}
