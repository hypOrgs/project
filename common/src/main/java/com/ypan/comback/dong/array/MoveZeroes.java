package com.ypan.comback.dong.array;

public class MoveZeroes {
    public void moveZeroes(int[] nums) {

        int i = moveItem(nums, 0);
        for (; i < nums.length; i++) {
            nums[i] = 0;
        }

    }


    public int moveItem(int[] nums, int val) {

        int fast = 0, slow = 0;
        while (fast < nums.length) {
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }
}
