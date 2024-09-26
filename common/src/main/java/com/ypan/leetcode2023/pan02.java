package com.ypan.leetcode2023;

public class pan02 {

    public static int[] sortedSquares(int[] nums) {

        int left = 0;
        int length = nums.length;
        int right = length - 1;
        int[] ints = new int[length];

        int n = length - 1;
        while (n >= 0) {
            int left2 = nums[left] * nums[left];
            int right2 = nums[right] * nums[right];
            if (left2 >= right2) {
                left++;
                ints[n--] = left2;
            } else {
                right--;
                ints[n--] = right2;
            }
        }
        return ints;
    }

    public static void main(String[] args) {
        int[] array = {-4, -1, 0, 3, 10};
        int[] ints = sortedSquares(array);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }

}
