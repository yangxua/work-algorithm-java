package com.xuyang.algorithm.sort.impls;

import com.xuyang.algorithm.sort.AbstractSort;

/**
 * @Auther: allanyang
 * @Date: 2019/11/6 11:29
 * @Description:
 */
public class InsertSort<T extends Comparable<T>> extends AbstractSort<T> {

    /**
     * 插入排序：向扑克牌排序一样新来的排插入到一个合理位置
     * 稳定性：稳定
     * 时间复杂度：O（N^2）
     * 空间复杂度：O(1)
     */
    @Override
    protected void doSort(T[] nums) {
        for (int i = 1;i < nums.length;i++) {
            for (int j = i;j > 0;j--) {
                if (less(nums[j], nums[j-1])) {
                    swap(nums, j, j-1);
                }
            }
        }
    }
}