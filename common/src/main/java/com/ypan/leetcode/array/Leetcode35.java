package com.ypan.leetcode.array;

import java.util.Arrays;

public class Leetcode35 {
    public int searchInsert(int[] nums, int target) {
        int l = 0;
        int h = nums.length - 1;
        int n = nums.length;
        while (l <= h) {
            int mid = l + ((h - l) >> 1); // 使用这种方式求中点位置为了防止溢出
            if (nums[mid] > target) {
                h = mid - 1;
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                return mid;
            }
        }
        return h + 1;
    }
}
