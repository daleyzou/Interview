package com.daleyzou.Test;

import java.util.Arrays;

/**
 * @Author: DaleyZou
 * @Description: 在空间复杂度为1的情况下反转数组
 * 请实现一个算法可以将任一给定的数组元素反转，
 * 如给定数组 [1, 3, 5, 2, 6] 输出为 [6, 2, 5, 3, 1]，要求O(1) 的空间复杂度。
 * @Date: Created in 17:56 2018/11/6
 * @Modified By:
 */
public class ReverseNum {
    public static void main(String[] args){
        int[] nums = new int[]{1, 3, 5, 2, 6, 8};
        int temp = 0;
        for (int i = 0; i < nums.length / 2; i++){
            temp = nums[i];
            nums[i] = nums[nums.length - i - 1];
            nums[nums.length - i - 1] = temp;
        }
        Arrays.stream(nums).forEach((i)-> System.out.print(i+" "));
    }
}
