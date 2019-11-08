package com.xuyang.algorithm.sort.impls;

import com.xuyang.algorithm.sort.AbstractSort;

/**
 * @Auther: allanyang
 * @Date: 2019/11/6 15:42
 * @Description:
 */
public class HeapSort<T extends Comparable<T>> extends AbstractSort<T> {

    /**
     * 堆排序：首先从一般开始下沉，然后把大顶堆和数组最后元素交换。然后再次建堆
     * 稳定性: 不稳定
     * 时间复杂度：O（N*lgN）
     * 空间复杂度：O（1）
     * 现代操作系统很少使用堆排序，因为他无法利用局部性原理进行缓存，也就是数组元素很少和相邻的元素进行比较和交换.
     */
    @Override
    protected void doSort(T[] nums) {
        int n = nums.length-1;

        for (int i = n / 2;i >= 1;i--) {
            sink(nums, i, n);
        }

        while (1 < n) {
            swap(nums, 0, n--);
            sink(nums, 0, n);
        }
    }

    private void sink(T[] nums, int k, int n) {
        while (2 * k <= n) {
            int j = 2 * n;
            if (j < n && less(nums, j, j+1)) {
                j++;
            }
            if (!less(nums, k, j)) {
                break;
            }

            swap(nums, k, j);
            k = j;
        }
    }

    private boolean less(T[] nums, int i, int j) {
        return nums[i].compareTo(nums[j]) < 0;
    }

}