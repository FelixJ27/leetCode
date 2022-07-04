package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: Felix
 * @Description: 定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * <p>
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * 2-abc 3-def 4-ghi 5-jkl 6-mno 7-pqrs 8-tuv 9-wxyz
 */
public class LetterCombinations {

    private Map<Character, String> digitMap = new HashMap<Character, String>() {{
        put('2', "abc");
        put('3', "def");
        put('4', "ghi");
        put('5', "jkl");
        put('6', "mno");
        put('7', "pqrs");
        put('8', "tuv");
        put('9', "wxyz");
    }};

    public List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<>();
        if (digits.length() == 0) {
            return combinations;
        }
        backtrack(digits, 0, combinations, new StringBuilder());
        return combinations;
    }

    public void backtrack(String digits, int index, List<String> combinations, StringBuilder stringBuilder) {
        if (index == digits.length()) {
            combinations.add(stringBuilder.toString());
        } else {
            char digit = digits.charAt(index);
            String letter = digitMap.get(digit);
            int letterCount = letter.length();
            for (int i = 0; i < letterCount; i++) {
                stringBuilder.append(letter.charAt(i));
                backtrack(digits, index + 1, combinations, stringBuilder);
                stringBuilder.deleteCharAt(index);
            }
        }
    }
}
