package com.xuyang.algorithm.leetcode;

/**
 * @Auther: allanyang
 * @Date: 2019/11/8 11:44
 * @Description:
 *
 * 集合 S 包含从1到 n 的整数。不幸的是，因为数据错误，导致集合里面某一个元素复制了成了集合里面的另外一个元素的值，导致集合丢失了一个整数并且有一个元素重复。
 * 给定一个数组 nums 代表了集合 S 发生错误后的结果。你的任务是首先寻找到重复出现的整数，再找到丢失的整数，将它们以数组的形式返回。
 *
 * 示例 1:
 * 输入: nums = [1,2,2,4]
 * 输出: [2,3]
 *
 */
public class X_645_错误的集合 {

    public int[] findErrorNums(int[] nums) {
        for (int i = 0;i < nums.length;i++) {
            //nums[nums[i]-1] -->正常的2
            //num[i] -->异常的2
            //加这句的原因是防止死循环
            while (nums[i] != i+1 && nums[nums[i] - 1] != nums[i]) {
                swap(nums, nums[i]-1, i);
            }
        }

        for (int i = 0;i < nums.length;i++) {
            if (nums[i] != i+1) {
                return new int[]{nums[i], i+1};
            }
        }

        return new int[]{};
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}