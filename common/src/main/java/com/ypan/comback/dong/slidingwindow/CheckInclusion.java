package com.ypan.comback.dong.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class CheckInclusion {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> needs = new HashMap<>();
        Map<Character, Integer> win = new HashMap<>();

        int left = 0;
        int right = 0;
        int valid = 0;

        for (int i = 0; i < s1.toCharArray().length; i++) {
            needs.put(s1.charAt(i), needs.getOrDefault(s1.charAt(i), 0) + 1);
        }

        while (right < s1.length()) {

            char c = s1.charAt(right);
            right++;

            if (needs.containsKey(c)) {
                win.put(c, win.getOrDefault(c, 0) + 1);
                if (needs.get(c).equals(win.get(c))) {
                    valid++;
                }
            }
            // 判断左侧窗口是否要收缩
            while (right - left >= s2.length()) {
                // 在这里判断是否找到了合法的子串
                if (valid == needs.size())
                    return true;
                char d = s2.charAt(left);
                left++;
                if (needs.containsKey(d)) {
                    if (win.get(d).equals(needs.get(d)))
                        valid--;
                    win.put(d, win.getOrDefault(d, 0) - 1);
                }
            }
        }
        // 未找到符合条件的子串
        return false;
    }
}
