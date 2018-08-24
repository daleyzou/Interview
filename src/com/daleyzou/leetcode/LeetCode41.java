package com.daleyzou.leetcode;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @Author: DaleyZou
 * @Description:
 * @Date: Created in 9:21 2018-8-23
 * @Modified By:
 */
public class LeetCode41 {
    public int firstMissingPositive(int[] nums) {
        if (nums.length == 0){
            return 1;
        }
        int result = 1;
        Arrays.sort(nums);
        int i = 0;
        while (i < nums.length && nums[i] <= 0){
            i++;
        }
        if (i == nums.length){
            if (nums[nums.length - 1] <= 0){
                return 1;
            }else {
                return nums[nums.length - 1] + 1;
            }
        }
        if (nums[i] > 1){
            return 1;
        }
        while (i < nums.length - 1 && nums[i + 1] - nums[i] <= 1){
            i++;
        }
        return nums[i] + 1;
    }

    public int firstMissingPositive_method1(int[] nums) {
        if (nums.length == 0)
            return 1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i+1) {
                int pubNum = nums[i];
                while(pubNum >= 1 && pubNum <= nums.length && pubNum != nums[pubNum-1]) {
                    int tmp = nums[pubNum-1];
                    nums[pubNum-1] = pubNum;
                    pubNum = tmp;
                }
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i+1)
                return i+1;
        }
        return nums.length+1;
    }

    public static void main(String[] args){
        LeetCode41 leetCode41 = new LeetCode41();
        int[] candidates = {1,1,2,2,2,9,8,7,76,84,54,45};
        int i = leetCode41.firstMissingPositive(candidates);
        System.out.println(i);
    }

}
