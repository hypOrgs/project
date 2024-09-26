package com.ypan.project.leetcode.sort;

public class DichotomySearch {

    public static void main(String[] args) {

        int[] array = {8, 11, 19, 19, 27, 33, 45, 55, 67, 98};
        int i = ds03(array, 19);
        System.out.println(i);

    }


    /**
     * 二分呢查找，找到最后一个小于等于给定值的元素位置
     * @param array
     * @param value
     * @return
     */
    public static int ds05(int[] array, int value) {

        int low = 0;
        int high = array.length - 1;

        while (low <= high) {
            int mid = (low + (high - low) >> 1);
            if (array[mid] <= value) {
                if (mid == array.length - 1 || array[mid + 1] > value) {
                    return mid;
                } else {
                    low = mid + 1;
                }
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    /**
     * 二分查找，找到第一个大于等于给定值的元素位置
     * @param array
     * @param value
     * @return
     */
    public static int ds04(int[] array, int value) {

        int low = 0;
        int high = array.length - 1;

        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (array[mid] >= value) {
                if (mid == 0 || array[mid - 1] < value) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }


    /**
     * 二分查找，找到最后一个等于给定值的元素位置（数组有序，且有重复元素）
     * @param array
     * @param value
     * @return
     */
    public static int ds03(int[] array, int value) {

        int low = 0;
        int high = array.length - 1;


        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (array[mid] > value) {
                high = mid - 1;
            } else if (array[mid] < value) {
                low = mid + 1;
            } else {
                if (mid == array.length - 1 || array[mid + 1] != value) {
                    return mid;
                } else {
                    low = mid + 1;
                }
            }
        }
        return -1;
    }

    /**
     * 二分查找，找到第一个等于给定值的元素位置（数组元素有序，有重复元素）
     * @param array
     * @param value
     * @return
     */
    public static int ds02(int[] array, int value) {

        int low = 0;
        int high = array.length - 1;


        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (array[mid] > value) {
                high = mid - 1;
            } else if (array[mid] < value) {
                low = mid + 1;
            } else {
                if (mid == 0 || array[mid - 1] != value) {
                    return mid;
                }
            }
        }
        return -1;
    }

    /**
     * 二分查找，找到给定值的位置（数组元素有序，且不重复）
     * @param array
     * @param value
     * @return
     */
    public static int ds01(int[] array, int value) {

        int low = 0;
        int high = array.length - 1;
        return rec(low, high, array, value);
    }


    private static int rec(int low, int high, int[] array, int value) {
        int mid = low + ((high - low) >> 1);
        if (low > high) {
            return -1;
        }

        if (array[mid] > value) {
            high = mid - 1;
            return rec(low, high, array, value);
        } else if (array[mid] < value) {
            low = mid + 1;
            return rec(low, high, array, value);
        } else {
            return mid;
        }
    }
}
