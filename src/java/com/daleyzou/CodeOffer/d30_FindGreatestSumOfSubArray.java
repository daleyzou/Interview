package com.daleyzou.CodeOffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * d30_FindGreatestSumOfSubArray
 * @description HZ偶尔会拿些专业问题来忽悠那些非计算机专业的同学。今天测试组开完会后,他又发话了:在古老的一维模式识别中,
常常需要计算连续子向量的最大和,
当向量全为正数的时候,问题很好解决。但是,如果向量中包含负数,是否应该包含某个负数,
并期望旁边的正数会弥补它呢？例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)。
给一个数组，返回它的最大连续子序列的和，你会不会被他忽悠住？(子向量的长度至少是1)
 * @author daleyzou
 * @date 2020年02月05日 9:13
 * @version 3.2.0
 */
public class d30_FindGreatestSumOfSubArray {
    /**
     *  错误，连续子数组的最大和，并不一定是从第一个元素开始的
     */
    public int FindGreatestSumOfSubArray_wrong(int[] array) {
        if (array == null || array.length <= 0) {
            return 0;
        }
        int count = 0;
        List<Integer> list = new ArrayList<>(array.length);
        int[] tempArray = new int[array.length];
        for (int i = 0; i < array.length; i++){
            count += array[i];
            tempArray[i] = count;
        }
        Arrays.sort(tempArray);
        return tempArray[tempArray.length - 1];
    }

    public int FindGreatestSumOfSubArray(int[] array) {
        int cur = array[0];
        int res = cur;
        for (int i = 1; i < array.length; i++){
            cur += array[i];
            res = Math.max(cur, res);
            cur = (cur > 0?cur:0);

        }
        return res;
    }

    public static void main(String[] args){
         d30_FindGreatestSumOfSubArray object = new d30_FindGreatestSumOfSubArray();
         int[] testArray = new int[]{1,-2,3,10,-4,7,2,-5};
         object.FindGreatestSumOfSubArray(testArray);
    }
}
