package com.daleyzou.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: DaleyZou
 * @Description: 88. 合并两个有序数组
 * @Date: Created in 17:06 2018/12/26
 * @Modified By:
 */
public class LeetCode88 {
    /**
     * @Description: 对 nums1 来从后往前进行最大值开始的倒序填充
     * @param: nums1
     * @param: m
     * @param: nums2
     * @param: n
     * @return: void
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int cursor = m + n - 1;
        m -= 1;
        n -= 1;

        while (m >= 0 && n >= 0){
            if (nums1[m] > nums2[n]){
                nums1[cursor] = nums1[m];
                m--;
                cursor--;
            }else {
                nums1[cursor] = nums2[n];
                n--;
                cursor--;
            }
        }
        while (m >= 0){
            nums1[cursor] = nums1[m];
            m--;
            cursor--;
        }
        while(n >= 0){
            nums1[cursor] = nums2[n];
            n--;
            cursor--;
        }
    }

    public static void main(String[] args){
        LeetCode88 leetCode88 = new LeetCode88();
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        leetCode88.merge(nums1, 3, nums2, 3);
        Arrays.stream(nums1).forEach(System.out::println);
    }
}
