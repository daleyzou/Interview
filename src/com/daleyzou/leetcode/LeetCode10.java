package com.daleyzou.leetcode;

/**
 * @Author: DaleyZou
 * @Description:
 * @Date: Created in 8:12 2018/7/25
 * @Modified By:
 */
public class LeetCode10 {

    /**
     * @Description: 给定一个字符串 (s) 和一个字符模式 (p)。实现支持 '.' 和 '*' 的正则表达式匹配。

    '.' 匹配任意单个字符。
    '*' 匹配零个或多个前面的元素。
    匹配应该覆盖整个字符串 (s) ，而不是部分字符串。

    说明:

    s 可能为空，且只包含从 a-z 的小写字母。
    p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
     * @auther: DaleyZou
     * @date: 8:13 2018/7/25 
     * @param: s
     * @param: p
     * @return: boolean
     */
    // 参考博客：https://blog.csdn.net/m0_37674257/article/details/71750979
    public boolean isMatch(String s, String p) {
        String reg = p;
        if (reg.equals(".*")){
            return true;
        }
        return false;
    }

    public static void main(String[] args){
        System.out.println();
    }
}
