package com.leetcode;

import java.util.Arrays;

/**
 * @Author: Felix
 * @Description: 整数数组的一个 排列  就是将其所有成员以序列或线性顺序排列。
 * <p>
 * 例如，arr = [1,2,3] ，以下这些都可以视作 arr 的排列：[1,2,3]、[1,3,2]、[3,1,2]、[2,3,1] 。
 * 整数数组的 下一个排列 是指其整数的下一个字典序更大的排列。更正式地，如果数组的所有排列根据其字典顺序从小到大排列在一个容器中，那么数组的 下一个排列 就是在这个有序容器中排在它后面的那个排列。如果不存在下一个更大的排列，那么这个数组必须重排为字典序最小的排列（即，其元素按升序排列）。
 * <p>
 * 例如，arr = [1,2,3] 的下一个排列是 [1,3,2] 。
 * 类似地，arr = [2,3,1] 的下一个排列是 [3,1,2] 。
 * 而 arr = [3,2,1] 的下一个排列是 [1,2,3] ，因为 [3,2,1] 不存在一个字典序更大的排列。
 * 给你一个整数数组 nums ，找出 nums 的下一个排列。
 * <p>
 * 必须 原地 修改，只允许使用额外常数空间。
 */
public class NextPermutation {

    public static void main(String[] args) {
        int[] nums = new int[]{4,2,0,2,3,2,0};
        nextPermutation(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }

    public static void nextPermutation(int[] nums) {
        int n = nums.length;
        if (n == 0 || n == 1) {
            return;
        }

        int left = nums[n - 1];
        int right = nums[n - 2];
        boolean flag = false;
        for (int i = n - 1; i >= 1; i--) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] - nums[j] > 0) {
                    left = j;
                    right = i;
                    flag = true;
                    break;
                }
            }
            if (flag) {
                break;
            }
        }
        if (!flag) {
            Arrays.sort(nums);
            return;
        }
        //交换较大数nums[right]与较小数nums[left]
        int temp = nums[right];
        nums[right] = nums[left];
        nums[left] = temp;
        //对于nums[right]到nums[n - 1]排序
        for (int i = 0; i < n - 1; i++) {
            for (int j = left + 1; j < n - 1 - i; j++) {
                temp = nums[j];
                nums[j] = nums[j + 1];
                nums[j + 1] = temp;
            }
        }
    }
}
