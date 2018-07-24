package com.daleyzou.leetcode;


public class LeetCode1 {

    /**
     * @Description: 给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。
    你可以假设每个输入只对应一种答案，且同样的元素不能被重复利用。
     * @auther: DaleyZou
     * @date: 8:06 2018/7/20
     * @param: nums
     * @param: target
     * @return: int[]
     */
    public static int[] twoSum(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++){
            int temp = target - nums[i];
            for (int j = i + 1; j < nums.length; j++){
                if (nums[j] == temp){
                    int[] returnArray = {i, j};
                    return returnArray;
                }
            }
        }
        return null;
    }

    public static void main(String[] args){
        int[] nums = {2,4,6,8,1};
        int target = 9;
        int[] ints = twoSum(nums, target);
        for (int i = 0; i < ints.length; i++){
            System.out.println(ints[i]);
        }
    }
}