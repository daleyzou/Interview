package com.daleyzou.blog;

/**
 * @Author: DaleyZou
 * @Description: 定义进行排序都需要哪些方法
 * @Date: Created in 20:57 2018/10/29
 * @Modified By:
 */
public abstract class Sort<T extends Comparable<T>> {
    public abstract void sort(T[] nums); // 排序的方法

    public int less(T v, T w){ // 比较大小
        return v.compareTo(w);
    }

    public void swap(T[] nums, int i, int j){ // 进行数组值交换
        T temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
