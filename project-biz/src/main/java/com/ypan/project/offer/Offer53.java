package com.ypan.project.offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Offer53 {
    public static void main(String[] args) {


    }

    public static int search(int[] nums, int target) {

        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (target == nums[i]) {
                count++;
            }
        }
        return count;
    }


    public int missingNumber(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) {
                return i;
            }

        }
        ArrayList<List<Integer>> lists = new ArrayList<>();

        ArrayList<Integer> integers = new ArrayList<>();
        return 0;
    }

    public int[] twoSum(int[] nums, int target) {

        int[] a = new int[2];
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    a[0] = i;
                    a[1] = j;
                }
            }
        }
        return a;
    }

    public boolean isValid(String s) {

        char[] chars = s.toCharArray();
        if (chars.length == 1) {
            return false;
        }
        Stack<Character> characters = new Stack<>();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {
                characters.push(')');
            } else if (chars[i] == '{') {
                characters.push('}');
            } else if (chars[i] == '[') {
                characters.push(']');
            } else {
                if (characters.isEmpty()) {
                    return false;
                }
                if (characters.pop()!=chars[i]) {
                    return false;
                }
            }
        }

        if (!characters.isEmpty()) {
            return false;
        }
        return true;
    }
}
