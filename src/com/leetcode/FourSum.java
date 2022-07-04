package com.leetcode;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: Felix
 * @Description: 给你一个由 n 个整数组成的数组nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组[nums[a], nums[b], nums[c], nums[d]]
 * （若两个四元组元素一一对应，则认为两个四元组重复）：
 * <p>
 * 0 <= a, b, c, d < n
 * a、b、c 和 d 互不相同
 * nums[a] + nums[b] + nums[c] + nums[d] == target
 * 你可以按 任意顺序 返回答案 。
 */
public class FourSum {

    public static void main(String[] args) {
        System.out.println(fourSum(new int[]{2,2,2,2,2}, 8));
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        int nLen = nums.length;
        for (int i = 0; i < nLen - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nLen - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int k = j + 1;
                int m = nLen - 1;
                while (k < m) {
                    int sum = nums[i] + nums[j] + nums[k] + nums[m];
                    if (sum > target) {
                        m--;
                    } else if (sum < target) {
                        k++;
                    } else {
                        list.add(Arrays.asList(nums[i], nums[j], nums[k], nums[m]));
                        while (k < m && nums[k] == nums[k + 1]) k++;
                        while (k < m && nums[m] == nums[m - 1]) m--;
                        k++;
                        m--;
                    }
                }
            }
        }
        return list;
    }
}
