package com.ypan.comback.doublepointer;

import lombok.Builder;

public class ReverseWords {
    public String reverseWords(String s) {

        StringBuilder builder = removeSpace(s);
        reverseStr(builder, 0, builder.length() - 1);
        reverseStrEach(builder);
        return builder.toString();
    }


    public void reverseStrEach(StringBuilder str){

        int start = 0;
        int end = 1;
        int n = str.length();

        while (start < n) {
            while (end < n && str.charAt(end) != ' ') {
                end++;
            }
            reverseStr(str, start, end - 1);
            start = end + 1;
            end = start + 1;
        }

    }

    public void reverseStr(StringBuilder str, int left, int right) {
        while (left < right) {
            char temp = str.charAt(left);
            str.setCharAt(left, str.charAt(right));
            str.setCharAt(right, temp);
            left++;
            right--;
        }
    }

    public StringBuilder removeSpace(String s) {

        int start = 0;
        int end = s.length() - 1;

        StringBuilder str = new StringBuilder();
        while (s.charAt(start) == ' ') start++;
        while (s.charAt(end) == ' ') end--;

        while (start <= end) {
            char c = s.charAt(start);
            if (c != ' ' || str.charAt(str.length() - 1) != ' ') {
                str.append(c);
            }
            start++;
        }
        return str;
    }
}
