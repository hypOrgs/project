package com.ypan.project.offer;

public class BubbleSort {

    public static void main(String[] args) {

        int[] a = {9,8,7,6,5,4,3,2,1};
        sort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]);
        }
    }


    public static void sort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n; i++) {
            boolean flag = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    flag = true;
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
            if (!flag) {
                return;
            }
        }
    }

}
