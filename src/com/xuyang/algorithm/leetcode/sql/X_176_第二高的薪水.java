package com.xuyang.algorithm.leetcode.sql;

/**
 * @Auther: allanyang
 * @Date: 2019/11/10 12:10
 * @Description:
 *
 * Create table If Not Exists Employee (Id int, Salary int)
 * Truncate table Employee
 * insert into Employee (Id, Salary) values ('1', '100')
 * insert into Employee (Id, Salary) values ('2', '200')
 * insert into Employee (Id, Salary) values ('3', '300')
 *
 * 编写一个 SQL 查询，获取 Employee 表中第二高的薪水（Salary） 。
 *
 * +----+--------+
 * | Id | Salary |
 * +----+--------+
 * | 1  | 100    |
 * | 2  | 200    |
 * | 3  | 300    |
 * +----+--------+
 * 例如上述 Employee 表，SQL查询应该返回 200 作为第二高的薪水。如果不存在第二高的薪水，那么查询应返回 null。
 *
 * +---------------------+
 * | SecondHighestSalary |
 * +---------------------+
 * | 200                 |
 * +---------------------+
 *
 *
 */
public class X_176_第二高的薪水 {

    /**
     * -------------------------------------------------
     */
    /*SELECT
            (SELECT
                     DISTINCT Salary
                     FROM Employee
                     order by Salary desc
                     LIMIT 1,1) as SecondHighestSalary;*/
    /**
     * -------------------------------------------------
     */



}