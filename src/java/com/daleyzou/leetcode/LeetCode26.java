package com.daleyzou.leetcode;

/**
 * @Author: DaleyZou
 * @Description:
 * @Date: Created in 14:20 2018-8-8
 * @Modified By:
 */
public class LeetCode26 {

    public int removeDuplicates(int[] nums) {
        if (nums.length <= 1){
            return nums.length;
        }
        int begin = 0;
        int temp = nums[0];
        for (int i = 1; i < nums.length; i++){
            if (nums[i] > temp){
                nums[++begin] = nums[i];
                temp = nums[begin];
            }

        }

        return begin + 1;
    }

    public static void main(String[] args) {
        LeetCode26 leetCode26 = new LeetCode26();
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        int[] nums1 = {1,1,2};
        int[] nums2 = {1,2};
        //leetCode26.removeDuplicates(nums);
        int begin = leetCode26.removeDuplicates(nums2);

        for (int i = 0; i < begin; i++){
            System.out.print(nums2[i] + " ");
        }

    }
}
