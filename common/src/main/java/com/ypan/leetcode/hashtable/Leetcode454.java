package com.ypan.leetcode.hashtable;

import java.util.HashMap;
import java.util.Map;

public class Leetcode454 {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        // ToDo 做一下
            int res = 0;
            Map<Integer, Integer> map = new HashMap<>();
            for (int i : nums1) {
                for (int i1 : nums2) {
                    if (map.containsKey(i + i1)) {
                        map.put(i + i1, map.get(i + i1) + 1);
                    } else {
                        map.put(i + i1, 1);
                    }
                }
            }

            for (int i : nums3) {
                for (int i1 : nums4) {
                    if (map.containsKey(0 - i + i1)) {
                        res += map.get(i + i1);
                    }
                }
            }
            return res;
    }
}
