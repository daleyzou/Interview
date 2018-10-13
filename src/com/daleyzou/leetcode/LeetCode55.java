package com.daleyzou.leetcode;

/**
 * @Author: DaleyZou
 * @Description:    55. 跳跃游戏
 * @Date: Created in 14:38 2018-10-12
 * @Modified By:
 */
public class LeetCode55 {
    public boolean canJump(int[] nums) {
        int max = 0;
         for (int i = 0; i < nums.length; i++){
             if (i > max){  // 当前的 i 节点就已经达不到了
                 return false;
             }
             max = Math.max(max, nums[i] + i);
         }
        return true;
    }

    public static void main(String[] args){

    }
}
