package com.xuyang.algorithm.util;

/**
 * @Auther: allanyang
 * @Date: 2019/11/7 18:21
 * @Description:
 */
public class Utils {

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}