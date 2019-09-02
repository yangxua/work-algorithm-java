package com.xuyang.algorithm.leetcode;

/**
 * @Auther: allanyang
 * @Date: 2019/8/27 17:14
 * @Description:
 *
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *
 * 说明：
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 *
 * 示例 1:
 * 输入: [2,2,1]
 * 输出: 1
 *
 * 示例 2:
 * 输入: [4,1,2,1,2]
 * 输出: 4
 *
 */
public class X_136_只出现一次的数字 {

    /**
     * 1.map方法
     * 把每个数存入map中，如果不存在则放入，存在则移除，最后map中的那个元素就是所求解（不提供具体代码）
     *
     * 2.位运算
     * a ^ a = 0;  ---->所有出现偶数次的都变成0
     * 0 ^ a = a;  ---->所有出现奇数次的都变成本身
     */
    public int singleNumber(int[] nums) {
        int res = 0;

        for (int num : nums) {
            res ^= num;
        }

        return res;
    }

}