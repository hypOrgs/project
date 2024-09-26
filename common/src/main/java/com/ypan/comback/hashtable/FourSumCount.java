package com.ypan.comback.hashtable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FourSumCount {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {


        Map<Integer, Integer> map = new HashMap<>();
            int res = 0;
            for (int i : nums1) {
                for (int i1 : nums2) {
                    map.put(i + i1, map.getOrDefault(i + i1, 0) + 1);
                }
            }

            for (int i : nums3) {
                for (int i1 : nums4) {
                    res += map.getOrDefault(-(i + i1), 0);
                }
            }
            return res;
    }

}
