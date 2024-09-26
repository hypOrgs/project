package com.ypan.comback.array;

/**
 * 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
 *
 * 示例 1：
 *
 * 输入：nums = [-4,-1,0,3,10]
 * 输出：[0,1,9,16,100]
 * 解释：平方后，数组变为 [16,1,0,9,100]，排序后，数组变为 [0,1,9,16,100]
 */
public class OrderedArrays {
    public static void main(String[] args) {

    }

    public static int[] orderedArrays(int[] nums) {

        int l = 0;
        int r = nums.length - 1;
        int[] resArray = new int[nums.length];
        int maxIndex = nums.length - 1;

        while (l <= r) {
            int tempL = nums[l] * nums[l];
            int tempR = nums[r] * nums[r];
            if (tempL >= tempR) {
                resArray[maxIndex--] = tempL;
                l++;
            } else {
                resArray[maxIndex--] = tempR;
                r--;
            }
        }
        return resArray;
    }


}
