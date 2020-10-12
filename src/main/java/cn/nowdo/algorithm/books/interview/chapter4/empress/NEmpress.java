package cn.nowdo.algorithm.books.interview.chapter4.empress;

/**
 * @Description
 * @Date 2020/10/12 10:34
 */
public class NEmpress {
    public int num1(int n) {
        //逐行放置皇后
        //  如果在(i, j)放置皇后，接下来在哪些位置不能放置呢
        //1、整个i行和j列都不能放置
        //2、加入新放置的节点是(k,m),如|k-i|=|m-j|，则说明(k, m)的位置跟（i, j）在同一条斜线上，也不能放置
        //设置record[n]保存已放置的皇后位置，record[i]的值表示第i行皇后所在的列数
        //递归计算，假设当前放置的位置为(i, j)，获取record[0-k]（k<i）的值，判断record[k]是否等于j，
        // 如果record[k]=j，则说明之前在j列放置了皇后，不能再放;
        // 如果|i-k| == |j-record[k]|,则说明在(i, j)斜线上放置过皇后，不能再放
        int[] record = new int[n];
        int sum = 1;
        if(n < 1) {
            return 0;
        }
        return process1(0, record, n);
    }

    public int process1(int i, int[] record, int n) {
        if(i == n) {
            return 1;
        }
        int res = 0;
        for(int j = 0; j < n; j++) {
            if(isValid(record, i, j)) {
                record[i] = j;
                res += process1(i + 1, record, n);
            }
        }
        return res;
    }

    public boolean isValid(int[] record, int i, int j) {
        for(int k = 0; k < i; k ++) {
            if(record[k] == j || Math.abs(record[k] - j) == Math.abs(k - i)) {
                return false;
            }
        }
        return true;
    }

    public int num2(int n) {
        if(n < 1 || n > 32) {
            return 0;
        }
        int upperLim = n == 32 ? -1 : (1 << n) -1;
        return process2(upperLim, 0, 0, 0);
    }
    public int process2(int upperLi, int colLim, int leftDiaLim ,int rightDiaLim) {
        if(colLim == upperLi) {
            return 1;
        }
        int pos = 0;
        int mostRightOne = 0;
        pos = upperLi & (~(colLim | leftDiaLim | rightDiaLim));
        int res = 0;
        while (pos != 0) {
            mostRightOne = pos & (~pos + 1);
            pos = pos - mostRightOne;
            res = process2(upperLi, colLim| mostRightOne,
                    (leftDiaLim | mostRightOne) << 1,
                    (rightDiaLim | mostRightOne) >> 1);
        }
        return res;
    }

}
