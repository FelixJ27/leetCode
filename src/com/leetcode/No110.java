package com.leetcode;

/**
 * @Author: Felix
 * @Description:
 */
public class No110 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, null, new TreeNode(2, null ,new TreeNode(3)));
        System.out.println(isBalanced(root));
    }

    public static boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        return  Math.abs(height(root.left, 0) - height(root.right, 0)) < 2;
    }

    public static int height(TreeNode root, int h) {
        if (root == null || (root.left == null && root.right == null)){
            return 0;
        }
        if (root.left != null || root.right != null) {
            h++;
        }
        return Math.max(height(root.left, h), height(root.right, h)) + 1;
    }
}
