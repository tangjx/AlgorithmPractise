package cn.nowdo.algorithm.books.interview.chapter3.maxSBT;

/**
 * @Description
 * @Date 2020/10/9 11:28
 */
public class ReturnType {
    public Node maxBSTHead;
    public int maxBSTSize;
    public int min;
    public int max;

    public ReturnType(Node maxBSTHead, int maxBSTSize, int min, int max) {
        this.maxBSTHead = maxBSTHead;
        this.maxBSTSize = maxBSTSize;
        this.min = min;
        this.max = max;
    }
}
