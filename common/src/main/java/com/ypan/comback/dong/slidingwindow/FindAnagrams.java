package com.ypan.comback.dong.slidingwindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAnagrams {
    public List<Integer> findAnagrams(String s, String p) {

        int left = 0;
        int right = 0;
        List<Integer> res = new ArrayList<>();
        int valid = 0;

        Map<Character, Integer> win = new HashMap<>();
        Map<Character, Integer> needs = new HashMap<>();

        for (int i = 0; i < p.toCharArray().length; i++) {
            needs.put(p.charAt(i), needs.getOrDefault(p.charAt(i), 0) + 1);
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

            while (right - left == p.length()) {
                if (valid == needs.size()) {
                    res.add(left);
                }

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
        return res;
    }
}
