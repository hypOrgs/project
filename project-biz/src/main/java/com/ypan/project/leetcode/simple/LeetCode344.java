package com.ypan.project.leetcode.simple;

public class LeetCode344 {
    public void reverseString(char[] s) {

//        for (int i = 0; i < s.length; i++) {
//
//        }

        int left = 0;
        int right = s.length - 1;
        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right++;
        }
    }
}
