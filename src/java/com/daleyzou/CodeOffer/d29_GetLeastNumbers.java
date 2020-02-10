package com.daleyzou.CodeOffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * d29_GetLeastNumbers
 * @description 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 *
 * https://github.com/apachecn/awesome-algorithm/tree/master/docs/%E5%89%91%E6%8C%87offer/Java/40_KLeastNumbers
 *
 * https://blog.csdn.net/shakespeare001/article/details/51280814
 *
 * @author daleyzou
 * @date 2020年02月04日 20:24
 * @version 3.2.0
 */
public class d29_GetLeastNumbers {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> resultList = new ArrayList<>();
        if (input== null || input.length <= 0 || k > input.length){
            return resultList;
        }
        Arrays.sort(input);
        resultList = new ArrayList<>(Arrays.stream(input).boxed().collect(Collectors.toList()).subList(0, k));
        return resultList;
    }
}
