package org.example;

import jdk.nashorn.internal.ir.GetSplitState;

import java.util.Stack;

/**
 * @Description
 * @Date 2020/10/23 14:22
 */
public class Product {
    /**
     * Definition for singly-linked list.

     */
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode second = new ListNode(1);
        head.next = second;
        ListNode thrid = new ListNode(2);
        second.next = thrid;
        ListNode forth = new ListNode(1);
        thrid.next= forth;
        Solution solution = new Solution();
        System.out.println(solution.isPalindrome(head));
    }
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    static class Solution {
        public boolean isPalindrome(ListNode head) {
            if(head == null || head.next == null ) {
                return true;
            }
            Stack<ListNode> stack = new Stack<>();
            int length = 0;
            ListNode index = head;
            // 遍历链表，统计链表总长度
            while(index != null) {
                length ++;
                index = index.next;
            }
            System.out.println(length);
            index = head;
            int mid = length / 2;
            for (int i = 1; i <= mid; i ++) {
                stack.push(index);
                index = index.next;
            }
            ListNode midHead = length % 2 == 0 ? index : index.next;
            System.out.println(midHead.val);
            while(midHead != null) {
                if(midHead.val != stack.peek().val) {
                    return false;
                }
                stack.pop();
                midHead = midHead.next;
            }
            return true;
        }
    }
}
