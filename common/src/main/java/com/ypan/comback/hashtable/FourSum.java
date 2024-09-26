package com.ypan.comback.hashtable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {

        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();

//        for (int i = 0; i < nums.length; i++) {
//
//            if (nums[i] > 0 && nums[i] > target) {
//                return res;
//            }
//
//            if (i > 0 && nums[i] == nums[i - 1]) {
//                continue;
//            }
//
//            for (int j = i + 1; j < nums.length; j++) {
//
//                if (j > i + 1 && nums[j] == nums[j - 1]);{
//                    continue;
//                }

        for (int i = 0; i < nums.length; i++) {

            // nums[i] > target 直接返回, 剪枝操作
            if (nums[i] > 0 && nums[i] > target) {
                return res;
            }

            if (i > 0 && nums[i - 1] == nums[i]) {    // 对nums[i]去重
                continue;
            }

            for (int j = i + 1; j < nums.length; j++) {

                if (j > i + 1 && nums[j - 1] == nums[j]) {  // 对nums[j]去重
                    continue;
                }

                int left = j + 1;
                int right = nums.length - 1;

                while (right > left) {

                    long sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum > target) {
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        right--;
                        left++;
                        while (right > left && nums[right] == nums[right - 1]) right--;
                        while (right > left && nums[left] == nums[left + 1]) left++;
                    }

                }

            }
        }
        return res;
    }
}
