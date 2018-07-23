package com.daleyzou.leetcode;

import java.util.Arrays;

/**
 * @Author: DaleyZou
 * @Description:
 * @Date: Created in 7:15 2018/7/24
 * @Modified By:
 */
public class LeetCode4 {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] results = new int[nums1.length + nums2.length];

        int i = 0, j = 0;
        int index = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] <= nums2[j]) {
                results[index++] = nums1[i++];
            } else {
                results[index++] = nums2[j++];
            }
        }
        while (i < nums1.length) {
            results[index++] = nums1[i++];
        }
        while (j < nums2.length) {
            results[index++] = nums2[j++];
        }
//        Arrays.stream(results).forEach(System.out::println);
//        System.out.println("==========");
//        System.out.println(results[1]);
        if (results.length % 2 != 0) {
            return results[(results.length - 1) / 2] / 1.0;
        } else {
            return (results[results.length / 2] + results[results.length / 2 - 1]) / 2.0;
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 3, 5};
        int[] nums2 = {2, 4, 6};
        double medianSortedArrays = findMedianSortedArrays(nums1, nums2);
        System.out.println(medianSortedArrays);
    }
}
