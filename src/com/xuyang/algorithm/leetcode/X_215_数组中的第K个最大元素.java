package com.xuyang.algorithm.leetcode;

import java.util.PriorityQueue;

/**
 * @Auther: allanyang
 * @Date: 2019/9/26 17:47
 * @Description:
 *
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 *
 * 示例 1:
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * 示例 2:
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 *
 */
public class X_215_数组中的第K个最大元素 {

    /**
     * 小顶堆
     * 时间复杂度:O(N*lgK)
     */
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num : nums) {
            minHeap.add(num);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        return minHeap.peek();
    }

    /**
     * 利用快速排序的partition解决
     * 时间复杂度:O(N)
     * N+N/2+N/4+N/8+... = O(n)
     */
    public int findKthLargest1(int[] nums, int k) {
        int left = 0;
        int right = nums.length-1;
        while (left < right) {
            int pivot = partition(nums, left, right);
            if (pivot == k-1) {
                return nums[pivot];
            }
            if (pivot < k) {
                left = pivot + 1;
            } else {
                right = pivot - 1;
            }
        }

        return nums[k-1];
    }

    private int partition(int[] nums, int left, int right) {
        int target = nums[left];

        while (left < right) {
            if (left < right && nums[right] <= target) {
                right--;
            }
            nums[left] = nums[right];
            if (left < right && nums[left] >= target) {
                left++;
            }
            nums[right] = nums[left];
        }

        nums[left] = target;
        return left;
    }

}