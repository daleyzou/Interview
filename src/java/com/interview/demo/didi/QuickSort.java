package com.interview.demo.didi;

/**
 * Demo
 * @description TODO
 * @author daleyzou
 * @date 2020年12月06日 15:57
 * @version 1.1.1
 */
public class QuickSort {
    public void quickSort(int[] nums) {

        sortArray(nums, 0, nums.length - 1);
    }

    private void sortArray(int[] nums, int begin, int end) {
        if (begin < end) {
            return;
        }
        // 找到 合适的 nums[begin]位置, 左边第一个比他大， 右边第一个比他小
        int temp = nums[begin];
        int swap;
        int i = begin;
        int j = end;
        int middle = 0;
        while (nums[i] < temp && i < end) {
            i++;
        }

        while (nums[j] > temp && j > i) {
            j--;
        }

        sortArray(nums, begin, middle);
        sortArray(nums, middle, end);
    }
}
