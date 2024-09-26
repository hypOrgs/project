package com.ypan.comback.dong.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubstring {

    public int lengthOfLongestSubstring(String s) {

        int left = 0;
        int right = 0;
        int res = 0;
        Map<Character, Integer> win = new HashMap<>();

        while (right < s.length()) {
            char c = s.charAt(right);
            win.put(c, win.getOrDefault(c, 0) + 1);
            right++;
            while (win.get(c) > 1) {
                char c1 = s.charAt(left);
                win.put(c1, win.get(c1) - 1);
                left++;
            }
            res = Math.max(res, right - left);
        }
        return res;
    }
}
