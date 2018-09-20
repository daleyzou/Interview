package com.daleyzou.algorithm.sort.mergesort;

/**
 * @Author: DaleyZou
 * @Description: 待排序的元素需要实现 Java 的 Comparable 接口，该接口有 compareTo() 方法，可以用它来判断两个元素的大小关系
 * @Date: Created in 19:33 2018-9-20
 * @Modified By:
 */
public abstract class Sort<T extends Comparable<T>> {
    // 定义排序的抽象方法
    public abstract void sort(T[] nums);

    // 使用辅助函数 less() 和 swap() 来进行比较和交换的操作，使得代码的可读性和可移植性更好

    /**
     * @Description: 用于对两个值进行大小的比较
     * @date: 19:38 2018-9-20
     * @param: v 值1
     * @param: w 值2
     * @return: boolean true：小于 false：大于
     */
    protected boolean less(T v, T w){
        return v.compareTo(w) < 0;
    }

    /**
     * @Description: 交换数组a中 下标为 i 和 j 的元素
     * @date: 19:40 2018-9-20
     * @param: a 待交换数据的数组
     * @param: i 下标1
     * @param: j 下标2
     * @return: void
     */
    protected void swap(T[] a, int i, int j){
        T temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
