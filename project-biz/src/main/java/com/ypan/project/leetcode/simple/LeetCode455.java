package com.ypan.project.leetcode.simple;

import java.util.Arrays;
import java.util.HashSet;

public class LeetCode455 {

    public int findContentChildren(int[] g, int[] s) {

        Arrays.sort(g);
        Arrays.sort(s);
        int result = 0;
        int index = s.length - 1;
        HashSet<Integer> hashSet = new HashSet<>();

        for (int i = g.length - 1; i >= 0; i--) {
            while (index >= 0 && s[index] >= g[i]) {
                result++;
                index--;
            }
        }
        return result;
    }
}
