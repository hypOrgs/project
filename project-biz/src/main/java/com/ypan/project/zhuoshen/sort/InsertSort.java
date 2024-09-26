package com.ypan.project.zhuoshen.sort;

import com.alibaba.fastjson.JSON;

/**
 * @author
 * @create
 */
public class InsertSort {

    public static void sort(int[] array) {

        if (array == null || array.length < 2) {
            return;
        }

        for (int i = 1; i < array.length; i++) { //因为0~0不用去比较，所以直接 1~N-1

            for (int j = i; j > 0; j--) {

                if (array[j] < array[j-1]) {
                    // 使用异或运算的前提是保证需要交换的两个数不是指向同一个内存地址
                    array[j] = array[j] ^ array[j-1];
                    array[j-1] = array[j] ^ array[j-1];
                    array[j] = array[j] ^ array[j-1];
                }
            }
        }
    }

    public static void main(String[] args) {
        int [] a = {8,45,3,0,98,34,12,10};
        sort(a);
        System.out.println(JSON.toJSONString(a));
    }
}
