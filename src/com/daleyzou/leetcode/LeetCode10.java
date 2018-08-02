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
        if (p.equals(".*")){
            return true;
        }
        if (s == null || p == null){
            return false;  // 如果字符串或者模式是空的，那么肯定没有匹配的
        }
        int strIndex = 0, patternIndex = 0;                 // 从字符串和模式的第一位开始进行匹配
        return matchChar(s, strIndex, p, patternIndex);
    }
    /**
     当模式中的下一个字符不是”*”时：
     - 如果字符串当前字符和模式中的当前字符相匹配，那么字符串指针和模式指针都后移一个字符，然后匹配剩余的。
     - 如果字符串当前字符和模式中当前字符不匹配，直接返回false。

     当模式中的下一个是”*”时：
     如果字符串当前字符跟模式当前字符不匹配，则模式指针后移2个字符，继续匹配。

     如果字符串当前字符跟模式当前字符匹配，可以有3种匹配方式：
     1、模式指针后移2字符，相当于x*被忽略；
     2、字符串指针后移1字符，模式指针后移2字符；
     3、字符串指针后移1字符，模式不变，即继续匹配字符下一位，因为*可以匹配多位；
     */
    public boolean matchChar(String str, int strIndex, String pattern, int patternIndex){

        if (strIndex == str.length() && patternIndex == pattern.length()){  // 字符串和模式同时都到末尾
            return true;
        }
        if (strIndex != str.length() && patternIndex == pattern.length()){  // 模式先到末尾
            return false;
        }
        if (patternIndex + 1 < pattern.length() && pattern.charAt(patternIndex + 1) == '*'){  // 下一个字符是*
            if ((strIndex != str.length() && str.charAt(strIndex) == pattern.charAt(patternIndex)) ||
                    (strIndex != str.length() && pattern.charAt(patternIndex) == '.') ){
                return matchChar(str, strIndex, pattern, patternIndex + 2) ||
                        matchChar(str, strIndex + 1, pattern, patternIndex + 2) ||
                        matchChar(str, strIndex + 1, pattern, patternIndex);
            }else {
                return matchChar(str, strIndex, pattern, patternIndex + 2);
            }
        }else if ((strIndex != str.length() && str.charAt(strIndex) == pattern.charAt(patternIndex)) ||
                (strIndex != str.length() && pattern.charAt(patternIndex) == '.')){
            // 下一个字符不是*，字符串当前字符和模式中的当前字符相匹配
            return matchChar(str, strIndex + 1, pattern, patternIndex + 1);
        }
        return false;
    }

    public static void main(String[] args){

        LeetCode10 leetCode10 = new LeetCode10();
        String str = "";
        str.toCharArray();

        System.out.println(leetCode10.isMatch("aa","aa*"));
        System.out.println(leetCode10.isMatch("aa","a*"));
        System.out.println(leetCode10.isMatch("aaa","ab*b*ac*a"));
        System.out.println(leetCode10.isMatch("aa","a"));
    }
}
