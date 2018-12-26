package com.daleyzou.leetcode;

/**
 * @Author: DaleyZou
 * @Description: 62. 不同路径
 * @Date: Created in 15:00 2018/12/11
 * @Modified By:
 */
public class LeetCode62 {
    /** 代码过于臃肿，有多余代码，可以进行简化 */
    public int uniquePathsOld1(int m, int n) {
        int result = 0;
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++){
            dp[i][0] = 1;
        }
        for (int j = 0; j < n; j++){
            dp[0][j] = 1;
        }

        for (int i = 1; i < m; i++){
            for (int j = 1; j < n; j++){
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        result = dp[m - 1][n - 1];
        return result;
    }
    public int uniquePaths(int m, int n) {
        int result = 0;
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (i == 0 || j == 0){
                    dp[i][j] = 1;
                }else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        result = dp[m - 1][n - 1];
        return result;
    }
}
