package org.example;

/**
 * @Description
 * @Date 2020/10/23 17:53
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] array = new int[]{6,5,8,7,3,5,1,2,3,3};
        QuickSort quickSort = new QuickSort();
        quickSort.sort(array, 0, array.length - 1);
        for(int i = 0; i < array.length; i ++) {
            System.out.print(array[i] + "<");
        }
    }
    public void sort(int[] array, int low, int high) {
        if(low > high) {
            return;
        }
        int i,j,temp,t;
        i = low;
        j = high;
        temp = array[low];
        while(i < j) {
            //从右边开始找
            while (temp <= array[j] && i < j) {
                j --;
            }
            while (temp >= array[i] && i < j) {
                i ++;
            }
            //交换左右两边找到的值
            if(i < j) {
                t = array[i];
                array[i] = array[j];
                array[j] = t;
            }
        }
        //交换参照值和结束位置
        array[low] = array[i];
        array[i] = temp;
        //递归处理左半部分数组
        sort(array, low, i -1 );
        sort(array, i + 1, high);
    }

}
