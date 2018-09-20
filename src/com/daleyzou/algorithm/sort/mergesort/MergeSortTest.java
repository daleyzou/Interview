package com.daleyzou.algorithm.sort.mergesort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: DaleyZou
 * @Description: 测试自顶向下归并排序
 * @Date: Created in 20:11 2018-9-20
 * @Modified By:
 */
public class MergeSortTest {

    public static void main(String[] args){
        Integer[] nums = new Integer[]{9,8,7,6,5,4,3,2,1};
        Up2DownMergeSort<Integer> mergeSort = new Up2DownMergeSort<Integer>();

        mergeSort.sort(nums);

        Arrays.stream(nums).forEach(e-> System.out.print(e + " "));
    }
}
