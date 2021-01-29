package org.example;

/**
 * @Description
 * @Date 2020/12/22 17:02
 */
public class QuickSort2 {
    public static void main(String[] args) {
        int[] arr = new int[] {6,5,8,7,3,5,1,2,3,3};
//        QuickSort2 quickSort2 = new QuickSort2();
        sort(arr, 0, arr.length - 1);
        for(int i = 0; i < arr.length; i ++) {
            System.out.print(arr[i] + "<");
        }
    }
    public static void sort(int[] arr, int low, int height) {
        if(low > height) {
            return;
        }
        int i, j, temp, t;
        i = low;
        j = height;
        temp = arr[low];
        while(i < j) {
            //从右边开始找
            while(temp <= arr[j] && i < j) {
                j --;
            }
            //从左边开始找
            while(temp >= arr[i] && i < j) {
                i ++;
            }
            //交换左右两边找到的值
            if(i < j) {
                t = arr[i];
                arr[i] = arr[j];
                arr[j] = i;
            }
        }
        //交换参照值和结束位置
        arr[low] = arr[i];
        arr[i] = temp;
        //递归后半部分
        sort(arr, low, i - 1);
        sort(arr, i + 1, height);
    }
}
