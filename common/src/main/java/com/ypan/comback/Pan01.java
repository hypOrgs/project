package com.ypan.comback;

/**
 * 设计一个函数，计算一个数组[7, 2, 4, 1, 5, 6, 3, ...]内，连续n个数的和的最大值
 * int maxSum(int[] nums, int n)
 */
public class Pan01 {
    public static int maxSum(int[] nums, int n) {

        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int currSum = 0;
            int fast = i + 1;
            currSum = nums[i];
            while (fast - i + 1 > n) {
                currSum += nums[fast++];
            }
            maxSum = Math.max(currSum, maxSum);
        }
        return maxSum;
    }

}
