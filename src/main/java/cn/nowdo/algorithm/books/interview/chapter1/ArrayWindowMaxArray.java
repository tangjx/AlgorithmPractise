package cn.nowdo.algorithm.books.interview.chapter1;

/**
 * @Description
 * @Date 2020/9/24 17:59
 */
public class ArrayWindowMaxArray {
    public static Integer[] getArrayWindowMaxArray(Integer[] array, int window) {
        Integer[] windowMaxArray = new Integer[array.length - window + 1];
        for(int i = 0; i < windowMaxArray.length; i ++) {
            Integer max = 0;
            for(int j = i; j < i + 3; j ++) {//遍历窗口数组
                if(max < array[j]) {
                    max = array[j];
                }
            }
            //每个窗口数组的最大值
            windowMaxArray[i] = max;
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
