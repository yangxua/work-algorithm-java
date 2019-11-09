package com.xuyang.algorithm.sort.impls;

import com.xuyang.algorithm.sort.AbstractSort;

/**
 * @Auther: allanyang
 * @Date: 2019/11/6 15:42
 * @Description:
 */
public class HeapSort<T extends Comparable<T>> extends AbstractSort<T> {

    /**
     * 堆排序：首先从一般开始下沉，然后把大顶堆和数组最后元素交换。然后再次建堆
     * 稳定性: 不稳定
     * 时间复杂度：O（N*lgN）
     * 空间复杂度：O（1）
     * 现代操作系统很少使用堆排序，因为他无法利用局部性原理进行缓存，也就是数组元素很少和相邻的元素进行比较和交换.
     *
     *
     * 建堆的时间复杂度:O(N) , 一定要采取下沉操作才能O(N)
     * 证明:
     * 建堆复杂度先考虑满二叉树，计算完全二叉树建堆复杂度基本相同。
     * 对满二叉树而言，第i层(根为第0层)有2^i个节点。由于建堆过程自底向上，以交换作为主要操作，因此第i层任意节点在最不利情况下，需要经过(n-i)次交换操作才能完成以该节点为堆根节点的建堆过程。因此，时间复杂度计算如下：
     *
     * T(n) = 2^0 * (n - 0) + 2^1 * (n - 1) + ... + 2^n * (n - n) = sum((n - i) * 2^i)
     *
     * 采用错位相减法：
     *
     * 原式乘2得：
     * T(n) * 2 = 2^1 * (n - 0) + 2^2 * (n - 1) + ... + 2^(n+1) * (n - n)
     * = sum((n - i) * 2^(i+1))
     * 原式如下：
     * T(n) = 2^0 * (n - 0) + 2^1 * (n - 1) + ... + 2^n * (n - n)
     * = sum((n - i) * 2^i)
     * 相减得：
     * 2T(n) - T(n) = -n + 2^1 + 2^2 + ... + 2^n = 2 * (1 - 2^n) / (1 - 2) - n
     * = 2^(n+1) - 2 - n
     * 上面推导中，n为层数编号（自0层根节点开始）。故总节点数为(1 + 2 + 4 + ... + 2^n) = 2^(n+1) - 1。渐进时，忽略减1取N ＝ 2^(n+1)。
     *
     * T(N) = 2^(n+1) - n - 2 = N * (1 - logN / N - 2 / N) ≈ N
     *
     * 故时间复杂度为O(N)，得证。
     */
    @Override
    protected void doSort(T[] nums) {
        int n = nums.length-1;

        for (int i = n / 2;i >= 1;i--) {
            sink(nums, i, n);
        }

        while (1 < n) {
            swap(nums, 0, n--);
            sink(nums, 0, n);
        }
    }

    private void sink(T[] nums, int k, int n) {
        while (2 * k <= n) {
            int j = 2 * n;
            if (j < n && less(nums, j, j+1)) {
                j++;
            }
            if (!less(nums, k, j)) {
                break;
            }

            swap(nums, k, j);
            k = j;
        }
    }

    private boolean less(T[] nums, int i, int j) {
        return nums[i].compareTo(nums[j]) < 0;
    }

}