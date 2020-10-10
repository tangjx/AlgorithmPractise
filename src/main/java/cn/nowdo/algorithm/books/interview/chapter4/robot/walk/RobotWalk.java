package cn.nowdo.algorithm.books.interview.chapter4.robot.walk;

/**
 * @Description
 * @Date 2020/10/10 15:04
 */
public class RobotWalk {
    public static void main(String[] args) {
        int N = 7, M = 4, K = 9, P = 5;
//        int N = 5, M = 2, K = 3, P = 3;
//        int N = 3, M = 1, K = 3, P = 3;
        RobotWalk walk = new RobotWalk();
        System.out.println(walk.ways1(N, M, K, P));
    }
    public int ways1(int N, int M, int K, int P) {
        //参数无效，直接返回0
        if(N < 2 || M > N || P > N || K < 1 || M < 1 || P < 1) {
            return 0;
        }
        return wark(N, M, K, P);
    }
    /*
        暴力递归解法
       N 位置为1-N，固定参数
       cur 机器人当前位置
       rest 剩余步数
       P   机器人最终到底的位置，固定参数
     */
    public int wark(int N, int cur, int rest, int P) {
        //没有剩余步数了，当前的cur就是最终的位置
        //如果最终的位置是P，则本次试验有效
        //如果最终的位置不是P，则本次试验无效
        if(rest == 0) {
            return cur == P ? 1:0;
        }
        if(cur == N) {
            wark(N, N -1, rest - 1, P);
        }
        if(cur == 1) {
            wark(N, 2, rest - 1, P);
        }
        return wark(N, cur + 1, rest - 1, P) + wark(N, cur - 1, rest - 1, P);
    }
}
