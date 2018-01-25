package com.michael.algorithms.others;

/**
 * Created by michael on 15/5/30.
 * <p/>
 * Reverse a singly linked list.
 * A linked list can be reversed either iteratively or recursively. Could you implement both?
 */
public class ReverseLinkedList {
    /**
     * Definition for singly-linked list.
     */
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public class Solution {
        public ListNode reverseList(ListNode head) {
            if (head == null) {
                return head;
            }

            ListNode pre = null;
            while (head.next != null) {
                ListNode now=head;
                head = head.next;
                now.next = pre;
                pre = now;
            }
            head.next=pre;

            return head;
        }
    }

    public static void main(String[] args) {
        ReverseLinkedList.Solution solution = new ReverseLinkedList().new Solution();

        ReverseLinkedList.ListNode head = new ReverseLinkedList().new ListNode(1);
        ReverseLinkedList.ListNode temp = head;
        temp.next = new ReverseLinkedList().new ListNode(2);
        temp=temp.next;
        temp.next = new ReverseLinkedList().new ListNode(3);
        temp=temp.next;
        temp.next = new ReverseLinkedList().new ListNode(4);
        temp=temp.next;
        temp.next = new ReverseLinkedList().new ListNode(5);

        head = solution.reverseList(head);
        System.out.println(head.toString());
    }
}
