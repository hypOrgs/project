package com.ypan.project.leetcode.simple;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@Slf4j
public class LeetCode209 {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        List list = Arrays.asList(arr);
        log.info("list:{} size:{} class:{}", list, list.size(), list.get(0).getClass());
    }

    public int[] intersection(int[] nums1, int[] nums2) {


        HashSet<Integer> set = new HashSet();
        for(int i = 0; i <= nums1.length - 1; i++) {
            for(int j = 0; j <= nums2.length - 1; j++) {
                if(nums1[i] == nums2[j]) {
                    set.add(nums1[i]);
                }
            }
        }
        return set.stream().mapToInt(a -> a).toArray();
    }

}
