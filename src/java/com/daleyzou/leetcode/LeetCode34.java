package com.daleyzou.leetcode;

/**
 * @Author: DaleyZou
 * @Description:
 * @Date: Created in 20:59 2018-8-20
 * @Modified By:
 */
public class LeetCode34 {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = -1;
        result[1] = -1;
        if (nums == null || nums.length == 0){
            return result;
        }
        int start = 0, end = nums.length - 1;
        if (nums[start] <= target && target <= nums[end]) {
            while (start <= end){
                int mid = (start + end) / 2;
                if (target == nums[mid]){
                    int i = mid - 1;
                    int j = mid + 1;
                    while (i >= 0 && nums[i] == target){
                        i--;
                    }
                    while (j <= nums.length - 1 && nums[j] == target){
                        j++;
                    }
                    result[0] = i + 1;
                    result[1] = j - 1;
                    return result;
                }else if (target > nums[mid]){
                    start = mid + 1;
                }else {
                    end = mid - 1;
                }
            }
        }else {
            return result;
        }
        return result;
    }
}
