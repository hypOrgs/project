package com.ypan.comback;

/**
 * 设计一个函数，计算一个数组[7, 2, 4, 1, 5, 6, 3, ...]内，连续n个数的和的最大值
 * int maxSum(int[] nums, int n)
 */
public class pan00 {
    public static void main(String[] args) {

        int[] array = {7, 2, 4, 1, 5, 6, 3};
        int i = minWin(array, 3);
        System.out.println(i);
    }


    public static int minWin(int[] array, int n) {

        int left = 0;
        int right = 0;
        int max = Integer.MIN_VALUE;
        int sum = 0;

        while (right < array.length) {
            sum += array[right++];

            if (right - left == n) {
               max = Math.max(max, sum);
               sum -= array[left++];
            }
        }
        return max;
    }



    public static int maxSum(int[] nums, int n) {

        int sum = Integer.MIN_VALUE;

        for (int i = 0; i <= nums.length - n; i++) {
            int currSum = 0;
            for (int j = i; j < i + n; j++) {
                currSum += nums[j];
            }
            sum = Math.max(currSum, sum);
        }
        return sum;
    }


    public static int maxSum3(int[] nums, int n) {

        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int currSum = 0;
            int fast = i + 1;
            currSum = nums[i];
            while (fast - i < n && fast <= nums.length - 1) {
                currSum += nums[fast++];
            }
            maxSum = Math.max(currSum, maxSum);
        }
        return maxSum;
    }

    public static int maxSum2(int[] nums, int n) {

        int maxSum;
        int currSum = Integer.MIN_VALUE;


        // 初始化窗口
        for (int i = 0; i < n; i++) {
            currSum += nums[i];
        }

        maxSum = currSum;

        for (int i = n; i < nums.length; i++) {
            currSum += nums[n] - nums[i - n];
            maxSum = Math.max(currSum, maxSum);
        }
        return maxSum;
    }
}
