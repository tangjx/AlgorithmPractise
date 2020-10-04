package cn.nowdo.algorithm.books.interview.chapter1;


import java.util.LinkedList;

/**
 * @Description
 * @Date 2020/9/24 17:59
 */
public class ArrayWindowMaxArray1 {
    public static Integer[] getArrayWindowMaxArray(Integer[] array, int window) {
        Integer[] windowMaxArray = new Integer[array.length - window + 1];
        LinkedList<Integer> qmax = new LinkedList<>();
        int index = 0;
        for(int i  = 0; i < array.length; i ++) {
            while (!qmax.isEmpty() && array[i] >= array[qmax.peekLast()]) {
                qmax.pollLast();
            }
            qmax.addLast(i);
            if(qmax.peekFirst() == i - window) {
                qmax.pollFirst();
            }
            if(i >= window - 1) {
                windowMaxArray[index ++] = array[qmax.peekFirst()];
            }
        }
        return windowMaxArray;
    }
    public static void main(String[] args) {
        Integer[] array = new Integer[] {4,3,5,4,3,3,6,7};
        int window = 3;
        Integer[] windowMaxArray = getArrayWindowMaxArray(array, window);
        for(int i = 0; i < array.length - window +1; i ++) {
            System.out.println(windowMaxArray[i]);
        }
    }
}
