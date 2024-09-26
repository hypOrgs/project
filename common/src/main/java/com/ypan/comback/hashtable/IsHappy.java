package com.ypan.comback.hashtable;

import java.util.HashSet;

public class IsHappy {

    public static void main(String[] args) {

        isHappy(19);
    }
    public static boolean isHappy(int n) {

        HashSet<Integer> record = new HashSet<>();

        while (n != 1 && !record.contains(n)) {
            record.add(n);
            n = getNextNumber(n);
        }
        return n == 1;
    }

    private static int getNextNumber(int n) {

        int sum = 0;
        while (n > 0) {
            sum += (n % 10) * (n % 10);
            n = n / 10;
        }
        return sum;
    }

}
