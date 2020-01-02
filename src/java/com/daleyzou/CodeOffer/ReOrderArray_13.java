/**
 * @projectName Interview
 * @package com.daleyzou.CodeOffer
 * @className com.daleyzou.CodeOffer.ReOrderArray_13
 * @copyright Copyright 2019 daleyzou, Inc. All rights reserved.
 */
package com.daleyzou.CodeOffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * ReOrderArray_13
 * @description 调整数组顺序使奇数位于偶数前面
 * @author daleyzou
 * @date 2019年12月30日 22:58
 * @version 1.0.0
 */
public class ReOrderArray_13 {
    public void reOrderArray(int [] array) {
        // 奇数
        StringBuilder odd = new StringBuilder();
        List<Integer> oddList = new ArrayList<>();
        // 偶数
        StringBuilder even = new StringBuilder();
        List<Integer> evenList = new ArrayList<>();
        for (int num : array){
            if ((num & 1) == 1){
                odd.append(num);
                oddList.add(num);
            }else {
                even.append(num);
                evenList.add(num);
            }
        }
        List<Integer> result = new ArrayList<>();
        result.addAll(oddList);
        result.addAll(evenList);
        for (int i = 0; i < result.size(); i++){
            array[i] = result.get(i);
        }
    }

    public void reOrderArray_2(int [] array) {
        if (array.length == 0 || array == null){
            return;
        }
        int i = 0;
         while (i < array.length){
             if (isOdd(array[i])){
                 // 是基数
                 i++;
             }else {
                 // 是偶数
                 // 找到后面的奇数，放到这个偶数的位置上，逐个后移
                 int j = i + 1;
                 while (j < array.length){
                     if (!isOdd(array[j])){
                         j++;
                     }else {
                         break;
                     }
                 }
                 if (j < array.length){
                     int index = j;
                     int temp = array[j];
                     while (index > i){
                         array[index] = array[index - 1];
                         index--;
                     }
                     array[i] = temp;
                 }else {
                     break;
                 }
             }
         }
    }

    private boolean isOdd(int i) {
        if ((i & 1) == 1){
            return true;
        }else {
            return false;
        }
    }

    public static void main(String[] args){
        ReOrderArray_13 object = new ReOrderArray_13();
        int[] array = new int[]{1,2,3,4,5,6,7,8,9};
        object.reOrderArray_2(array);
        for (int i : array){
            System.out.println(i);
        }
    }
}
