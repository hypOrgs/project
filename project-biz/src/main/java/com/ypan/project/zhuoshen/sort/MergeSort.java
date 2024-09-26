package com.ypan.project.zhuoshen.sort;

import com.alibaba.fastjson.JSON;


public class MergeSort {

    public static void main(String[] args) {
        int [] a = {8,45,3,0,98,34,12,10};
        processor(a, 0, a.length - 1);
        System.out.println(JSON.toJSONString(a));
    }



    public static void processor(int[] array, int l, int r) {
        if (l == r) {
            return; // 当数组里只有一个元素时，必然有序
        }

        int mid = l + ((r - l) >> 1); // 求中点位置
        processor(array, l, mid); // 左侧有序
        processor(array, mid + 1, r); // 右侧有序
        merge(array, l, mid, r); // 归并排序


    }

    public static void merge(int[] array, int l, int m, int r) {
        int [] help = new int[r - l + 1];
        int i = 0;
        int p1 = l;
        int p2 = m + 1;

        // 当两侧均未越界的情况下：比较大小，并移动指针拷贝值到help数组里去
        // 当这个while循环进不去时，说明p1或者p2越界了
        while (p1 <= m && p2 <= r) {
            help[i++] = array[p1] <= array[p2] ? array[p1++] : array[p2++];
        }

        //如果p2越界了，说明p2所在数组已经全部拷贝到help数组里了
        // 这样也就可以把p1所在数组剩余的元素一起拷贝到help数组里
        while (p1 <= m) {
            help[i++] = array[p1++];
        }

        //如果p1越界了，说明p1所在数组已经全部拷贝到help数组里了
        // 这样也就可以把p2所在数组剩余的元素一起拷贝到help数组里
        while (p2 <= r) {
            help[i++] = array[p2++];
        }
        // 最后把help数组拷贝给原来的array数组
        for (i = 0; i < help.length; i++) {
            array[l+ i] = help[i];
        }
    }


}
