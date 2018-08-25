package com.daleyzou.leetcode;

/**
 * @Author: DaleyZou
 * @Description:
 * @Date: Created in 10:51 2018-8-24
 * @Modified By:
 */
public class LeetCode44 {
    /**
     '?' 可以匹配任何单个字符。
     '*' 可以匹配任意字符串（包括空字符串）。
     */
    /**
     * 原来用了动态规划
     *
     * 最难的就是列出状态方程了
     *
     模式当前字符是*：
        dp[i+1][j+1] = dp[i][J+1] || dp[i+1][j]

     模式当前字符不是*：
     dp[i+1][j+1] = dp[i][j] && s.charAt(i) == p.charAt(j)

     */

    // 不错的博客：https://www.cnblogs.com/ariel-dreamland/p/9139523.html
    public boolean isMatch(String s, String p) {

        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        // 开始初始化填充,如果匹配的串s是空的的话，只有模式是*才能匹配
        for (int i = 0; i < p.length(); i++){
            if (dp[0][i] && p.charAt(i) == '*'){
                dp[0][i + 1] = true;
            }
        }

        // 开始动态规划
        for (int i = 0; i < s.length(); i++){
            for (int j = 0; j < p.length(); j++){
                if (p.charAt(j) == '*'){
                    dp[i + 1][j + 1] = dp[i][j+1] || dp[i+1][j];
                }else if (p.charAt(j) == '?' || s.charAt(i) == p.charAt(j)){
                    dp[i + 1][j + 1] = dp[i][j];
                }
            }
        }
        return dp[s.length()][p.length()];
    }

    // 使用贪婪算法进行求解
    public boolean isMatch_greed(String s, String p) {

        return false;
    }
}
