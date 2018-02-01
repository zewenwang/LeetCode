package com.skeeter.leetcode.tree;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 104. Maximum Depth of Binary Tree
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/description/
 * <p>
 * Given a binary tree, find its maximum depth.
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 *
 * @author zewenwang created on 2018/1/30.
 */
public class MaximumDepthOfBinaryTree {


    public int maxDepth(TreeNode root) {
        return maxDepth2(root);
    }

    public int maxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    /**
     * 用到队列
     */
    public int maxDepth1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int depth = 0;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        queue.offer(null);
        TreeNode first;
        while (!queue.isEmpty()) {
            first = queue.poll();
            if (first == null) {
                depth++;
                if (!queue.isEmpty()) {
                    queue.offer(null);
                }
            } else {
                if (first.left != null) {
                    queue.offer(first.left);
                }
                if (first.right != null) {
                    queue.offer(first.right);
                }
            }
        }
        return depth;
    }


}
