package com.xuyang.algorithm.leetcode.sql;

/**
 * @Auther: allanyang
 * @Date: 2019/11/10 13:20
 * @Description:
 *
 * Create table If Not Exists Scores (Id int, Score DECIMAL(3,2))
 * Truncate table Scores
 * insert into Scores (Id, Score) values ('1', '3.5')
 * insert into Scores (Id, Score) values ('2', '3.65')
 * insert into Scores (Id, Score) values ('3', '4.0')
 * insert into Scores (Id, Score) values ('4', '3.85')
 * insert into Scores (Id, Score) values ('5', '4.0')
 * insert into Scores (Id, Score) values ('6', '3.65')
 *
 *
 * 编写一个 SQL 查询来实现分数排名。如果两个分数相同，则两个分数排名（Rank）相同。请注意，平分后的下一个名次应该是下一个连续的整数值。换句话说，名次之间不应该有“间隔”。
 *
 * +----+-------+
 * | Id | Score |
 * +----+-------+
 * | 1  | 3.50  |
 * | 2  | 3.65  |
 * | 3  | 4.00  |
 * | 4  | 3.85  |
 * | 5  | 4.00  |
 * | 6  | 3.65  |
 * +----+-------+
 * 例如，根据上述给定的 Scores 表，你的查询应该返回（按分数从高到低排列）：
 *
 * +-------+------+
 * | Score | Rank |
 * +-------+------+
 * | 4.00  | 1    |
 * | 4.00  | 1    |
 * | 3.85  | 2    |
 * | 3.65  | 3    |
 * | 3.65  | 3    |
 * | 3.50  | 4    |
 * +-------+------+
 *
 */
public class X_178_分数排名 {

    /**
     * ------------------------------------------------------------------------
     */
  /*  select score,
    (select count(Distinct score) from Scores s where score >= t.score) as RANK
    from Scores t
    order by Score desc;*/
    /**
     * ------------------------------------------------------------------------
     */
}