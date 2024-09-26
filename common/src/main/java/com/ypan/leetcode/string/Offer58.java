package com.ypan.leetcode.string;

public class Offer58 {

    public static void main(String[] args) {

        reverseLeftWords("abcd", 2);
    }
    public static String reverseLeftWords(String s, int n) {
        // abcd 2 -> cdab
        // abcd-> dcba -> cdba ->cdab

        char[] chars = s.toCharArray();
        reString(0, chars.length - 1, chars);
        reString(0, n - 1, chars);
        reString(n, chars.length - 1, chars);
        return chars.toString();
    }

    public static void reString(int startIndex, int endIndex, char[] a) {
        while (startIndex < endIndex) {
            char temp = a[startIndex];
            a[startIndex] = a[endIndex];
            a[endIndex] = temp;
            startIndex++;
            endIndex--;
        }
    }
}
