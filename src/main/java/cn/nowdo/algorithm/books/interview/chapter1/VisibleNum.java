package cn.nowdo.algorithm.books.interview.chapter1;

import java.util.Stack;

/**
 * @Description
 * @Date 2020/9/28 10:24
 */
public class VisibleNum {
    public int getVisibleNum(int[] arr) {
        int res = 0;
        if (arr == null || arr.length == 0) {
            return res;
        }
        int maxIndex = 0;
        for (int i = 0; i < arr.length; i ++) {
            if (arr[i] > arr[maxIndex]) {
                maxIndex = i;
            }
        }
        Stack<Record> stack = new Stack<>();
        stack.push(new Record(arr[maxIndex]));
        int index = getNextIndex(maxIndex, arr.length);
        while (index != maxIndex) {
            // 当前值大于栈顶值，会破坏栈的单调性（栈顶到栈底递增），弹出当前栈顶元素
            if (stack.peek().value < arr[index]) {
                Record top = stack.pop();
                if (!stack.empty()) { //栈顶元素弹出后，栈不为空，弹出后的栈顶元素是比弹出的栈顶元素的大的值
                    if (top.times == 1) {//弹出的元素到当前值和到当前栈定值都符合“小找大”的原则，所以得到两个小到大组合
                        res += 2;
                    } else { //弹出的元素，值出现的次数多余一个，每个值到当前值和当前栈顶值分别会有两对小到大组合，再加上多个相同值之间的组合C（2，times）
                        res += 2 * top.times + top.times * ( top.times - 1) / 2;
                    }
                } else { // 栈为空，相当于清算的3阶段
                    if (top.times == 1) {
                        res += 1;
                    } else {
                        res += 2;
                    }
                }
            } else if (stack.peek().value == arr[index]) { // 当前值等于栈顶元素，则合并到栈顶元素中
                stack.peek().times += 1;
            } else { //当前值小于栈顶元素，则压入栈
                stack.push(new Record(arr[index]));
            }
            index = getNextIndex(index, arr.length);
        }
        //清算阶段
        while (!stack.isEmpty()) {
            //清算阶段的1阶段，栈中除了栈顶值，还有最大值和次大值
            if(stack.size() >= 3) {
                Record top = stack.pop();
                res += 2 * top.times + top.times * (top.times -1) / 2;
            }
            //清算阶段的2阶段，栈中除了栈顶值，只有最大值
            if (stack.size() == 2) {
                Record top = stack.pop();
                if (stack.peek().times == 1) {
                    res += 1 * top.times + top.times * (top.times - 1) / 2;
                } else {
                    res += 2 * top.times  + top.times * (top.times - 1) / 2;
                }
            }
            //栈中只剩最大值
            if (stack.size() == 1) {
                Record top = stack.pop();
                if (top.times > 1) {
                    res += top.times * (top.times - 1) / 2;
                }
            }
        }
        return res;
    }

    public int getNextIndex(int index, int size) {
        return index < size - 1? index + 1 : 0;
    }

    public static class Record {
        private int value;
        private int times;

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Record(int value) {
            this.value = value;
            this.times = 1;
        }

        public int getTimes() {
            return times;
        }

        public void setTimes(int times) {
            this.times = times;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3,2,5,4,3,5,4,2,4,4,5};
        VisibleNum visibleNum = new VisibleNum();
        System.out.println("visibleNum: " + visibleNum.getVisibleNum(arr));
    }
}
