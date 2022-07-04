package com.leetcode;

/**
 * @Author: Felix
 * @Description:
 */
public class No98 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val,TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        return isValidBST(root.left) && isValidBST(root.right)
                && (root.left == null ? true : root.val > root.left.val)
                && (root.right == null ? true : root.val < root.right.val);
    }
}
