package com.ypan.project.offer;

import java.util.*;

public class Offer03 {
    public static void main(String[] args) {
        int[] a = {2,2,1,0};
        findRepeatNumber(a);
    }

    public static int findRepeatNumber(int[] nums) {

        Map<Integer, Integer> hashMap = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsValue(nums[i])) {
                return nums[i];
            }else {
                hashMap.put(i, nums[i]);
            }
        }
       return 0;
    }
}
