package com.xuyang.algorithm.leetcode;

/**
 * @Auther: allanyang
 * @Date: 2019/8/26 17:27
 * @Description:
 *
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 *
 */
public class X_84_柱状图中最大矩形 {

    /**
     * 递归法
     */
    public int largestRectangleArea(int[] heights) {
        if (heights.length == 0) {
            return 0;
        }

        return process(heights, 0, heights.length-1);
    }

    private int process(int[] heights, int left, int right) {
        if (left > right) {
            return 0;
        }

        int min = left;
        for (int i = left;i <= right; i++) {
            if (heights[i] < heights[min]) {
                min = i;
            }
        }

        return Math.max(heights[min] * (right-left+1), Math.max(process(heights, min+1, right), process(heights, left, min-1)));
    }

    /**
     * 迭代法
     */
    public int largestRectangleArea1(int[] heights) {
        if (heights.length == 0) {
            return 0;
        }

        int[] leftIndex = new int[heights.length];
        int[] rightIndex = new int[heights.length];
        leftIndex[0] = -1;
        rightIndex[heights.length-1] = heights.length;

        for (int i = 1;i < heights.length;i++) {
            int p = i-1;
            while (p >= 0 && heights[p] >= heights[i]) {
                p = leftIndex[p];
            }

            leftIndex[i] = p;
        }

        for (int i = heights.length-2; i >= 0;i--) {
            int p = i+1;
            while (p < heights.length && heights[p] >= heights[i]) {
                p = rightIndex[p];
            }

            rightIndex[i] = p;
        }

        int max = 0;
        for (int i = 0;i < heights.length;i++) {
            max = Math.max(max, heights[i] * (rightIndex[i] - leftIndex[i] - 1));
        }

        return max;
    }

    public static void main(String[] args) {
        X_84_柱状图中最大矩形 s = new X_84_柱状图中最大矩形();
        s.largestRectangleArea1(new int[]{2,1,5,6,2,3});
    }

}