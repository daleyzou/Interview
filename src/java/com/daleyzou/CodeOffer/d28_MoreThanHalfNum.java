package com.daleyzou.CodeOffer;

import java.util.HashMap;
import java.util.Map;

/**
 * d28_MoreThanHalfNum
 * @description
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 * @author zoudaifa
 * @date 2020年02月04日 20:16
 * @version 3.2.0
 */
public class d28_MoreThanHalfNum {
    public int MoreThanHalfNum_Solution(int [] array) {
        if (array == null || array.length <= 0){
            return 0;
        }
        int halfSize = array.length / 2;
        Map<Integer, Integer> map = new HashMap<>(array.length);
        for (int i = 0; i < array.length; i++){
            Integer count = map.getOrDefault(array[i], 0);
            count++;
            map.put(array[i], count);
            if (count > halfSize){
                return array[i];
            }
        }
        return 0;
    }
}
