package com.xuyang.algorithm.offer;

import java.util.ArrayList;

/**
 * @Auther: allanyang
 * @Date: 2019/11/18 19:18
 * @Description:
 *
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 */
public class O_27_字符串的排列 {

    public ArrayList<String> Permutation(String str) {
        if (str.length() == 0) {
            return new ArrayList<String>();
        }

        ArrayList<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        boolean[] flag = new boolean[str.length()];
        process(str, res, sb, flag);

        return res;
    }

    private void process(String str, ArrayList<String> res, StringBuilder sb, boolean[] flag) {
        if(sb.length() == str.length()) {
            res.add(sb.toString());
            return ;
        }

        for (int i = 0;i < str.length();i++) {
            if (flag[i]) {
                continue;
            }
            if (i > 0 && str.charAt(i) == str.charAt(i-1) && !flag[i-1]) {
                continue;
            }

            flag[i] = true;
            sb.append(str.charAt(i));
            process(str, res, sb, flag);
            sb.deleteCharAt(sb.length()-1);
            flag[i] = false;
        }
    }

    public static void main(String[] args) {
        O_27_字符串的排列 s = new O_27_字符串的排列();
        s.Permutation("ab");
    }
}