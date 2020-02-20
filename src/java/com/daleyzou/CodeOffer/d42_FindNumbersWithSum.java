package com.daleyzou.CodeOffer;

import java.util.ArrayList;

/**
 * d42_FindNumbersWithSum
 * @description 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，
 * 如果有多对数字的和等于S，输出两个数的乘积最小的
 * @author daleyzou
 * @date 2020年02月20日 9:05
 * @version 1.1.11
 */
public class d42_FindNumbersWithSum {
    public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
        ArrayList<Integer> resultList = new ArrayList<>();
        for (int i = 0; i <array.length; i++){
            int temp = sum - array[i];
            if (temp <= array[i] || temp > array[array.length - 1]){
                continue;
            }
            Integer index = findNum(temp, array, i, array.length - 1);
            if (index > i){
                if (resultList.size() == 2){
                    int num1 = resultList.get(0);
                    int num2 = resultList.get(1);
                    if (array[i] * array[index] < num1 * num2){
                        resultList.clear();
                        resultList.add(array[i]);
                        resultList.add(array[index]);
                    }
                }else {
                    resultList.add(array[i]);
                    resultList.add(array[index]);
                }
            }
        }
        return resultList;
    }

    private Integer findNum(int num,int [] array, int begin, int end) {
        if (begin>end){
            return -1;
        }
        if (num < array[begin] || num > array[end]){
            return -1;
        }
        int middle = (begin + end) / 2;
        if (num == array[middle]){
            return middle;
        }
        if (num>array[middle]){
            return findNum(num, array, middle + 1, end);
        }else {
            return findNum(num, array, begin, middle - 1);
        }
    }

    public static void main(String[] args){
        d42_FindNumbersWithSum object = new d42_FindNumbersWithSum();
        int[] array = new int[]{1,2,4,7,11,15};
        ArrayList<Integer> integers = object.FindNumbersWithSum(array, 15);
        System.out.println(integers);
    }
}
