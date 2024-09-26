package com.ypan.project.zhuoshen.sort;

import com.alibaba.fastjson.JSON;

public class QuickSort {

    public static void main(String[] args) {
        int [] a = {8,45,3,0,98,34,12,10};
        sort(a);
        System.out.println(JSON.toJSONString(a));
    }


    public static void sort(int[] array) {
        if (array == null || array.length < 2) {
            return;
        }
        quickSort(array, 0, array.length - 1);
    }

    public static void quickSort(int[] array, int l, int r) {

        if (l < r) {
            swap(array, l + (int) (Math.random() * (r - l + 1)), r); // 等概率随机选一个位置，把它和数组最右侧的值做交换
            int[] p = partition(array, l, r); // 划分好之后，中间相等值数组的左边界和右边界下标的值集合，长度就是2
            quickSort(array, l, p[0] - 1); // <区 p[0]等于区域的左边界，p[0]-1就是小于区域的右边界
            quickSort(array, p[1] + 1, r); // >区 p[1]等于区域的右边界，p[1]+1就是大于区域的左边界
        }
    }

    // 默认以array[r]做划分，  <p     ==p    >p
    // 返回等于区域(左边界值下标，右边界值下标),所以返回y一个长度为2的数组res：res[0]、res[1]
    public static int[] partition(int[] array, int l, int r) {
        int less = l - 1; // <区域右边界
        int more = r; // >区域左边界
        while (l < more) { // l表示当前数的位置，array[r]：划分值
            if (array[l] < array[r]) { // 当前数小于划分值，小于区域右扩
                swap(array, ++less, l++);
            } else if (array[l] > array[r]) { // 当前数大于划分值，大于区域左扩
                swap(array, --more, l);
            } else { // 当前数等于划分值
                l++;
            }
        }
        swap(array, more, r);
        return new int[]{less + 1, more};
    }

    public static void swap(int [] array, int i, int j) {
        int temp = 0;
        temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
