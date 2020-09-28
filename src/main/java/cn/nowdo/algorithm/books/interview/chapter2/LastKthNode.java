package cn.nowdo.algorithm.books.interview.chapter2;

/**
 * @Description
 * @Date 2020/9/28 16:12
 */
public class LastKthNode {
    public static class Node {
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public static class DoubleNode {
        public int value;
        public DoubleNode next;
        public DoubleNode last;

        public DoubleNode(int value) {
            this.value = value;
        }
    }

    public Node removeLastKthNode(Node head, int k) {
        if(k < 1 || head == null) {
            return head;
        }
        Node index = head;
        int size = 1;
        while (index.next != null) {
            index = index.next;
            size ++;
        }
        if (size < k) {
            return head;
        } else if (size == k) {
            head = head.next;
            return head;
        } else {
            index = head;
            int i = size - k;
            while (i != 1) {
                i --;
                index = index.next;
            }
            index.next = index.next.next;
        }
        return head;
    }

    public DoubleNode removeLastKthNode(DoubleNode head, int k) {
        if(k < 1 || head == null) {
            return head;
        }
        DoubleNode index = head;
        int size = 1;
        while (index.next != null) {
            index = index.next;
            size ++;
        }
        if (size < k) {
            return head;
        } else if (size == k) {
            head = head.next;
            head.last = null;
            return head;
        } else {
            index = head;
            int i = size - k;
            while (i != 1) {
                i --;
                index = index.next;
            }
            //删除节点
            index.next = index.next.next;
            index.next.next.last = index;
        }
        return head;
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{1,3,4,5,6,7,8,9};
        Node head1 = new Node(arr1[0]);
        Node index1 = head1;
        for (int i = 1; i < arr1.length; i ++) {
            Node newNode = new Node(arr1[i]);
            index1.next = newNode;
            index1 = newNode;
        }
        LastKthNode lastKthNode = new LastKthNode();
        head1 = lastKthNode.removeLastKthNode(head1, 6);
        index1 = head1;
        while (index1 != null) {
            System.out.println(index1.value);
            index1 = index1.next;
        }

        int[] arr2 = new int[]{1,2,3,4,5,6,7,8,9};
        DoubleNode head2 = new DoubleNode(arr2[0]);
        DoubleNode index2 = head2;
        for (int i = 1; i < arr2.length; i ++) {
            DoubleNode newNode = new DoubleNode(arr2[i]);
            index2.next = newNode;
            newNode.last = index2;
            index2 = newNode;
        }
        head2 = lastKthNode.removeLastKthNode(head2, 6);
        index2 = head2;
        while (index2 != null) {
            System.out.println(index2.value);
            index2 = index2.next;
        }
    }
}
