package com.daleyzou.leetcode;

/**
 * @Author: DaleyZou
 * @Description:
 * @Date: Created in 8:48 2018-7-24
 * @Modified By:
 */
public class LeetCode5 {

    /**
     * @Description: 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为1000。
     * @auther: DaleyZou
     * @date: 8:49 2018-7-24 
     * @param: s
     * @return: java.lang.String
     */
    public String longestPalindrome(String s) {
        if (s.length() < 2){
            return s;
        }
        String result = s.substring(0,1);
        String temp = null;
        for (int i = 0; i < s.length(); i++){
            temp = null;
            for (int j = s.length() -1; j > i; j--){
                temp = s.substring(i, j);
                if (isPalindrome(temp)){
                    if (temp.length() > result.length()){
                        result = temp;
                    }
                }
            }
        }

        return result;
    }

    public static boolean isPalindrome(String x) {
        char[] chars = x.toCharArray();
        int i = 0;
        int j = chars.length - 1;
        while (i != j && i < chars.length / 2){
            if (chars[i] == chars[j]){
                i++;
                j--;
            }else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        LeetCode5 leetCode5 = new LeetCode5();
        String s = "bb";
        //String t = s.substring(0, 1);
        System.out.println(leetCode5.longestPalindrome(s));
    }
}
