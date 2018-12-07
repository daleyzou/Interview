package com.daleyzou.algorithm.sort.mergesort;

import java.net.SocketTimeoutException;
import java.util.Arrays;

/**
 * @Author: DaleyZou
 * @Description: 合并有序的数组
 * @Date: Created in 19:31 2018-9-20
 * @Modified By:
 */
public abstract class MergeSort<T extends Comparable<T>> extends Sort<T> {
    // 用于存储原始数据的 辅助数组
    protected T[] aux;

    /**
     * @Description: 合并数组中两个有序的区间
     * @date: 19:48 2018-9-20
     * @param: nums 待合并的原始数组
     * @param: low 第一个区间开始
     * @param: mid 第一个区间和第二个区间中间
     * @param: high 第二个区间结束
     * @return: void
     */
    protected void merge(T[] nums, int low, int mid, int high){
        System.out.println(" low:" +low+ " mid: "+mid + " high:" + high);

        int i = low; // 第一个区间开始
        int j = mid + 1;// 第二个区间开始

        // 将原始数据拷贝到辅助数组中
        for (int k = low; k <= high; k++){
            aux[k] = nums[k];
        }

        // 合并两个有序区间为一个有序区间
        for (int k = low; k <= high; k++){
            if (i > mid){
                nums[k] = aux[j++];
            }else if (j > high){
                nums[k] = aux[i++];
            }else if (aux[i].compareTo(nums[j]) <= 0){
                nums[k] = aux[i++];
            }else {
                nums[k] = aux[j++];
            }
        }

        Arrays.stream(nums).forEach(e-> System.out.print(e + " "));
        System.out.println();

    }
}
