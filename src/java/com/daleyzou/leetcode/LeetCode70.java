package com.daleyzou.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: DaleyZou
 * @Description: 70. 爬楼梯
 * @Date: Created in 15:20 2018/12/11
 * @Modified By:
 */
public class LeetCode70 {
    public int climbStairs(int n) {
        int result = 0;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i < n; i++){
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n - 1];
    }

    public static void main(String[] args){
        LeetCode70 leetCode70 =  new LeetCode70();
        int i = leetCode70.climbStairs(3);
        System.out.println(i);
    }
}
