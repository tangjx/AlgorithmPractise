package cn.nowdo.algorithm.books.interview.chapter1;

import java.util.Stack;

/**
 * @Description
 * 【题目】编写一个类，用两个栈实现队列，支持队列的基本操作（add、poll、peek）。
 * @Date 2020/9/23 12:51
 */
public class TwoStackQueue {
    private Stack pushStack;
    private Stack popStack;

    public TwoStackQueue() {
        pushStack = new Stack();
        popStack = new Stack();
    }

    private void pushToPop() {
        if(popStack.isEmpty()) {
            while (! pushStack.isEmpty()) {
                popStack.push(pushStack.pop());
            }
        }
    }

    public void add(Object object) {
        pushStack.push(object);
        pushToPop();
    }
    public Object pull() {
        if(pushStack.isEmpty() && popStack.isEmpty()) {
            throw new RuntimeException("queue is empty");
        }
        pushToPop();
        return popStack.pop();
    }
    public Object peek() {
        if(pushStack.isEmpty() && popStack.isEmpty()) {
            throw new RuntimeException("queue is empty");
        }
        pushToPop();
        return popStack.peek();
    }

    public static void main(String[] args) {
        TwoStackQueue queue = new TwoStackQueue();
        Integer[] array = new Integer[] {3,4,5,1,2,1};
        for(int i = 0; i < 3; i++) {
            queue.add(array[i]);
        }
        for(int i = 0; i < 2; i ++) {
            System.out.println("queue peek :"  + queue.peek());
            System.out.println("queue pull :" + queue.pull());
        }
        for(int i = 3; i < 6; i++) {
            queue.add(array[i]);
        }
        for(int i = 2; i < 6; i ++) {
            System.out.println("queue peek :"  + queue.peek());
            System.out.println("queue pull :" + queue.pull());
        }
    }
}
