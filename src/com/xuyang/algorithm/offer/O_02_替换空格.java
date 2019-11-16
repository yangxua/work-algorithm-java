package com.xuyang.algorithm.offer;

/**
 * @Auther: allanyang
 * @Date: 2019/11/16 11:06
 * @Description:
 *
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 */
public class O_02_替换空格 {


    public String replaceSpace(StringBuffer str) {
        if (str.length() == 0) {
            return "";
        }

        int spaceCount = 0;
        char[] c = str.toString().toCharArray();
        for (int i = 0;i < c.length;i++) {
            if (c[i] == ' ') {
                spaceCount++;
            }
        }

        char[] cNew = new char[c.length+spaceCount*2];
        int index = cNew.length-1;
        for (int i = c.length-1;i >= 0;i--) {
            if (c[i] == ' ') {
                cNew[index--] = '0';
                cNew[index--] = '2';
                cNew[index--] = '%';
            } else {
                cNew[index--] = c[i];
            }
        }

        return new String(cNew);
    }
}