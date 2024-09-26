package com.ypan.leetcode.string;

public class Leetcode151 {

    public  String reverseWords(String s) {
        // 移除前后空格和单词中间多余空格
        StringBuilder stringBuilder = removeSpace(s);
        // 反转整个字符串
        reverseString(stringBuilder, 0, stringBuilder.length() - 1);
        // 反转字符串中的每一个单词
        reverseEachWord(stringBuilder);
        return stringBuilder.toString();
    }

    private void reverseEachWord(StringBuilder stringBuilder) {

        int start = 0;
        int end = 1;
        int n = stringBuilder.length();
        while (start < n) {
            while (end < n && stringBuilder.charAt(end) != ' ') {
                end++;
            }
            reverseString(stringBuilder, start, end);
            start = end + 1;
            end = start + 1;
        }

    }

    public void reverseString(StringBuilder sb, int start, int end) {
        while (start < end) {
            char temp = sb.charAt(start);
            sb.setCharAt(start, sb.charAt(end));
            sb.setCharAt(end, temp);
            start++;
            end--;
        }
    }

    private  StringBuilder removeSpace(String s) {
        int start = 0;
        int end = s.length() - 1;
        while (s.charAt(start) == ' ') start++;
        while (s.charAt(end) == ' ') end--;
        StringBuilder sb = new StringBuilder();
        while (start <= end) {
            char c = s.charAt(start);
            if (c != ' ' || sb.charAt(sb.length() - 1) != ' ') {
                sb.append(c);
            }
            start++;
        }
        return sb;
    }
}
