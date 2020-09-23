package cn.nowdo.algorithm.books.interview.chapter1;

import java.util.Stack;

/**
 * @Description
 * 【题目】一个栈依次压入1、2、3、4、5，那么从栈顶到栈底分别为5、4、3、2、1。
 * 将这个栈转置后，从栈顶到栈底为 1、2、3、4、5，
 * 也就是实现栈中元素的逆序，但是只能用递归函数来实现，不能用其他数据结构。
 * @Date 2020/9/23 15:35
 */
public class StackReverse {

    public static void reserve(Stack stack) {
        Object last = null;
        if(!stack.isEmpty()) {
            last = getAndRemoveLastElement(stack);
            reserve(stack);
            stack.push(last);
        }
    }

    public static Object getAndRemoveLastElement(Stack stack) {
        Object result = stack.pop();
        if(stack.isEmpty()) {
            return result;
        } else {
            Object last = getAndRemoveLastElement(stack);
            stack.push(result);
            return last;
        }
    }

    public static void main(String[] args) {
        Stack stack = new Stack();
        for(int i = 0; i < 1000; i++) {
            stack.push(i);
        }
        reserve(stack);
        while (!stack.isEmpty()) {
            System.out.println("reserve stack :" + stack.pop());
        }
    }
}
