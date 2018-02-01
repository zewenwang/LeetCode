package com.skeeter.leetcode.tree;

/**
 * @author zewenwang created on 2018/1/30.
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int x) { val = x; }

    /**
     *  创建一棵树
     *                  1
     *               /     \
     *             2        3
     *           /   \
     *         4      6
     *          \     /
     *           5   7
     *
     * 1. 深度优先遍历
     * 前序：1, 2, 4, 5, 6, 7, 3
     * 中序：4, 5, 2, 7, 6, 1, 3
     * 后序：5, 4, 7, 6, 2, 3, 1
     *
     * 2. 广度优先遍历： 1, 2, 3, 4, 6, 5, 7
     *
     * */
    public static TreeNode creatBinaryTree() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.left.right = new TreeNode(5);
        root.left.right = new TreeNode(6);
        root.left.right.left = new TreeNode(7);

        return root;
    }
}
