package com.daleyzou.leetcode;

/**
 * @Author: DaleyZou
 * @Description:
 * @Date: Created in 14:52 2018-8-8
 * @Modified By:
 */
public class LeetCode27 {

    public int removeElement(int[] nums, int val) {
        if (nums.length == 0){
            return nums.length;
        }
        if (nums.length == 1 && nums[0] == val){
            return 0;
        }
        int begin = 0;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] != val){
                nums[begin++] = nums[i];
            }

        }
        return begin;
    }

    public static void main(String[] args) {
        LeetCode27 leetCode27 = new LeetCode27();

        int[] nums1 = {0,0,1,1,1,2,2,3,3,4};
        int[] nums = {0,1,2,2,3,0,4,2};
        int begin = leetCode27.removeElement(nums, 2);
        for (int i = 0; i < begin; i++){
            System.out.print(nums[i] + " ");
        }
    }
}
