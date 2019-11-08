package com.xuyang.algorithm.sort.impls;

import com.xuyang.algorithm.sort.AbstractSort;

/**
 * @Auther: allanyang
 * @Date: 2019/11/6 14:58
 * @Description:
 */
public class MergeSort<T extends Comparable<T>> extends AbstractSort<T> {


    /**
     * 归并排序
     * 稳定性：稳定
     * 时间复杂度：O（N*lgN）
     * 空间复杂度：O(N)
     */
    @Override
    protected void doSort(T[] nums) {
        doSort(nums, 0, nums.length-1);
    }

    private void doSort(T[] nums, int left, int right) {
        if (left >= right) {
            return ;
        }

        int mid = left + (right - left) / 2;
        doSort(nums, left, mid);
        doSort(nums, mid+1, right);
        merge(nums, left, mid, right);
    }

    private void merge(T[] nums, int left, int mid, int right) {
        int i = left;
        int j = mid+1;
        int k = 0;
        T[] tmp = (T[]) new Comparable[right - left + 1];

        while (i <= mid && j <= right) {
            if (less(nums[i], nums[j])) {
                tmp[k++] = nums[i++];
            } else {
                tmp[k++] = nums[j++];
            }
        }

        while (i <= mid) {
            tmp[k++] = nums[i++];
        }
        while (j <= right) {
            tmp[k++] = nums[j++];
        }

        for (int p = 0;p < tmp.length;p++) {
            nums[left+p] = tmp[p++];
        }
    }
}