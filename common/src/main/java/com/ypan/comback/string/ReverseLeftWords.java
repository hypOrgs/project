package com.ypan.comback.string;

import java.util.Arrays;
import java.util.TreeMap;

public class ReverseLeftWords {
    public static void main(String[] args) {

        String abcdefg = reverseLeftWords("abcdefg", 2);
    }
    public static String reverseLeftWords(String s, int n) {

        char[] chars = s.toCharArray();
        reverseStr(chars, 0, n - 1);
        reverseStr(chars, n, s.length() - 1);
        reverseStr(chars, 0, s.length() - 1);
        return Arrays.toString(chars);

    }


    public static void reverseStr(char[] chars, int left, int right) {

        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
    }
}
