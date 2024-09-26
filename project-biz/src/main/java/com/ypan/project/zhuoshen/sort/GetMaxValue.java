package com.ypan.project.zhuoshen.sort;

public class GetMaxValue {

    public static int getMaxValue(int[] array) {
        return processor(array, 0, array.length - 1);
    }

    public static int processor(int[] array, int l, int r) {
        if (l == r) {
            return array[l]; // 当数组里只有一个元素时，必然是最大值
        }

        int mid = l + ((r - l) >> 1); //求中点位置
        int leftMax = processor(array, l, mid);
        int rightMax = processor(array, mid + 1, r);
        return Math.max(leftMax, rightMax);
    }

    public static void main(String[] args) {
        int [] a = {8,45,56,3};
        int maxValue = getMaxValue(a);
        System.out.println(maxValue);
    }
}
