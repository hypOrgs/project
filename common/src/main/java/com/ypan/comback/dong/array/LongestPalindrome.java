package com.ypan.comback.dong.array;

public class LongestPalindrome {
    public String longestPalindrome(String s) {

        String res = "";
        for (int i = 0; i < s.length(); i++) {
            String sub = sub(s, i, i);
            String sub1 = sub(s, i, i + 1);
            res = res.length() > sub.length() ? res : sub;
            res = res.length() > sub1.length() ? res : sub1;
        }
        return res;
    }

    public String sub(String s, int l, int r) {

        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return s.substring(l + 1, r);
    }
}
