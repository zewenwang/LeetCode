package com.skeeter.leetcode.list

/**
 *
 * @author  zewenwang created on 2018/1/27.
 */
class AddTwoNumbersKt {

    class ListNode(var `val`: Int = 0) {
        var next: ListNode? = null
    }

    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        if (l1 == null) return l2
        if (l2 == null) return l1

        var addOne = false
        var p1: ListNode? = l1
        var p2: ListNode? = l2
        var pre: ListNode? = null

        while (p1 != null && p2 != null) {
            p1.`val` += p2.`val`
            if (addOne) {
                p1.`val`++
            }
            if (p1.`val` >= 10) {
                addOne = true
                p1.`val` -= 10
            } else {
                addOne = false
            }
            pre = p1
            p1 = p1.next
            p2 = p2.next
        }

        if (p2 != null) pre!!.next = p2

        while (addOne) {
            if (pre!!.next == null) {
                pre.next = ListNode(1)
                addOne = false
            } else {
                pre.next!!.`val` += 1
                if (pre.next!!.`val` >= 10) {
                    addOne = true
                    pre.next!!.`val` -= 10
                    pre = pre.next
                } else {
                    addOne = false
                }
            }
        }

        return l1
    }
}
