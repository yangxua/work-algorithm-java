package com.xuyang.algorithm.leetcode;

/**
 * @Auther: allanyang
 * @Date: 2019/9/3 15:22
 * @Description:
 *
 * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。
 *
 * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 * 你可以假设数组中的所有字符都是 ASCII 码表中的可打印字符。
 *  
 * 示例 1：
 * 输入：["h","e","l","l","o"]
 * 输出：["o","l","l","e","h"]
 *        0   1   2   3   4
 * 示例 2：
 * 输入：["H","a","n","n","a","h"]
 * 输出：["h","a","n","n","a","H"]
 *
 */
public class X_344_反转字符串 {

    /**
     * 迭代
     */
    public void reverseString(char[] s) {
        if (s.length <= 1) {
            return ;
        }

        for (int i = 0;i <= (s.length-1)/2;i++) {
            swap(s, i, s.length-1-i);
        }
    }

    private void swap(char[] arr, int i, int j) {
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    /**
     * 递归
     *
     * 压栈会使用O（lgn）的额外空间，其实题目是不允许的
     */
    public void reverseString1(char[] s) {
        if (s.length <= 1) {
            return ;
        }

        process(s, 0, s.length-1);
    }

    private void process(char[] arr, int left, int right) {
        if (left >= right) {
            return ;
        }
        swap(arr, left, right);
        process(arr,left+1,right-1);
    }
}