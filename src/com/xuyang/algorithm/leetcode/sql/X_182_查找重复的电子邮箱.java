package com.xuyang.algorithm.leetcode.sql;

/**
 * @Auther: allanyang
 * @Date: 2019/11/10 14:17
 * @Description:
 *
 * Create table If Not Exists Person (Id int, Email varchar(255))
 * Truncate table Person
 * insert into Person (Id, Email) values ('1', 'a@b.com')
 * insert into Person (Id, Email) values ('2', 'c@d.com')
 * insert into Person (Id, Email) values ('3', 'a@b.com')
 *
 * 编写一个 SQL 查询，查找 Person 表中所有重复的电子邮箱。
 *
 * 示例：
 *
 * +----+---------+
 * | Id | Email   |
 * +----+---------+
 * | 1  | a@b.com |
 * | 2  | c@d.com |
 * | 3  | a@b.com |
 * +----+---------+
 * 根据以上输入，你的查询应返回以下结果：
 *
 * +---------+
 * | Email   |
 * +---------+
 * | a@b.com |
 * +---------+
 *
 */
public class X_182_查找重复的电子邮箱 {

    /**
     * ---------------------------------------------------
     */
    /*select
    t.Email
    from
            (
                    select
                            Email, count(Email) num
    from
            Person
    group by
    Email
    ) as t
    where
    num > 1;*/
    /**
     * ---------------------------------------------------
     */
/*    select
            Email
    from
            Person
    group by
    Email
            having
    count(Email) > 1;*/
    /**
     * ---------------------------------------------------
     */

}