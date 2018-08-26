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
        //starj记录上一个"*"的位置
        //match记录与"*"匹配的i的位置(与starj不同的是，每次回溯，match自增)
        int i = 0, j = 0, starj = -1, match = 0;

        while(i < s.length()){
            //字符相等或者p.charAt(j) == '?'
            if(j < p.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?')){
                i++;
                j++;
                //遇到'*', 记录'*'的位置，并记录starj和match
            }else if(j < p.length() && p.charAt(j) == '*'){
                starj = j;
                j++;
                match = i;
                //不是上述两种情况，无法匹配，因此回溯
                //注意，若出现第二个'*'， 会对之前的覆盖，因为已经不需要用之前的"*"进行回溯了
            }else if(starj != -1){
                j = starj + 1;
                match++;
                i = match;
                //其他情况， 直接返回false
            }else{
                return false;
            }
        }
        //清除'*'
        while(j < p.length() && p.charAt(j) == '*') j++;
        //若p清空，说明匹配
        return j == p.length();
    }
}
