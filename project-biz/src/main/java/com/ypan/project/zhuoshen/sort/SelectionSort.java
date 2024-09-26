package com.ypan.project.zhuoshen.sort;

import com.alibaba.fastjson.JSON;

public class SelectionSort {

    public static void sort(int [] array) {

        if (array.length < 2) {
            return;
        }
        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                minIndex = array[minIndex] > array[j] ? j : minIndex;
            }
            if (minIndex != i) {
                int temp = array[i];
                array[i] = array[minIndex];
                array[minIndex] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int [] a = {8,45,3,0,98,34,12,10};
        sort(a);
        System.out.println(JSON.toJSONString(a));
    }
}
