package com.daleyzou.algorithm;

import java.util.*;

/**
 * @Author: DaleyZou
 * @Description:  对 一个int数组 candidates 数组进行排序、去重
 * @Date: Created in 10:43 2018-8-23
 * @Modified By:
 */
public class sortArray {
    public static void main(String[] args){
        /**
         思路：
         1、使用 HashSet 进行去重
         2、将 HashSet 变为 TreeSet
         3、使用 TreeSet 进行排序
         4、将 Set 变为 Integer 数组
         5、将 Integer 数组变为 int 数组
         */
        int[] candidates = {1,1,2,2,2,9,8,7,76,84,54,45}; // 初始化一个需要排序、去重的int数组
        HashSet<Integer> hashSet = new HashSet<Integer>(); // 去重
        for (int i = 0; i < candidates.length; i++){
            hashSet.add(candidates[i]);
        }
        Set<Integer> set = new TreeSet(hashSet);            // 利用TreeSet排序
        Integer[] integers = set.toArray(new Integer[]{});

        int[] result = new int[integers.length];            // 我们排序、去重后的结果数组
        for (int i = 0; i < integers.length; i++){
            result[i] = integers[i].intValue();
        }

        Arrays.stream(result).forEach(System.out::println); // 将结果数组输出
    }
}