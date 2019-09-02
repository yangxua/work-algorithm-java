package com.xuyang.algorithm.leetcode;

/**
 * @Auther: allanyang
 * @Date: 2019/8/27 18:24
 * @Description:
 *
 * 给定一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。 找出只出现一次的那两个元素。
 *
 * 示例 :
 * 输入: [1,2,1,3,2,5]
 * 输出: [3,5]
 *
 *
 */
public class X_260_只出现一次的数字III {

    /**
     * 异或之后是两个数相异或，因为不同，所以必定存在某一个位是1，所以根据这位是否是1再次进行分别异或
     * @param nums
     * @return
     */
    public int[] singleNumber(int[] nums) {
        int e0 = 0;
        int e1 = 0;
        int e2 = 0;
        int count = 0;

        for (int num : nums) {
            e0 ^= num;
        }

        while( (e0 & 1) != 1 ) {
            e0 >>= 1;
            count++;
        }

        for (int num : nums) {
            if (((num >> count) & 1) == 1) {
                e1 ^= num;
            } else {
                e2 ^= num;
            }
        }

        return new int[]{e1, e2};
    }
}