package com.xuyang.algorithm.leetcode;


/**
 * @Auther: allanyang
 * @Date: 2019/9/5 15:58
 * @Description:
 *
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * 请找出其中最小的元素。
 *
 * 你可以假设数组中不存在重复元素。
 *
 * 示例 1:
 * 输入: [3,4,5,1,2]
 * 输出: 1
 * 示例 2:
 * 输入: [4,5,6,7,0,1,2]
 * 输出: 0
 *
 */
public class X_153_寻找旋转排序数组中的最小值 {

    /**
     * 153和154可以重用代码，
     * 注意这里中间值要和right相比较，因为和左边相比的时候你无法判断（是本来就比你大还是旋转后比你大呢？）
     * 例 1：[1, 2, 3, 4, 5]
     * 例 2：[2, 3, 4, 5, 1]
     * 中间值和左边比较做不出什么判断
     * 但是和右边比较的时候，我比你大肯定不是最小值了，并且你肯定在我右边（因为这时旋转过多导致的，左边都是递增趋势的）
     */
    public int findMin(int[] nums) {
        if (nums.length == 1 || nums[0] < nums[nums.length-1]) {
            return nums[0];
        }

        int left = 0;
        int right = nums.length-1;
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (nums[mid] > nums[right]) {
                left = mid+1;
            } else if (nums[mid] < nums[right]){
                right = mid;
            } else {
                right--;
            }
        }

        return nums[left];
    }
}