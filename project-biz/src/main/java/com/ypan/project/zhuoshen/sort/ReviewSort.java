package com.ypan.project.zhuoshen.sort;

import com.alibaba.fastjson.JSON;

public class ReviewSort {

    public static void main(String[] args) {
        int[] a = {56, 9, 88, 7, 68, 5, 4, 3, 22, 1, 10};
        mergeSort(a);
        System.out.println(JSON.toJSONString(a));
    }

    public static void mergeSort(int[] array) {

        if (array.length < 2) {
            return;
        }
        mergerRec(array, 0, array.length -1);

    }

    public static void mergerRec(int[] array, int L, int R) {

        if (L == R) {
            return;
        }
        int mid = (L + R) / 2;
        mergerRec(array, L, mid);
        mergerRec(array, mid + 1, R);
        mergeSort(array, L, mid, R);

    }

    public static void mergeSort(int[] array, int L, int M, int R) {
        int[] help = new int[R - L + 1];
        int i = 0;
        int p1 = L;
        int p2 = M + 1;

        while (p1 <= M && p2 <= R) {
            help[i++] = array[p1] <= array[p2] ? array[p1++] : array[p2++];
        }
        while (p1 <= M) {
            help[i++] = array[p1++];
        }

        while (p2 <= R) {
            help[i++] = array[p2++];
        }
        for (i = 0; i < help.length; i++) {
            array[L + i] = help[i];
        }
    }


    public static void insertSort(int[] array) {

        if (array.length < 2) {
            return;
        }
        for (int i = 1; i < array.length; i++) {
            for (int j = i; j > 0; j--) {
                if (array[j] < array[j - 1]) {
                    swap(array, j, j - 1);
                }
            }
        }
    }

    public static void bubbleSort(int[] array) {

        if (array.length < 2) {
            return;
        }

        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                }
            }
        }
    }


    public static void selectSort(int[] array) {

        int length = array.length;
        if (length < 2) {
            return;
        }
        for (int i = 0; i < length - 1; i++) {
            int minIndex = i;
            for (int j = i; j < array.length; j++) {
                minIndex = array[minIndex] > array[j] ? j : minIndex;
            }
            if (minIndex != i) {
                swap(array, minIndex, i);
            }
        }
    }

    public static void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}
