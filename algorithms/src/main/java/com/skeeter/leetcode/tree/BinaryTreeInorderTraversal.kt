package com.skeeter.leetcode.tree

import com.skeeter.leetcode.runWithTime
import java.util.*

/**
 * 94. Binary Tree Inorder Traversal
 * https://leetcode.com/problems/binary-tree-inorder-traversal/description/
 *
 * Given a binary tree, return the inorder traversal of its nodes' values.
 * Note: Recursive solution is trivial, could you do it iteratively?
 *
 * @author zewenwang created on 02/01/2018.
 */

fun main(args: Array<String>) {
    val instance = BinaryTreeInorderTraversal()
    val root = TreeNode.creatBinaryTree()

    runWithTime { println(instance.inorderTraversal(root)) }
}

class BinaryTreeInorderTraversal {
    fun inorderTraversal(root: TreeNode?): List<Int> {
        return inorderTraversalTrivial(root)
    }

    /** 非递归实现 */
    fun inorderTraversalIteratively(root: TreeNode?): List<Int> {
        val list = LinkedList<Int>()
        if (root == null) {
            return list
        }

        val stack = Stack<TreeNode>()
        var node: TreeNode? = root
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node)
                node = node.left
            }

            node = stack.pop()
            list.add(node.`val`)

            node = node.right
        }

        return list
    }

    /** 递归实现 */
    fun inorderTraversalTrivial(root: TreeNode?): List<Int> {
        val list = LinkedList<Int>()
        inorderTraversalTrivial(root, list)
        return list
    }

    fun inorderTraversalTrivial(root: TreeNode?, list: MutableList<Int>) {
        if (root == null) {
            return
        }

        root.left?.run { inorderTraversalTrivial(root.left, list) }
        list.add(root.`val`)
        root.right?.run { inorderTraversalTrivial(root.right, list) }
    }
}
