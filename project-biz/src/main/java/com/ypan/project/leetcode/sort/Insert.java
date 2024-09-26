package com.ypan.project.leetcode.sort;

public class Insert {
    public void insertSort(int [] array) {

        int length = array.length;
        // 如果数组只有一个元素，直接返回即可
        if (length <= 1){
            return;
        }

        // 外层循环控制轮数，实际轮数是数组的长度，每一轮下来会插入一个元素到排序的数组，
        // 所以有n个元素就需要n轮
        // 但是第一个元素不需要插入，所以实际轮数应该是数组长度-1
        for (int i = 1; i < length; ++i) {

            // 待排序的数
            int value = array[i];
            // 要比较的次数
            int j = i - 1;
            // 查找插入的位置
            for (; j >= 0; --j) {
                if (array[j] > value) {
                    // array[j]:已排好序的数
                    array[j+1] = array[j];  // 数据移动
                } else {
                    break;
                }
            }
            array[j+1] = value; // 插入数据
        }
    }
}
