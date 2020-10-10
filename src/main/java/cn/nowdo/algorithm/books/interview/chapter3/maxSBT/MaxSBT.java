package cn.nowdo.algorithm.books.interview.chapter3.maxSBT;

/**
 * @Description
 * @Date 2020/10/9 11:31
 */
public class MaxSBT {
    public ReturnType process(Node x) {
        // base case : 如果子树是空树
        //最小值是系统最大
        //最大值是系统最小
        if (x == null) {
            return new ReturnType(null, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }
        //默认得到全部左子树信息
        ReturnType lData = process(x.leftNode);
        //默认等到全部右子树信息
        ReturnType rData = process(x.rightNode);

        int min = Math.min(x.value, Math.min(lData.min, rData.min));
        int max = Math.max(x.value, Math.max(lData.max, rData.max));

        int maxBSTSize = Math.max(lData.maxBSTSize, rData.maxBSTSize);

        Node maxBSTHead = lData.maxBSTSize >= rData.maxBSTSize ? lData.maxBSTHead : rData.maxBSTHead;

        if(lData.maxBSTHead == x.leftNode && rData.maxBSTHead == x.rightNode
                && x.value > lData.max && x.value < rData.min) {
            maxBSTHead = x;
            maxBSTSize = lData.maxBSTSize + rData.maxBSTSize + 1;
        }
        return new ReturnType(maxBSTHead, maxBSTSize, min, max);
    }

    public Node getMaxBST(Node head) {
        return process(head).maxBSTHead;
    }
}
