package com.ypan.project.leetcode.simple;

import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * question:
 * 问题：给定一个整数数组 nums 和一个整数目标值 target，
 * 请你在该数组中找出 和为目标值 target 的那 两个 整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 *https://leetcode-cn.com/problems/two-sum/
 * 两数之和
 * 1. Map存储着val 对应的下标
 * 2. target - num[i] 在Map中有存储，则能算出结果
 */
public class LeetCode1 {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> memo = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int val = target - nums[i];
            if (memo.containsKey(val)) {
                return new int[]{i, memo.get(val)};
            } else {
                memo.put(nums[i], i);
            }
        }
        return new int[2];
    }

    public static void main(String[] args) {
        LeetCode1 leetCode1 = new LeetCode1();
        int [] arrayInt = {2,7,9,5,6};
        int target = 12;
        int[] ints = leetCode1.twoSum(arrayInt, target);
        System.out.println(JSONObject.toJSONString(ints));
    }

}
