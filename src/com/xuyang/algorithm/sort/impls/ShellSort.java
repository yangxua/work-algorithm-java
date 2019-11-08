package com.xuyang.algorithm.sort.impls;

import com.xuyang.algorithm.sort.AbstractSort;

/**
 * @Auther: allanyang
 * @Date: 2019/11/6 14:42
 * @Description:
 */
public class ShellSort<T extends Comparable<T>> extends AbstractSort<T> {

    /**
     * 希尔排序：插入排序的升级版
     * 稳定性：不稳定
     * 时间复杂度：O(N^1.3)
     * 空间复杂度：O(1)
     */
    @Override
    protected void doSort(T[] nums) {
        int len = 1;
        while (len < nums.length / 3) {
            len = 3 * len + 1; //1,4,7
        }

        while (len >= 1) {
            for (int i = len;i < nums.length;i++) {
                for (int j = i;j >= len;j -= len) {
                    if (less(nums[j], nums[j-len])) {
                        swap(nums, j, j-len);
                    }
                }
            }

            len = len / 3;
        }
    }
}