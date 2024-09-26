package com.ypan.leetcode.array;

public class Leetcode977 {
    public int[] sortedSquares(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        int [] result = new int[nums.length];
        int k = result.length - 1;
       while (l <= r) {

            if (nums[l] * nums[l] <= nums[r] * nums[r]) {
                result[k--] = nums[r--] * nums[r--];
            } else {
                result[k--] = nums[l++] * nums[l++];
            }
        }
        return result;
    }
}
