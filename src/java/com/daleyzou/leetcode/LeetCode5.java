package com.daleyzou.leetcode;

import java.util.Arrays;

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
    public String longestPalindrome(String s) {  // 这个方法超出了时间限制
        if (s.length() < 2){
            return s;
        }
        String result = s.substring(0,1);
        String temp = null;
        for (int i = 0; i < s.length(); i++){
            temp = null;
            for (int j = s.length(); j > i; j--){
                if (result.length() >= (j - i)){
                    break;
                }
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

    public String longestPalindrome_reconstructure1(String s){ // 超出时间限制
        if (s.length() < 2){
            return s;
        }
        String result = s.substring(0,1);
        String temp = null;
        String temp1 = null;
        for(int i = 0; i < s.length() - 1; i++){
            temp = null;
            temp1 = null;
            for (int j = s.length(); j > i; j--){
                if (j - i < result.length()) break;
                temp = s.substring(i, j);
                temp1 = new StringBuilder(temp).reverse().toString(); // 对截取后的字符串进行反转

                if (temp.equals(temp1) && temp.length() > result.length()){
                    result = temp;
                }
            }
        }
        return result;
    }

    // 使用中心扩展算法
    public String longestPalindrome_reconstructure2(String s) { // 第二次对代码进行重构
        if (s.length() < 2) { // 单个字符肯定是回文串，直接返回s
            return s;
        }
        int maxLength = 0;
        int center = 0;
        for (int i = 0; i < s.length(); i++){
            int begin = centerExpand(s, i, i);          // 最长回文串长度为奇数
            int end = centerExpand(s, i, i + 1);   // 最长回文串长度为偶数

            if (maxLength < Math.max(begin, end)){
                center = i;                                // 以center为中心
                maxLength = Math.max(begin, end);          // 最长回文串长度
            }
        }
        // 如果我们的回文串的长度为偶数，那么中心左边的长度会比右边的长度小1
        return s.substring(center - (maxLength - 1) / 2, center + maxLength / 2 + 1);
    }

    int centerExpand(String s, int begin, int end){
        int left = begin, right = end;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        // 返回以begin,end为基准，同时向左向右扩展后能够得到的最长回文串长度
        return right - left - 1;
    }

    // 使用动态规划法
    public String longestPalindrome_reconstructure3(String s) { // 第三次对代码进行重构
        if (s.length() < 2) { // 单个字符肯定是回文串，直接返回s
            return s;
        }
        boolean[][] dp = new boolean[s.length()][s.length()];  // 初始化一个二维数组，值默认是false
        String result = s.substring(0,1);
        for (int j = 0; j < s.length(); j++){
            for (int i = 0; i <= j; i++){
                dp[i][j] = s.charAt(i) == s.charAt(j) &&(j - i <= 2 || dp[i+1][j-1]);
                if (dp[i][j]){
                    if (j - i + 1 > result.length()){
                        result = s.substring(i, j + 1);
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args){
        LeetCode5 leetCode5 = new LeetCode5();
        String s = "aaaaaaaaaa";
        String s1 = "babad";
        String s2 = "bbb";
        String s3 = "abcd";
        String s4 = "cbbd";

        //String t = s.substring(0, 1);
        //System.out.println(s.substring(0,1));
//        System.out.println(leetCode5.longestPalindrome_reconstructure3(s1));
//        System.out.println(leetCode5.longestPalindrome_reconstructure3(s2));
//        System.out.println(leetCode5.longestPalindrome_reconstructure3(s3));
        System.out.println(leetCode5.longestPalindrome_reconstructure3(s4));

        //System.out.println(isPalindrome(s));
    }
}
