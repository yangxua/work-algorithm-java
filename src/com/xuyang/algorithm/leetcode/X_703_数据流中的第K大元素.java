package com.xuyang.algorithm.leetcode;

import java.util.PriorityQueue;

/**
 * @Auther: allanyang
 * @Date: 2019/12/17 21:27
 * @Description:
 *
 * 设计一个找到数据流中第K大元素的类（class）。注意是排序后的第K大元素，不是第K个不同的元素。
 *
 * 你的 KthLargest 类需要一个同时接收整数 k 和整数数组nums 的构造器，它包含数据流中的初始元素。每次调用 KthLargest.add，返回当前数据流中第K大的元素。
 *
 * 示例:
 *
 * int k = 3;
 * int[] arr = [4,5,8,2];
 * KthLargest kthLargest = new KthLargest(3, arr);
 * kthLargest.add(3);   // returns 4
 * kthLargest.add(5);   // returns 5
 * kthLargest.add(10);  // returns 5
 * kthLargest.add(9);   // returns 8
 * kthLargest.add(4);   // returns 8
 *
 */
public class X_703_数据流中的第K大元素 {

}
class KthLargest {

    private PriorityQueue<Integer> minHeap;
    private int k;

    public KthLargest(int k, int[] nums) {
        minHeap = new PriorityQueue<Integer>(k);
        this.k = k;

        for (int i = 0;i < nums.length; i++) {
            add(nums[i]);
        }
    }

    public int add(int val) {
        if (minHeap.size() < k) {
            minHeap.offer(val);
        } else if (minHeap.peek() < val){
            minHeap.poll();
            minHeap.offer(val);
        }


        return minHeap.peek();
    }
}