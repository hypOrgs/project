package com.ypan.comback.dong.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class MinWindow {
    public String minWindow(String s, String t) {

        Map<Character, Integer> needs = new HashMap<>();
        Map<Character, Integer> win = new HashMap<>();

        int left = 0;
        int right = 0;
        int valid = 0;
        int start = 0;
        int len = Integer.MAX_VALUE;

        for (int i = 0; i < t.toCharArray().length; i++) {
            needs.put(t.charAt(i), needs.getOrDefault(t.charAt(i), 0) + 1);
        }

        while (right < s.length()) {

            char c = s.charAt(right);
            right++;

            if (needs.containsKey(c)) {
                win.put(c, win.getOrDefault(c, 0) + 1);
                if (needs.get(c).equals(win.get(c))) {
                    valid++;
                }
            }

            while (needs.size() == valid) {

                if (right - left < len) {
                    start = left;
                    len = right - left;
                }
                // 开始收缩左窗口

                char c1 = s.charAt(left);
                left++;

                if (needs.containsKey(c1)) {
                    if (needs.get(c1).equals(win.get(c1))) {
                        valid--;
                    }
                    win.put(c1, win.get(c1) - 1);
                }
            }
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }
}
