package com.leetcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: Felix
 * @Description:
 */
public class No145 {

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

    //[1,null,2,3,4,null,null,5]
    public static void main(String[] args) {
        TreeNode r = new TreeNode(1, null, new TreeNode(2, new TreeNode(3, null, null), new TreeNode(4, new TreeNode(5, null, null), null)));
        postorderTraversal(r);
    }

    public static List<Integer> postorderTraversal(TreeNode root) {
        Deque<Integer> deque = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();
        postorderTraversal(root, ans, deque);
        return ans;
    }

    public static void postorderTraversal(TreeNode root, List<Integer> list, Deque<Integer> deque) {
        if (root == null) return;
        deque.push(root.val);
        if (root.left == null && root.right == null) {
            list.add(deque.pop());
        }
        postorderTraversal(root.left, list, deque);
        postorderTraversal(root.right, list, deque);
        while (!deque.isEmpty()) {
            list.add(deque.pop());
        }
    }
}
