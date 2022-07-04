package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: Felix
 * @Description: 给定一个字符串 s 和一些 长度相同 的单词 words 。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。
 * <p>
 * 注意子串要与 words 中的单词完全匹配，中间不能有其他字符 ，但不需要考虑 words 中单词串联的顺序。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/substring-with-concatenation-of-all-words
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindSubstring {

    public static void main(String[] args) {
        String s = "barfoothefoobarman";
        String[] words = new String[]{"foo","bar"};
        List<Integer> substring = findSubstring(s, words);
        for (Integer integer : substring) {
            System.out.println(integer);
        }
    }

    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ans = new ArrayList<>();
        if (words.length == 0 || s.length() == 0) {
            return ans;
        }
        List<String> list = Arrays.asList(words);
        List<String> wordList = new ArrayList<>(list);
        int n = words[0].length();
        int i = 0;
        boolean flag = false; //是否已经存在符合条件的字符串
        while (i < s.length() - n) {
            String substring = s.substring(i, i + n);
            if (wordList.contains(substring)) {
                i += n;
                wordList.remove(substring);
                if (wordList.size() == 0) {
                    flag = true;
                    ans.add(i - words.length * n);
                    i -= ((words.length - 1) * n);
                }
            } else {
                if (flag) {
                    i++;
                }
                i -= ((words.length - wordList.size() - 1) * n);
                wordList = new ArrayList<>(list);
            }

            if (i != s.length() - n && wordList.size() == 0) {
                wordList = new ArrayList<>(list);
            }
        }

        return ans;
    }
}
