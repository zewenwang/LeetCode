package com.skeeter.leetcode.list;

/**
 * <a href="https://leetcode.com/problems/add-two-numbers/">Add Two Numbers</a>
 * <p/>
 * You are given two linked lists representing two non-negative numbers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 * <p/>
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 *
 * @author michael created on 16/2/23.
 */
public class AddTwoNumbers {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 右边是高位的情况
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode head = new ListNode(0);
        ListNode p = head;
        int tmp = 0;
        int sum = 0;

        while (l1 != null || l2 != null || tmp != 0) {
            sum = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + tmp;
            if (sum < 10) {
                tmp = 0;
            } else {
                tmp = sum / 10;
                sum = sum % 10;
            }

            p.next = new ListNode(sum);
            p = p.next;

            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }

        return head.next;
    }

    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode head = new ListNode(0);
        ListNode p = head;
        p.next = l1;
        int sum = 0;
        int tmp = 0;

        while (l1 != null && l2 != null) {
            sum = l1.val + l2.val + tmp;
            if (sum < 10) {
                tmp = 0;
            } else {
                tmp = sum / 10;
                sum = sum % 10;
            }

            p.next.val = sum;
            p = p.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        if (l1 == null) {
            p.next = l2;
        } else {
            p.next = l1;
        }

        while (tmp != 0 && p.next != null) {
            sum = p.next.val + tmp;
            if (sum < 10) {
                tmp = 0;
            } else {
                tmp = sum / 10;
                sum = sum % 10;
            }

            p.next.val = sum;
            p = p.next;
        }
        if (tmp != 0) {
            p.next = new ListNode(tmp);
        }

        return head.next;
    }

    /**
     * 左边是高位的情况
     * <p/>
     * todo fix to right
     */
    public ListNode addTwoNumbersRight(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        int size1 = size(l1);
        int size2 = size(l2);
        ListNode result = size1 > size2 ? l1 : l2;
        ListNode p = new ListNode(0);
        p.next = result;
        while (size1 != 0) {
            if (size1 != size2) {
                if (size1 > size2) {
                    size1--;
                    l1 = l1.next;
                } else {
                    size2--;
                    l2 = l2.next;
                }
            } else {
                int sum = l1.val + l2.val;
                if (sum < 10) {
                    p.next.val = sum;
                } else {
                    p.next.val = sum % 10;
                    p.val += sum / 10;
                    if (p.next == result) {
                        result = p;
                    }
                }

                l1 = l1.next;
                l2 = l2.next;
                size1--;
                size2--;
            }
            p = p.next;
        }


        return result;
    }

    public int size(ListNode node) {
        if (node == null) {
            return 0;
        }
        int size = 0;
        while (node != null) {
            size++;
            node = node.next;
        }
        return size;
    }

    public static void main(String[] args) {
        AddTwoNumbers example = new AddTwoNumbers();

        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(9);
        l2.next = new ListNode(9);

        ListNode result = example.addTwoNumbers(l1, l2);

        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

}
