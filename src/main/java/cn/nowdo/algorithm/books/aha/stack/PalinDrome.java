package cn.nowdo.algorithm.books.aha.stack;

import java.util.Scanner;

public class PalinDrome {
    public  static void main(String[] args) {
        while (true) {
            System.out.println("please input arrays");
            Scanner scanner = new Scanner(System.in);
            String str = scanner.nextLine();
            char[] arrays = str.toCharArray();
            if(isPalinDrome(arrays)) {
                System.out.println( str +" is PalinDrome string");
            } else {
                System.out.println( str +" is not PalinDrome string");
            }
        }
    }

    public static boolean isPalinDrome(char[] array) {
        boolean result = false;
        int mod = array.length / 2;
        //数组作为栈
        char[] stack = new char[1000];
        //设置栈开始位置为1
        int top = 0;
        for (int i = 0; i < mod; i ++) {
            stack[top] = array[i];
            top ++;
        }
        int start;
        if(array.length % 2 == 0) {
            start = mod;
        } else {
            start = mod + 1;
        }
        for( int i = start; i < array.length; i ++) {
            if(array[i] != stack[--top]) {
                return result;
            }
            result = true;
        }
        return result;
    }
}
