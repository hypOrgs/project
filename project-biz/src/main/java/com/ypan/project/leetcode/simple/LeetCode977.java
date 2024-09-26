package com.ypan.project.leetcode.simple;

import java.util.Arrays;

public class LeetCode977 {

    public int[] sortedSquares(int[] nums) {

        int[] newNums = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            newNums[i] = nums[i] * nums[i];
        }
        Arrays.sort(newNums);
        return newNums;
    }

    public int removeElement(int[] nums, int val) {

        int slowIndex = 0;
        for (int fastIndex = 0; fastIndex <= nums.length; fastIndex++) {

            while (nums[fastIndex] != val) {
                nums[slowIndex++] = nums[fastIndex];
            }
        }
        return slowIndex;
    }
}
