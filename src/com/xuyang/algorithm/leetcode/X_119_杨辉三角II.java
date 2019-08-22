package com.xuyang.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: allanyang
 * @Date: 2019/8/22 17:26
 * @Description:
 *
 * 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
 *
 * 输入: 3
 * 输出: [1,3,3,1]
 *
 * -------------------------------------
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 *
 */
public class X_119_杨辉三角II {

    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>();

        for (int i = 0;i <= rowIndex;i++) {
            row.add(0, 1);
            for (int j = 1; j < row.size()-1; j++) {
                row.set(j, row.get(j) + row.get(j+1));
            }
        }

        return row;
    }
}