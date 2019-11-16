package com.xuyang.algorithm.offer;

/**
 * @Auther: allanyang
 * @Date: 2019/11/16 15:49
 * @Description:
 *
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 */
public class O_23_二叉搜索树的后序遍历序列 {

    public boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence == null || sequence.length == 0) {
            return false;
        }

        return process(sequence, 0, sequence.length-1);
    }

    private boolean process(int[] arr, int left, int right) {
        if (left >= right) {
            return true;
        }
        int i = right;
        int root = arr[right];
        while (i > left && arr[i-1] > root) {
            i--;
        }

        for (int j = left;j < i;j++) {
            if (arr[j] >= root) {
                return false;
            }
        }

        return process(arr, left, i-1) && process(arr,i,right-1);
    }
}