package com.ypan.project.leetcode.mid;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

public class LeetCode131 {

    public static void main(String[] args) {

        List<String> list = childrenStr("cdv");
        System.out.println(JSON.toJSONString(list));
    }

    public static List<String> childrenStr(String s) {
        List<String> res = new ArrayList<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            for (int j = i + 1; j <= chars.length; j++) {
                res.add(s.substring(i, j));
            }
        }
        return res;
    }
}
