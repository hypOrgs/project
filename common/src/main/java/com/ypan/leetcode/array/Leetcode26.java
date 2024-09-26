package com.ypan.leetcode.array;

import com.sun.source.tree.IfTree;

public class Leetcode26 {

    public int removeDuplicates(int[] nums) {

        if(nums == null || nums.length == 0) return 0;
        int p = 0;
        int q = 1;
        while(q < nums.length){
            if(nums[p] != nums[q]){
                nums[p + 1] = nums[q];
                p++;
            }
            q++;
        }
        return p + 1;

    }
}
