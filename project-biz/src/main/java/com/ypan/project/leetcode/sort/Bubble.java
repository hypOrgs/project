package com.ypan.project.leetcode.sort;

import com.alibaba.fastjson.JSON;

/**
 * @author
 * @create 冒泡排序：
 */
public class Bubble {

    public static void bubbleSort(int[] array) {

        if (array.length <= 1) {
            return;
        }
        // 提前结束标志位
        boolean flag = false;
        // 外层循环控制轮数，一轮只能挑选一个满足的元素
        for (int i = 0; i < array.length; i++) {

            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    flag = true;
                }
            }
            // 如果没进入到内层循环，说明数组已经有序了，直接退出循环
            if (!flag) {
                return;
            }
        }
    }

    public static void main(String[] args) {

        int[] a = {10, 34, 23};
        Bubble.bubbleSort(a);
        System.out.println(JSON.toJSONString(a));
    }
}
