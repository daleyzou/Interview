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

        return null;
    }

    // 使用动态规划法
    public String longestPalindrome_reconstructure3(String s) { // 第三次对代码进行重构
        if (s.length() < 2) { // 单个字符肯定是回文串，直接返回s
            return s;
        }

        return null;
    }

    public static void main(String[] args){
        LeetCode5 leetCode5 = new LeetCode5();
        String s = "ba";
        //String t = s.substring(0, 1);
        System.out.println(s.substring(0,1));

        //System.out.println(isPalindrome(s));
    }
}
