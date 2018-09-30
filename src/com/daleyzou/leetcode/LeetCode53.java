package com.daleyzou.leetcode;

/**
 * @Author: DaleyZou
 * @Description:  53. 最大子序和
 * @Date: Created in 21:02 2018-9-29
 * @Modified By:
 */
public class LeetCode53 {
    public int maxSubArray(int[] nums) {
        int result = nums[0];
        int temp = nums[0];
        for (int i = 1; i < nums.length; i++){
            if (temp < 0){
                temp = nums[i];
            }else {
                temp += nums[i];
            }

            result = Math.max(result, temp);
        }
        return result;
    }

    public static void main(String[] args){
        LeetCode53 leetCode53 = new LeetCode53();
        int[] nums = {2,3,4,45,5-6,-3,10};

        int result = leetCode53.maxSubArray(nums);

        System.out.println(result);
    }

}
