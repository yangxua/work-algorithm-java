package com.xuyang.algorithm.sort.impls;

import com.xuyang.algorithm.sort.AbstractSort;

/**
 * @Auther: allanyang
 * @Date: 2019/11/6 10:29
 * @Description:
 */
public class SelectSort<T extends Comparable<T>> extends AbstractSort<T> {

    /**
     * 选择排序：遍历一次所有的，把最小的给第i位
     * 稳定性：不稳定   （5，5，2）第一次排序会把第一个5和2交换顺序
     * 时间复杂度：O(N^2)
     * 空间复杂度：O(1)
     */
    @Override
    protected void doSort(T[] nums) {
        for (int i = 0;i < nums.length;i++) {
            int min = i;
            for (int j = i+1;j < nums.length;j++) {
                if (less(nums[j], nums[min])) {
                    min = j;
                }
            }
            swap(nums, min, i);
        }
    }
}