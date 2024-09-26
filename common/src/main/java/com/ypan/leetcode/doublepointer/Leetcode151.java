package com.ypan.leetcode.doublepointer;

import java.util.Arrays;

public class Leetcode151 {
    public String reverseWords(String s) {
        // s = "the sky is blue"  eulb si yks eht  blue is sky the
        // blue is sky the

        StringBuilder sb = removeSpace(s);

        reverseStrByIndex(sb, 0, s.length() - 1);

        return reverseEachWord(sb);




    }

    public String reverseEachWord(StringBuilder sb) {

        int start = 0;
        int end = 1;
        int n = sb.length();
        while (start < n) {
            while (end < n && sb.charAt(end) != ' ') {
                end++;
            }
            reverseStrByIndex(sb, start, end);
            start = end + 1;
            end = start + 1;
        }
        return sb.toString();
    }

    public void reverseStrByIndex(StringBuilder sb, int start, int end) {

        while (start < end) {
            char temp = sb.charAt(start);
            sb.setCharAt(start, sb.charAt(end));
            sb.setCharAt(end, temp);
            start++;
            end--;
        }
    }

    public StringBuilder removeSpace(String s) {

        int start = 0;
        int end = s.length() - 1;

        while (s.charAt(start) == ' ') {
            start++;
        }

        while (s.charAt(end) == ' ') {
            end--;
        }

        StringBuilder stringBuilder = new StringBuilder();
        while (start <= end) {
            if (s.charAt(start) != ' ' || stringBuilder.charAt(stringBuilder.length() - 1) != ' ') {
                stringBuilder.append(s.charAt(start));
            }
            start++;
        }
        return stringBuilder;
    }

}
