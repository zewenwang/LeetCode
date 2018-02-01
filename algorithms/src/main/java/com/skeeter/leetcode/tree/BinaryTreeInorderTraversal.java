package com.skeeter.leetcode.tree;

import java.util.LinkedList;
import java.util.List;

/**
 * @author zewenwang created on 02/01/2018.
 */
public class BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        return inorderTraversal1(root);
    }

    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        inorderTraversalTrivial(root, list);
        return list;
    }

    public void inorderTraversalTrivial(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }

        if (root.left != null) {
            inorderTraversalTrivial(root.left, list);
        }
        list.add(root.val);
        if (root.right != null) {
            inorderTraversalTrivial(root.right, list);
        }
    }
}
