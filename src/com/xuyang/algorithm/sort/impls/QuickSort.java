package com.xuyang.algorithm.sort.impls;

import com.xuyang.algorithm.sort.AbstractSort;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Auther: allanyang
 * @Date: 2019/11/6 15:20
 * @Description:
 */
public class QuickSort<T extends Comparable<T>> extends AbstractSort<T> {

    /**
     * 快速排序
     * 稳定性：不稳定
     * 时间复杂度：O（N*lgN）
     * 空间复杂度：O（lgN）
     */
    @Override
    protected void doSort(T[] nums) {
        shuffle(nums);
        doSort(nums, 0, nums.length-1);
    }

    private void doSort(T[] nums, int left, int right) {
        if (left >= right) {
            return ;
        }

        int pivot = partition(nums, left, right);
        doSort(nums, left , pivot-1);
        doSort(nums, pivot+1 , right);
    }

    private int partition(T[] nums, int left, int right) {
        T target = nums[left];

        while (left < right) {
            //此处的equals要求重写
            while (left < right && (less(target, nums[right]) || target.equals(nums[right]))) {
                right--;
            }
            nums[left] = nums[right];
            while (left < right && less(nums[left], target) || target.equals(nums[right])) {
                left++;
            }
            nums[right] = nums[left];
        }

        nums[left] = target;
        return left;
    }

    private void shuffle(T[] nums) {
        List<T> list = Arrays.asList(nums);
        Collections.shuffle(list);
        list.toArray(nums);
    }

    /**
     * 找到数组中第k大的数
     * 时间复杂度：O（N）
     * 空间复杂度：O（1）
     * 时间复杂度分析:N+N/2+N/4+... = O(N)
     */
    public T select(T[] nums, int k) {
        int left = 0;
        int right = nums.length-1;

        while (left < right) {
            int pivot = partition(nums, left, right);
            if (pivot == k) {
                return nums[k];
            }
            if (pivot < k) {
                left = pivot+1;
            } else {
                right = pivot+1;
            }
        }

        return nums[k];
    }
}