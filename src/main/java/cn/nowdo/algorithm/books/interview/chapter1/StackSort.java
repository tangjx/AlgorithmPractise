package cn.nowdo.algorithm.books.interview.chapter1;

import java.util.Stack;

/**
 * @Description
 * 一个栈中元素的类型为整型，现在想将该栈从顶到底按从大到小的顺序排序，只许申请一个栈。
 * 除此之外，可以申请新的变量，但不能申请额外的数据结构。如何完成排序？
 * @Date 2020/9/24 17:40
 */
public class StackSort {
    public static void sortStackByStack(Stack<Integer> stack) {
        Stack<Integer> helpStack = new Stack();
        while (!stack.isEmpty()) {
            Integer cur = stack.pop();
            while (!helpStack.isEmpty() && cur > helpStack.peek()) {
                stack.push(helpStack.pop());
            }
            helpStack.push(cur);
        }

        while (!helpStack.isEmpty()) {
            stack.push(helpStack.pop());
        }
    }

    public static void main(String[] args) {
        Integer[] array = new Integer[] {1,3,5,4,3,2};
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < array.length; i ++) {
            stack.push(array[i]);
        }
        sortStackByStack(stack);
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}
