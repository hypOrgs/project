package com.ypan.comback.hashtable;

public class IsAnagram {
    public boolean isAnagram(String s, String t) {

        int[] array = new int[26];
        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            array[chars[i] - 97]++;
        }

        char[] chars1 = t.toCharArray();
        for (int i = 0; i < chars1.length; i++) {
            array[chars1[i] - 97]--;
        }

        for (int i : array) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }
}
