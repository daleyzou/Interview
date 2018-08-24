package com.daleyzou.leetcode;

/**
 * @Author: DaleyZou
 * @Description:
 * @Date: Created in 19:46 2018-8-23
 * @Modified By:
 */
public class LeetCode42 {

    public int trap(int[] height) {
        int res = 0;  // 结果
        int left = 0; // 左指针
        int right = height.length - 1;       // 右指针
        int leftMax = 0;  // 左边的最大值
        int rightMax = 0; // 右边的最大值
        while (left < right){  // 两个指针中间还有值的时候就继续循环
            leftMax = Math.max(leftMax, height[left]);   // 找到左边局部的最大值
            rightMax = Math.max(rightMax, height[right]); // 找到右边值的最大值
            if (leftMax <= rightMax){  // 左边小，装水以左边为基准
                if (height[left] < leftMax){
                    res += leftMax - height[left];  // 得到可以装水的高度
                }
                left++;
            }else {
                if (height[right] < rightMax){
                    res += rightMax - height[right];
                }
                right--;
            }

        }
        return res;
    }
}
