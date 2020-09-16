package cn.nowdo.algorithm.linkedlist;

/**
 * @Description
 * @Date 2020/9/16 12:56
 */
public class LinkedList<T> {
    public static void main(String[] args) {
        LinkedNode<Integer> head = new LinkedNode<>(1);
        LinkedNode<Integer> header = head;
        for(int i = 2; i < 10; i ++) {
            LinkedNode<Integer> node = new LinkedNode<>(i);
            header.setNext(node);
            header = node;
        }
        header = head;
        System.out.println("插入前");
        while(header.getNext() != null) {

            System.out.println(header.getData());
            header = header.getNext();
        }
        header = head;
        while(header.getNext() != null) {
            if(header.getData()<= 5) {
                LinkedNode<Integer> node = new LinkedNode<>(5);
                LinkedNode temp = header.getNext();
                header.setNext(node);
                node.setNext(temp);
            }
            System.out.println(header.getData());
            header = header.getNext();
        }
        System.out.println("插入后");
        header = head;
        while(header.getNext() != null) {

            System.out.println(header.getData());
            header = header.getNext();
        }

    }
}
