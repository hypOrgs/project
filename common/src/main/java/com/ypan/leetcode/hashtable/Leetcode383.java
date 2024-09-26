package com.ypan.leetcode.hashtable;

public class Leetcode383 {
    public boolean canConstruct(String ransomNote, String magazine) {

        int[] a = new int[26];
        char b = 'a';

        for (char c : magazine.toCharArray()) {
            a[c - b] += 1;
        }

        for (char c : ransomNote.toCharArray()) {
            a[c - b] -= 1;
        }

        for (int i : a) {
            if (i < 0) {
                return false;
            }
        }
        return true;

    }
}
