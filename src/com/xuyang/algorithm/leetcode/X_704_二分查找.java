package com.xuyang.algorithm.leetcode;

/**
 * @Auther: allanyang
 * @Date: 2019/9/5 14:16
 * @Description: 34题很好的练习二分法
 *
 * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
 *
 * 示例 1:
 * 输入: nums = [-1,0,3,5,9,12], target = 9
 * 输出: 4
 * 解释: 9 出现在 nums 中并且下标为 4
 * 示例 2:
 * 输入: nums = [-1,0,3,5,9,12], target = 2
 * 输出: -1
 * 解释: 2 不存在 nums 中因此返回 -1
 *
 */
public class X_704_二分查找 {

    /**
     * https://leetcode-cn.com/problems/search-insert-position/solution/te-bie-hao-yong-de-er-fen-cha-fa-fa-mo-ban-python-/
     *
     * 二分法模板：
     *          1.考虑left和right取值，因为可以为0，所以left取0，因为不可以取到nums.length但可以渠道nums.length-1，所以right=nums.length-1；（如果类似于leetcode35题的话，right取nums.length）
     *          2.while里面不用考虑，万年固定left<right （终止条件一定是left==right）（如果写了left<=right，则里面的代码不符合模板要求）
     *     （*）3.mid的取值，取左中位数还是右中位数。（左中位数：（mid=left+right）/2    右中位数：（left+right+1）/2）
     *              （注：此处不要判断相等条件，因为会将两个分支转换成三个分支，增加难度，你只需要在循环中止来判断就好了。特殊题除外）
     *              3.1 取左中位数的当只有两个数的时候判断里面包含了left=mid，则死循环。所以取左中位数一定时候，要left=mid+1，right=mid。
     *              3.2 取右中位数的时候，和上面正好相反。如果只有2个数，并且判断中包含right=mid则死循环。所以取右中位数一定要right=mid-1，left=mid.
     *              3.3 对于中间if (nums[mid] 与 target比较) {} else {} 逻辑要根据实际题目自己分析。（详情见leetcode34）
     *                  3.3.1一般选取左中位数，结果会大于等于预期结果，不存在的时候大于
     *                  3.3.2一般选取右中位数，结果会小于等于预期结果，不存在的时候小于
     *          4.中止条件一定是left=right,因为可能出现不存在的情况，因此要判断这个值是否和目标值相等。（如果题中给了必定存在，则不用判断）
     *
     *
     * 取mid值方式：（根据不同题意获取不同的mid值）
     *          左中位数：
     *          1.mid = (left+right)/2； 标准写法，left+right溢出可能溢出
     *          2.mid = left + (right-left)/2; 防止left+right溢出，但right-left可能溢出，left可能为负数。（如果是索引的话可以忽略这点）
     *          3.mid = (left+right)>>>1; 无符号右移，可以解决方法2的缺点。但得到的数肯定是整数，如果left和right相加小于0后获取的也是整数，会有一点问题。
     *
     *          右中位数
     *          4.mid = (left+right+1)/2；
     *          5.mid = left + (right-left+1)/2;
     *          6.mid = (left+right+1)>>>1;
     */
    public int search(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }

        int left = 0;
        int right = nums.length-1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid+1;
            } else {
                right = mid;
            }
        }

        return nums[left] == target ? left : -1;
    }
}