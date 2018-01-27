package com.skeeter.leetcode.list;

/**
 * @author zewenwang created on 2018/1/27.
 */
public class LinkedListNode {
    public int value;
    public LinkedListNode next;

    public LinkedListNode(int value) {
        this.value = value;
    }

    public LinkedListNode(int value, LinkedListNode next) {
        this.value = value;
        this.next = next;
    }

    public void print() {
        LinkedListNode p = this;
        while (p != null) {
            System.out.print(p.value + " -> ");
            p = p.next;
        }
        System.out.println();
    }

}
