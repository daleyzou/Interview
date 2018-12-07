package com.daleyzou.leetcode;

/**
 * @Author: DaleyZou
 * @Description:
 *
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 *
 * 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
 *
 * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
 * @Date: Created in 16:20 2018-8-3
 * @Modified By:
 */
public class LeetCode16 {

    public int threeSumClosest(int[] nums, int target) {
        int result = nums[0] + nums[1] + nums[2];
        int temp = Math.abs(result - target);
        for (int i = 0; i < nums.length - 2; i++){
            for (int j = i + 1; j < nums.length - 1; j++){
                for (int k = j + 1; k < nums.length; k++){
                    int value = Math.abs(nums[i] + nums[j] + nums[k] - target);
                    if (value < temp){
                        result = nums[i] + nums[j] + nums[k];
                        temp = value;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args){
        LeetCode16 leetCode16 = new LeetCode16();

        System.out.println();
    }
}
