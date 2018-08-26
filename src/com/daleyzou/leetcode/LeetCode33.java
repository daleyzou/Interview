package com.daleyzou.leetcode;

/**
 * @Author: DaleyZou
 * @Description:
 * @Date: Created in 20:02 2018-8-20
 * @Modified By:
 */
public class LeetCode33 {

    /**
     * @Description: 没有写出来
     *                 参考链接：https://mp.weixin.qq.com/s/rpOqIhHHA6C3pozlr3CSsQ
     * @auther: DaleyZou
     * @date: 20:22 2018-8-20
     * @param: nums
     * @param: target
     * @return: int
     */
    public int search(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        while (start <= end){
            int mid = (start + end) / 2;
            if (target == nums[mid]){
                return mid;
            }
            if (nums[mid] < nums[end]){  // 右边有序
                if (nums[mid] < target && target <= nums[end]){
                    start = mid + 1;
                }else {
                    end = mid - 1;
                }
            }else {                     // 左边有序
                if (nums[start] <= target && target < nums[mid]){
                    end = mid - 1;
                }else {
                    start = mid + 1;
                }
            }
        }
        return -1;
    }
}
