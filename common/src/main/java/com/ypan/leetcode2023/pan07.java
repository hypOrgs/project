package com.ypan.leetcode2023;

public class pan07 {
    public boolean isAnagram(String s, String t) {

        int [] array = new int[26];
        char[] chars = s.toCharArray();
        char[] charArray = t.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            array[chars[i] - 'a']++;
        }

        for (int i = 0; i < charArray.length; i++) {
            array[charArray[i] - 'a']--;
        }

        for (int i : array) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }
}
