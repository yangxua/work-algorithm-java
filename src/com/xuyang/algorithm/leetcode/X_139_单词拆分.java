package com.xuyang.algorithm.leetcode;

import java.util.Arrays;
import java.util.List;

/**
 * @Auther: allanyang
 * @Date: 2019/11/14 20:02
 * @Description:
 *
 * 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
 *
 * 说明：
 *
 * 拆分时可以重复使用字典中的单词。
 * 你可以假设字典中没有重复的单词。
 * 示例 1：
 * 输入: s = "leetcode", wordDict = ["leet", "code"]
 * 输出: true
 * 解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
 * 示例 2：
 * 输入: s = "applepenapple", wordDict = ["apple", "pen"]
 * 输出: true
 * 解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
 *      注意你可以重复使用字典中的单词。
 * 示例 3：
 * 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * 输出: false
 *
 */
public class X_139_单词拆分 {

    /**
     * s = "leetcode",
     * dict = ["leet", "code"].
     * Return true because "leetcode" can be segmented as "leet code".
     * dict 中的单词没有使用次数的限制，因此这是一个完全背包问题。
     *
     * 该问题涉及到字典中单词的使用顺序，也就是说物品必须按一定顺序放入背包中，例如下面的 dict 就不够组成字符串 "leetcode"：
     *
     * ["lee", "tc", "cod"]
     * 求解顺序的完全背包问题时，对物品的迭代应该放在最里层，对背包的迭代放在外层，只有这样才能让物品按一定顺序放入背包中。
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;

        for (int i = 1;i <= s.length();i++) {
            for (int j = 1;j <= wordDict.size();j++) {
                String word = wordDict.get(j - 1);
                if (i >= word.length() && word.equals(s.substring(i-word.length(), i))) {
                    dp[i] |= dp[i-word.length()];
                }
            }
        }

        return dp[s.length()];
    }

    public static void main(String[] args) {
        X_139_单词拆分 s = new X_139_单词拆分();
        s.wordBreak("leetcode", Arrays.asList("leet", "code"));
    }
}