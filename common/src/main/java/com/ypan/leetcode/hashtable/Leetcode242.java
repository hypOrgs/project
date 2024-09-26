package com.ypan.leetcode.hashtable;

public class Leetcode242 {

    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        isAnagram(s, t);
    }
    public static boolean isAnagram(String s, String t) {

        int characterCountArray[] = new int[26];
        char a = 'a';

        for (int i = 0; i < s.length(); i++) {
            characterCountArray[s.charAt(i) - a]++;
        }

        for (int i = 0; i < t.length(); i++) {
            characterCountArray[t.charAt(i) - a]--;
        }

        for (int i = 0; i < characterCountArray.length; i++) {
            if (characterCountArray[i] != 0) {
                return false;
            }
        }
        return true;

    }
}
