package com.xuyang.algorithm.leetcode;

/**
 * @Auther: allanyang
 * @Date: 2019/8/27 20:03
 * @Description:
 *
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 *
 * 示例 1:
 * 输入: [1,2,3,4,5,6,7] 和 k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 *
 * 示例 2:
 * 输入: [-1,-100,3,99] 和 k = 2
 * 输出: [3,99,-1,-100]
 * 解释:
 * 向右旋转 1 步: [99,-1,-100,3]
 * 向右旋转 2 步: [3,99,-1,-100]
 *
 */
public class X_189_旋转数组 {

    /**
     * 1.开辟一个新数组，然后从新数组存放旋转后的结果在放入（不写具体实现）
     *
     * 2.字符串的旋转操作，先局部旋转，然后再整体旋转
     *   这里注意他给的k的含义，如果是下表，则后旋转，如果是向右移动，相当于反下表，则先旋转
     */
    public void rotate(int[] nums, int k) {
        int pivot = k % nums.length;

        reverse(nums,0, nums.length-1);
        reverse(nums,0, pivot-1);
        reverse(nums, pivot, nums.length-1);
    }

    private void reverse(int[] nums, int left, int right) {
        while (left >= 0 && left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }

    private void swap(int[] nums, int left, int right) {
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }

    public static void main(String[] args) {
        X_189_旋转数组 s = new X_189_旋转数组();
        s.rotate(new int[]{1,2,3,4,5,6,7}, 3);
    }
}