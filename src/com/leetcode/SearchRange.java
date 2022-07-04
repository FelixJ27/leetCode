package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: Felix
 * @Description:
 */
public class SearchRange {
    public static void main(String[] args) {
        int[] nums = new int[]{5};
        int target = 5;
        int[] ans = searchRange(nums, target);
        for (int an : ans) {
            System.out.println(an);
        }
    }

    public static int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[]{-1, -1};
        }

        List<Integer> l = new ArrayList<>();
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] < target && nums[i + 1] == target) {
                l.add(i + 1);
            } else if (nums[i] == target && nums[i + 1] > target) {
                l.add(i);
            } else if (nums[i] == target && nums.length == 1) {
                l.add(i);
            }
        }
        int[] ans;
        if (l.size() == 2) {
            ans = new int[]{l.get(0), l.get(l.size() - 1)};
        } else if (l.size() == 1) {
            ans = new int[]{l.get(0)};
        } else {
            ans = new int[]{-1, -1};
        }
        return ans;
    }
}
