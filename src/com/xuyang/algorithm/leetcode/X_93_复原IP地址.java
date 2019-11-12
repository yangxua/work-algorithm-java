package com.xuyang.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: allanyang
 * @Date: 2019/11/11 16:35
 * @Description:
 *
 * 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
 *
 * 示例:
 * 输入: "25525511135"
 * 输出: ["255.255.11.135", "255.255.111.35"]
 *
 */
public class X_93_复原IP地址 {

    public List<String> restoreIpAddresses(String s) {
        if (s == null || s.length() == 0) {
            return new ArrayList<>();
        }

        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        process(res, sb, s, 0);

        return res;
    }

    private void process(List<String> res, StringBuilder tmpAddr, String s, int k) {
        if (k == 4 || s.length() == 0) {
            if (k == 4 && s.length() == 0) {
                res.add(tmpAddr.toString());
            }
            return ;
        }

        for (int i = 0;i < s.length() && i < 3;i++) {
            if (i != 0 && s.charAt(0) == '0') {
                break;
            }
            String part = s.substring(0, i + 1);
            if (Integer.valueOf(part) <= 255) {
                if (tmpAddr.length() != 0) {
                    part = "." + part;
                }
                tmpAddr.append(part);
                process(res, tmpAddr, s.substring(i+1), k+1);
                tmpAddr.delete(tmpAddr.length() - part.length(), tmpAddr.length());
            }
        }
    }
}