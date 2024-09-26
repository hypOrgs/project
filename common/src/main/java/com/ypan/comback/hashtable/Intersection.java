package com.ypan.comback.hashtable;

import java.util.HashSet;

public class Intersection {
    public int[] intersection(int[] nums1, int[] nums2) {

        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> set1 = new HashSet<>();

        for (int i : nums1) {
            set.add(i);
        }

        for (int i : nums2) {
            if (set.contains(i)) {
                set1.add(i);
            }
        }
        return set1.stream().mapToInt(a -> a).toArray();
    }
}
