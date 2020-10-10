package cn.nowdo.algorithm.books.interview.chapter4;

/**
 * @Description
 * @Date 2020/10/9 21:47
 **/
public class Fibonacci {
    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();
        System.out.println("fibonacci: 6:" + fibonacci.f1(6));
        System.out.println("fibonacci: 6:" + fibonacci.f2(6));
        System.out.println("fibonacci: 6:" + fibonacci.f3(6));
    }
    public int f1(int n) {
        int res = 0;
        if (n <= 0) {
            return 0;
        }
        if(n == 1 || n ==2) {
            return 1;
        }
        res = f1(n -1) + f1(n -2);
        return res;
    }

    public int f2(int n) {
        int res = 0;
        int fn_1 = 1;
        int fn_2 = 1;
        if(n <= 0) {
            return 0;
        }
        if(n == 1 || n == 2) {
            return 1;
        }
        for (int i = 3; i <= n; i ++) {
            res = fn_1 + fn_2;
            fn_2 = fn_1;
            fn_1 = res;
        }
        return res;
    }
    public int[][] matrixPower(int[][] m, int p) {
        int[][] res = new int[m.length][m[0].length];
        // 先把矩阵设为单位矩阵，相当于整数中的1
        for (int i = 0; i < res.length; i ++) {
            res[i][i] = 1;
        }
        int[][] tmp = m;
        for (; p != 0; p >>= 1) {
            if((p & 1) != 0) {
                res = muliMatrix(res, tmp);
            }
            tmp = muliMatrix(tmp, tmp);
        }
        return  res;
    }

    public int[][] muliMatrix(int[][] m1, int[][] m2) {
        int[][] res = new int[m1.length][m2[0].length];
        for(int i = 0; i < m1.length; i ++) {
            for (int j = 0; j < m2[0].length; j ++) {
                for (int k = 0; k < m2.length; k ++) {
                    res[i][j] = m1[i][k] * m2[k][j];
                }
            }
        }
        return res;
    }


    public int f3(int n) {
        if (n < 1) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        int[][] base = {{1,1}, {1,0}};
        int[][] res = matrixPower(base, n -2);
        return res[0][0] + res[1][0];
    }
}
