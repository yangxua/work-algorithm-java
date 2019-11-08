package com.xuyang.algorithm.sort;

/**
 * @Auther: allanyang
 * @Date: 2019/11/5 21:38
 * @Description:
 */
public abstract class AbstractSort<T extends Comparable<T>> {

    public void sort(T[] nums) {
        if (nums == null || nums.length == 0) {
            return ;
        }

        doSort(nums);
    }

    protected abstract void doSort(T[] nums);

    protected boolean less(T v, T w) {
        return v.compareTo(w) < 0;
    }

    protected void swap(T[] nums,int i, int j) {
        T tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}