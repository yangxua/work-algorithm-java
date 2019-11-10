package com.xuyang.algorithm.leetcode.sql;

/**
 * @Auther: allanyang
 * @Date: 2019/11/10 11:55
 * @Description:
 *
 * Create table Person (PersonId int, FirstName varchar(255), LastName varchar(255))
 * Create table Address (AddressId int, PersonId int, City varchar(255), State varchar(255))
 * Truncate table Person
 * insert into Person (PersonId, LastName, FirstName) values ('1', 'Wang', 'Allen')
 * Truncate table Address
 * insert into Address (AddressId, PersonId, City, State) values ('1', '2', 'New York City', 'New York')
 *
 *
 * 表1: Person
 *
 * +-------------+---------+
 * | 列名         | 类型     |
 * +-------------+---------+
 * | PersonId    | int     |
 * | FirstName   | varchar |
 * | LastName    | varchar |
 * +-------------+---------+
 * PersonId 是上表主键
 * 表2: Address
 *
 * +-------------+---------+
 * | 列名         | 类型    |
 * +-------------+---------+
 * | AddressId   | int     |
 * | PersonId    | int     |
 * | City        | varchar |
 * | State       | varchar |
 * +-------------+---------+
 * AddressId 是上表主键
 *
 *
 * 编写一个 SQL 查询，满足条件：无论 person 是否有地址信息，都需要基于上述两表提供 person 的以下信息：
 *
 * FirstName, LastName, City, State
 */
public class X_175_组合两个表 {

    //select  t1.FirstName, t1.LastName, t2.City, t2.State from Person t1 left join Address t2 on t1.PersonId = t2.PersonId;


    //select FirstName, LastName,
    //(select City from Address where Person.PersonId = Address.PersonId) as City,
    //(select State from Address where Person.PersonId = Address.PersonId) as State
    // from Person;
}