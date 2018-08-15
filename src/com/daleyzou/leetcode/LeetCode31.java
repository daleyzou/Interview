package com.daleyzou.leetcode;

import java.util.Arrays;

/**
 * @Author: DaleyZou
 * @Description:
 * @Date: Created in 7:29 2018/8/15
 * @Modified By:
 */
public class LeetCode31 {
    public void nextPermutation(int[] nums) {
        if (nums.length < 2){
            return;
        }
        int maxNum = 0;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] > nums[maxNum]){
                maxNum = i;
            }
        }
        if (maxNum == 0){
            Arrays.sort(nums);
        }else{
            int temp = nums[maxNum];
            nums[maxNum] = nums[maxNum - 1];
            nums[maxNum - 1] = temp;
        }
    }

}
