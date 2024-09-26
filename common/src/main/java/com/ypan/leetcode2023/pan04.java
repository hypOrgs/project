package com.ypan.leetcode2023;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class pan04 {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> resList = new ArrayList<>();
        Deque<Integer> addList = new ArrayDeque<>();
        backTracking(n, k, 1, resList, addList);
        return resList;

// 添加注释

    }

    public void backTracking(int n, int k, int startIndex,  List<List<Integer>> resList, Deque<Integer> addList) {

        if (addList.size() == k) {
            resList.add(new ArrayList<>(addList));
            return;
        }
        for (int i = startIndex; i <= n; i++) {

            addList.add(i);
            backTracking(n, k, i+1, resList, addList);
            addList.removeLast();

        }
    }
}
