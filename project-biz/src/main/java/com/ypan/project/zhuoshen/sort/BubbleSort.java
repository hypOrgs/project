package com.ypan.project.zhuoshen.sort;

import com.alibaba.fastjson.JSON;

public class BubbleSort {

    public static void sort(int [] array) {

        if (array.length < 2) {
            return;
        }
        // 提前终止标志
        boolean flag = false;
        for (int j = 0; j < array.length; j++) {

            for (int i = 0; i < array.length - 1 - j; i++) {


            }
            if (!flag) {
                return;
            }
        }

    }

    public static void main(String[] args) {
        int [] a = {8,45,3,0,98,34,12,10};
        sort(a);
        System.out.println(JSON.toJSONString(a));
    }
}
