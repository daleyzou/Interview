package com.daleyzou.CodeOffer;

/**
 * @Author: DaleyZou
 * @Description: 跳台阶
 *  一只青蛙一次可以跳上1级台阶，也可以跳上2级。
 *  求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 * @Date: Created in 15:26 2019/3/3
 * @Modified By:
 */
public class JumpFloor_8 {
    /**
     * @Description: 不推荐使用这种方法，递归消耗内存
     * @param: target
     * @return: int
     */
    public int JumpFloor(int target) {

        if (target == 1){
            return 1;
        }
        if (target == 2){
            return 2;
        }

        return JumpFloor(target - 1) + JumpFloor(target - 2);
    }

    /**
     * @Description:  推荐使用这种方法 （速度快、内存消耗小）
     * @param: n
     * @return: int
     */
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
}
