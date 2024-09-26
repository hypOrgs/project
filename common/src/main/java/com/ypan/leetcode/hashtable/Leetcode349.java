package com.ypan.leetcode.hashtable;

import java.util.HashSet;

public class Leetcode349 {
    public int[] intersection(int[] nums1, int[] nums2) {

        HashSet<Integer> has = new HashSet<>();
        HashSet<Integer> resSet = new HashSet<>();

        for (int i : nums1) {
            has.add(i);
        }

        for (Integer integer : nums2) {
            if (has.contains(integer)) {
                resSet.add(integer);
            }
        }
        return resSet.stream().mapToInt(x -> x).toArray();
    }
}
