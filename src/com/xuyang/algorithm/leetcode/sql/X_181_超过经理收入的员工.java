package com.xuyang.algorithm.leetcode.sql;

/**
 * @Auther: allanyang
 * @Date: 2019/11/10 14:03
 * @Description:
 *
 * Create table If Not Exists Employee (Id int, Name varchar(255), Salary int, ManagerId int)
 * Truncate table Employee
 * insert into Employee (Id, Name, Salary, ManagerId) values ('1', 'Joe', '70000', '3')
 * insert into Employee (Id, Name, Salary, ManagerId) values ('2', 'Henry', '80000', '4')
 * insert into Employee (Id, Name, Salary, ManagerId) values ('3', 'Sam', '60000', 'None')
 * insert into Employee (Id, Name, Salary, ManagerId) values ('4', 'Max', '90000', 'None')
 *
 *
 * Employee 表包含所有员工，他们的经理也属于员工。每个员工都有一个 Id，此外还有一列对应员工的经理的 Id。
 *
 * +----+-------+--------+-----------+
 * | Id | Name  | Salary | ManagerId |
 * +----+-------+--------+-----------+
 * | 1  | Joe   | 70000  | 3         |
 * | 2  | Henry | 80000  | 4         |
 * | 3  | Sam   | 60000  | NULL      |
 * | 4  | Max   | 90000  | NULL      |
 * +----+-------+--------+-----------+
 * 给定 Employee 表，编写一个 SQL 查询，该查询可以获取收入超过他们经理的员工的姓名。在上面的表格中，Joe 是唯一一个收入超过他的经理的员工。
 *
 * +----------+
 * | Employee |
 * +----------+
 * | Joe      |
 * +----------+
 *
 */
public class X_181_超过经理收入的员工 {

    /**
     * -------------------------------------------
     */
    /*select
    t1.name as Employee
    from Employee t1
    left join Employee t2
    on t1.ManagerId = t2.id
    where t1.salary > t2.salary;*/
    /**
     * -------------------------------------------
     */
}