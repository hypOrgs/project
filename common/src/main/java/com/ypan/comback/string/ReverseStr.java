package com.ypan.comback.string;

import java.util.Arrays;

public class ReverseStr {
    public String reverseStr(String s, int k) {

        int length = s.length();
        if (length >= 2 * k) {
            String reverse = reverse(s, 0, k);
        }
        return null;
    }

    public String reverse(String s, int start, int end) {

        char[] chars = s.toCharArray();
        while (start < end) {
            char temp = ' ';
            temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }
        return Arrays.toString(chars);
    }
}
