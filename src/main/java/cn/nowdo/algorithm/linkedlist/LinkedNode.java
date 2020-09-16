package cn.nowdo.algorithm.linkedlist;

/**
 * @Description
 * @Date 2020/9/16 11:20
 */
public class LinkedNode<T> {
    private T data;
    private LinkedNode next;

    public LinkedNode() {

    }

    public LinkedNode(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public LinkedNode getNext() {
        return next;
    }

    public void setNext(LinkedNode next) {
        this.next = next;
    }
}
