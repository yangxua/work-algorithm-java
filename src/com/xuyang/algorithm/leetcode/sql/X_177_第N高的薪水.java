package com.xuyang.algorithm.leetcode.sql;

/**
 * @Auther: allanyang
 * @Date: 2019/11/10 12:40
 * @Description:
 *
 * 编写一个 SQL 查询，获取 Employee 表中第 n 高的薪水（Salary）。
 *
 * +----+--------+
 * | Id | Salary |
 * +----+--------+
 * | 1  | 100    |
 * | 2  | 200    |
 * | 3  | 300    |
 * +----+--------+
 * 例如上述 Employee 表，n = 2 时，应返回第二高的薪水 200。如果不存在第 n 高的薪水，那么查询应返回 null。
 *
 * +------------------------+
 * | getNthHighestSalary(2) |
 * +------------------------+
 * | 200                    |
 * +------------------------+
 *
 */
public class X_177_第N高的薪水 {

    /**
     * -------------------------------------------------------
     */
    /*CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
    BEGIN
    SET N = N-1;
    RETURN (
      # Write your MySQL query statement below.
            SELECT
            DISTINCT salary
            FROM Employee
            order by Salary desc
            LIMIT N, 1
    );
    END*/
    /**
     * -------------------------------------------------------
     */
}