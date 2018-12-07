package com.daleyzou.algorithm.sort.mergesort;

/**
 * @Author: DaleyZou
 * @Description: 自顶向下归并排序
 *      将一个大数组分成两个小数组去求解。
 *      因为每次都将问题对半分成两个子问题，这种对半分的算法复杂度一般为 O(NlogN)。
 * @Date: Created in 20:01 2018-9-20
 * @Modified By:
 */
public class Up2DownMergeSort<T extends Comparable<T>> extends MergeSort<T> {
    @Override
    public void sort(T[] nums) {
        aux = (T[]) new Comparable[nums.length];
        sort(nums, 0, nums.length - 1);
    }

    // 归并数组
    private void sort(T[] nums, int low, int high) {
        if (high <= low){
            return;  // 递归结束条件
        }
        int mid = low + (high - low) / 2;
        sort(nums, low, mid); // 左区间
        sort(nums, mid + 1, high); // 右区间

        merge(nums, low, mid, high); // 合并两个有序区间
    }
}
