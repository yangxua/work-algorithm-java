package com.xuyang.algorithm.leetcode;

/**
 * @Auther: allanyang
 * @Date: 2019/9/26 16:47
 * @Description:
 *
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 *
 * 注意:
 * 不能使用代码库中的排序函数来解决这道题。
 *
 * 示例:
 *
 * 输入: [2,0,2,1,1,0]
 * 输出: [0,0,1,1,2,2]
 *
 */
public class X_75_颜色分类 {

    public void sortColors(int[] nums) {
        if (nums.length == 0) {
            return;
        }

        int left = 0;
        int right = nums.length-1;
        for (int i = 0;i < nums.length;i++) {
            while (i < right && nums[i] == 2) {
                swap(nums, i, right--);
            }
            while (i > left && nums[i] == 0) {
                swap(nums, i, left++);
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}