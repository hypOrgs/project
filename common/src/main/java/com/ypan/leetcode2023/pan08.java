package com.ypan.leetcode2023;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class pan08 {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> has = new HashSet<>();
        HashSet<Integer> resSet = new HashSet<>();
        List<Integer> result = new ArrayList<>();

        for (int i : nums1) {
            has.add(i);
        }

        for (Integer integer : nums2) {
            if (has.contains(integer)) {
                result.add(integer);
            }
        }
        return result.stream().mapToInt( x -> x).toArray();
    }
}
