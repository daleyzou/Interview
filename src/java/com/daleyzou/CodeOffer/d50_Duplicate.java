package com.daleyzou.CodeOffer;

import java.util.Arrays;
import java.util.HashMap;

/**
 * d50_Duplicate
 * @description 在一个长度为n的数组里的所有数字都在0到n-1的范围内。 数组中某些数字是重复的，
 * 但不知道有几个数字是重复的。也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
 * 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
 * @author daleyzou
 * @date 2020年03月09日 22:29
 * @version 3.3.0
 */
public class d50_Duplicate {
    // Parameters:
    //    numbers:     an array of integers
    //    length:      the length of array numbers
    //    duplication: (Output) the duplicated number in the array number,length of duplication array is 1,so using duplication[0] = ? in implementation;
    //                  Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
    //    这里要特别注意~返回任意重复的一个，赋值duplication[0]
    // Return value:       true if the input is valid, and there are some duplications in the array number
    //                     otherwise false
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        if (numbers == null || numbers.length != length){
            return false;
        }
        HashMap<Integer, Integer> map = new HashMap<>(length);
        int j = 0;
        for (int i = 0; i < length; i++){
            Integer count = map.getOrDefault(numbers[i], 0);
            map.put(numbers[i], ++count);
            if (count == 2 && j < duplication.length){
                duplication[j] = numbers[i];
                j++;
            }
        }
        if (j > 0){
            return true;
        }

        return false;
    }

    public static void main(String[] args){
        d50_Duplicate object = new d50_Duplicate();
        int[] numbers =  new int[]{2,1,3,1,4};
        int[] duplicates = new int[5];
        boolean duplicate = object.duplicate(numbers, numbers.length, duplicates);
        System.out.println(duplicate);
        for (int i = 0; i < duplicates.length; i++){
            System.out.println(duplicates[i]);
        }
        Arrays.asList(duplicates).stream().forEach(System.out::println);

    }
}
