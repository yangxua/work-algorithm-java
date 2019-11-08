package com.xuyang.algorithm.sort.impls;

import com.xuyang.algorithm.sort.AbstractSort;

/**
 * @Auther: allanyang
 * @Date: 2019/11/6 10:04
 * @Description:
 */
public class BubbleSort<T extends Comparable<T>> extends AbstractSort<T> {

    /**
     * 冒泡排序，首先找到最小的放到第一位，然后第二小的放到第二位
     * 稳定性：稳定
     * 时间复杂度：O(N^2)
     * 空间复杂度：O(1)
     */
    @Override
    protected void doSort(T[] nums) {
        for (int i = 0;i < nums.length;i++) {
            for (int j = nums.length-1;j > i;j--) {
                //如果nums[j] < nums[j-1],则把小的放到前面，循环一圈的效果是最小的再第i位
                if (less(nums[j], nums[j-1])) {
                    swap(nums, j, j-1);
                }
            }
        }
    }
}