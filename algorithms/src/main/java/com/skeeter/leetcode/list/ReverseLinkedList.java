package com.skeeter.leetcode.list;

/**
 * 链表反转
 *
 * @author zewenwang created on 2018/1/27.
 */
public class ReverseLinkedList {

    public LinkedListNode reverseLinkedList(LinkedListNode list) {
        LinkedListNode p = null;
        LinkedListNode q = list;

        LinkedListNode temp;
        while (q != null) {
            temp = q.next;
            q.next = p;
            p = q;
            q = temp;
        }
        return p;
    }

    public static void main(String[] args) {
        LinkedListNode list = new LinkedListNode(0);
        LinkedListNode p = list;
        for (int i = 1; i <= 10; i++) {
            p.next = new LinkedListNode(i);
            p = p.next;
        }

        System.out.print("old list: ");
        list.print();

        LinkedListNode reverseList = new ReverseLinkedList().reverseLinkedList(list);
        System.out.print("reverse list: ");
        reverseList.print();
    }
}
