package cn.nowdo.algorithm.books.interview.chapter2;

/**
 * @Description
 * @Date 2020/10/4 18:58
 **/
public class ReversePart {
    public Node reversePart(Node head, int from, int to) {
        // #step 1 判断是否满足1≤from≤to≤N，如果不满足，则直接返回原来的头节点。
        int n = 0;
        Node index = head;
        Node fPre = null;
        Node tPos = null;
        //遍历，获取单链表长度
        while (index != null) {
            n ++;
            index = index.next;
            fPre = n == from -1 ? index : fPre;
            tPos = n == to + 1 ? index : tPos;
        }
        if(!(1 <= from && from <= to && to <= n))
            return head;
        Node node1 = fPre == null? head: fPre.next;
        Node node2 = node1.next;
        Node next = null;
        node1.next = tPos;
        while (node2 != tPos) {
            next = node2.next;
            node2.next = node1;
            node1 = node2;
            node2 = next;
        }
        if(fPre != null) {
            fPre.next = node1;
            return head;
        }
        return node1;
    }
}
