package com.daleyzou.Test;

/**
 * @Author: DaleyZou
 * @Description:
 * 输入一个整型数组，子数组为这个数组中连续的一个或者多个整数组成的数组。
 * 求所有子数组中的和的最大值。要求时间复杂度为O(n)。例如，输入
 * 数组为[1, -3, 9, 10, -2, 3, -6, 5]。
 * 和最大的子数组为 [9, 10, -2, 3]，因此输出为该子数组的和20。
 * @Date: Created in 20:43 2018/11/6
 * @Modified By:
 */
public class MaxSubArray {
    public int getMaxSubArraySum(int[] nums){
        int result = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++){
            sum += nums[i];
            if (sum <= 0){
                i++;                        // 移动到下一位，忽略当前所加的极大的负数
                if (i < nums.length){       // 防止数组访问越界
                    sum = nums[i];
                }
            }
            if (sum > result){
                result = sum;
            }
        }
        return result;
    }

    public static void main(String[] args){
        MaxSubArray maxSubArray = new MaxSubArray();

        int[] nums = new int[]{1, -3, 9, 10, -2, 3, -6, 5};
        int result = maxSubArray.getMaxSubArraySum(nums);
        System.out.println(result);
    }
}
