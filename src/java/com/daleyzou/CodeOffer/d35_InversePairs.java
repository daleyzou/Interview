package com.daleyzou.CodeOffer;

import java.util.HashMap;
import java.util.Map;

/**
 * d35_InversePairs
 * @description 在数组中的两个数字，
 *              如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 *              输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。
 *              即输出P%1000000007
 * @author daleyzou
 * @date 2020年02月16日 23:00
 * @version 1.1.11
 */
public class d35_InversePairs {
    public int InversePairs_back(int [] array) {
        int result = 0;
        for (int i = 0; i < array.length; i++){
            for (int j = i + 1; j < array.length; j++){
                if (array[i] > array[j]){
                    result++;
                }
            }
            result = (result % 1000000007);
        }

        return result;
    }
    int result = 0;
    int[] tempArray;
    public int InversePairs(int [] array) {

        tempArray = new int[array.length];
        sort(array, 0, array.length-1);
        return result;
    }

    private void sort(int[] array, int begin, int end) {
        if (begin >= end){
            return;
        }
        int middle = (begin + end) / 2;
        sort(array, begin, middle);
        sort(array, middle + 1, end);
        merge(array, begin, middle, end);
    }

    private void merge(int[] array, int begin, int middle, int end) {

        int i = middle;
        int j = end;
        int index = end;
        // 复制数据
        for (int k = begin; k <= end; k++){
            tempArray[k] = array[k];
        }

        while (j >= middle+1 && i >= begin){
            if (tempArray[i] > tempArray[j]){
                array[index--] = tempArray[i--];
                result += j - middle;
                result = (result % 1000000007);
            }else {
                array[index--] = tempArray[j--];
            }
        }
        while (i >= begin){
            array[index--] = tempArray[i--];
        }
        while (j >= middle + 1){
            array[index--] = tempArray[j--];
        }
    }

    public static void main(String[] args){
        d35_InversePairs object = new d35_InversePairs();
        int[] testArray = new int[]{1,2,3,4,5,6,7,0};

        int i = object.InversePairs(testArray);
        System.out.println(i);
    }
}
