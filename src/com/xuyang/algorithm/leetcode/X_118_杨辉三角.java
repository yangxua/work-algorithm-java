package com.xuyang.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: allanyang
 * @Date: 2019/8/22 17:05
 * @Description: 杨辉三角
 *
 *
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 * 在杨辉三角中，每个数是它左上方和右上方的数的和
 *
 *
 * 输入: 5
 * 输出:
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 *
 */
public class X_118_杨辉三角 {


    /**
     * 迭代法
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> row = new ArrayList<>();

        for (int i = 0;i < numRows;i++) {
            row.add(0,1);//此处会将时间复杂度升高至O（N^2）
            for (int j = 1;j < row.size()-1;j++) {
                row.set(j, row.get(j) + row.get(j+1));
            }
            res.add(new ArrayList<>(row));
        }

        return res;
    }

}