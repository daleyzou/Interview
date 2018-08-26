package com.daleyzou.leetcode;

import java.util.Arrays;

/**
 * @Author: DaleyZou
 * @Description:
 * @Date: Created in 7:29 2018/8/15
 * @Modified By:
 */
public class LeetCode31 {
    /**
     * @Description:   这道题重要的是理解字典序算法，链接：https://www.cnblogs.com/darklights/p/5285598.html#4044610
     * @auther: DaleyZou
     * @date: 16:54 2018-8-20
     * @param: nums
     * @return: void
     */
    public void nextPermutation(int[] nums) {
        if (nums.length < 2){
            return;
        }
        int maxNum = 0;
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]){ // 从右到左找到第一个左邻小于右邻的数，nums[i]
            i--;
        }
        if (i < 0){    // 数组已经是全部从大到小排序了
            Arrays.sort(nums);
            return;
        }

        int temp = nums[i];
        int j = nums.length - 1;
        while (j > i && nums[j] <= temp){    // 从nums.length到maxNum，从右到左找到第一个比nums[i]大的数：nums[j]
            j--;
        }

        // 交换i和j的值
        nums[i] = nums[j];
        nums[j] = temp;

        Arrays.sort(nums,i+1, nums.length);
    }

}
