package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Felix
 * @Description: 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * <p>
 * 有效括号组合需满足：左括号必须以正确的顺序闭合。
 */
public class GenerateParenthesis {
    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }

    public static List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        backtrack(new StringBuilder(), n, ans, 0, 0);
        return ans;
    }

    public static void backtrack(StringBuilder sb, int n, List<String> ans, int open, int close) {
        if (sb.length() == n * 2) {
            ans.add(sb.toString());
            return;
        }
        if (open < n) {
            sb.append("(");
            backtrack(sb, n, ans, open + 1, close);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (close < open) {
            sb.append(")");
            backtrack(sb, n, ans, open, close + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
