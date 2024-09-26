package com.ypan.leetcode2023;

import java.util.HashSet;

public class pan09 {
    public boolean isHappy(int n) {

        HashSet<Integer> hashSet = new HashSet<>();
        while (n != 1 && !hashSet.contains(n)) {
            hashSet.add(n);
            n = getNumber(n);
        }
        return n == 1;
    }

    public int getNumber(int n) {

        int res = 0;
        while (n > 0) {
            int temp = n % 10;
            res += temp * temp;
            n = n / 10;
        }
        return res;
    }
}
