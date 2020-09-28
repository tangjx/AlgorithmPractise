package cn.nowdo.algorithm.books.interview.chapter2;

/**
 * @Description
 * @Date 2020/9/28 15:04
 */
public class CommonPart {
    public static class Node {
        public int value;
        public Node next;
        public Node(int value) {
            this.value = value;
        }
    }

    public void printCommonPart(Node head1, Node head2) {
        System.out.println("common part: ");
        if (head1 != null && head2 != null) {
            if(head1.value > head2.value) {
                    head2 = head2.next;
            } else if (head1.value < head2.value) {
                    head1 = head1.next;
            } else {
                System.out.println(head1.value);
                head1 = head1.next;
                head2 = head2.next;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{1,3,4,5,6,7,8,9};
        int[] arr2 = new int[]{1,2,3,4,5,6};
        Node head1 = new Node(arr1[0]);
        Node index1 = head1;
        for (int i = 1; i < arr1.length; i ++) {
            Node newNode = new Node(arr1[i]);
            index1.next = newNode;
            index1 = newNode;
        }
        Node head2 = new Node(arr1[0]);
        Node index2 = head2;
        for (int i = 1; i < arr2.length; i ++) {
            Node newNode = new Node(arr2[i]);
            index2.next = newNode;
            index2 = newNode;
        }
        CommonPart commonPart = new CommonPart();
        commonPart.printCommonPart(head1, head2);
    }
}
