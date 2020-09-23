package cn.nowdo.algorithm.books.interview.chapter1;

import java.util.Stack;

/**
 * @Description
 * 【题目】实现一个特殊的栈，在实现栈的基本功能的基础上，再实现返回栈中最小元素的操作。
 * 【要求】1.pop、push、getMin操作的时间复杂度都是O（1）。2.设计的栈类型可以使用现成的栈结构。
 * @Date 2020/9/23 11:39
 */
public class GetMinStack {
    private Stack<Integer> dataStack;
    private Stack<Integer> minStack;

    public GetMinStack() {
        dataStack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(Integer newNum) {
        dataStack.push(newNum);
        if(minStack.empty()) {
            minStack.push(newNum);
        } else if(newNum <= minStack.peek()) {
            minStack.push(newNum);
        }
    }

    public Integer pop() {
        if(dataStack.isEmpty()) {
            throw new RuntimeException("data stack is empty");
        }
        Integer num = dataStack.pop();
        if(num > minStack.peek()) {
            return num;
        } else {
            return minStack.pop();
        }
    }

    public Integer getMin() {
        if(minStack.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return minStack.peek();
    }

    public static void main(String[] args) {
        GetMinStack stack = new GetMinStack();
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
