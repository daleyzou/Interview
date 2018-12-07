package com.daleyzou.leetcode;

/**
 * @Author: DaleyZou
 * @Description:
 * @Date: Created in 8:57 2018-8-21
 * @Modified By:
 */
public class LeetCode35 {
    public int searchInsert(int[] nums, int target) {
        if (nums.length == 0){
            return 0;
        }
        for (int i = 0; i < nums.length; i++){
            if (nums[i] == target){
                return i;
            }
            if (target < nums[i]){
                if (i == 0){
                    return 0;
                }else {
                    return i;
                }
            }
        }
        return nums.length;
    }
}
