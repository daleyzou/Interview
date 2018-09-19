package com.daleyzou.learn.Generic;

import java.util.ArrayList;

/**
 * @Author: DaleyZou
 * @Description: 利用泛型计算数组中比 某一个数 大的数量
 * @Date: Created in 11:20 2018-9-19
 * @Modified By:
 */
public class CountGreater {
    /**
     * @Description: 计算数组 array 中比 item 大的值得数量
     * @date: 11:25 2018-9-19
     * @param: array 需要进行比较的目标数组
     * @param: item 进行比较的值
     * @return: int 得到的结果数量
     */
    static <T extends Comparable<T>>int countGreaterThan(T[] array, T item){
        int count = 0;
        for (T e : array){
            if (e.compareTo(item) > 0){
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args){
        Class aClass = new ArrayList<Integer>().getClass();
        Class bClass = new ArrayList<String>().getClass();

        System.out.println(aClass == bClass);
    }
}
