package com.daleyzou.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * CalBigOne
 *
 * @author daleyzou
 * @description 给一个数组n， 和一个target值，找到比target大的最小组合数，数字可以重复使用
 * @date 2022年01月19日 8:18 下午
 */
public class CalBigOne {
    public int calBigPlus(int[] nums, int target){
        int result = 0;
        char[] chars = (target + "").toCharArray();
        int[] targetNum = new int[chars.length];
        Arrays.sort(nums);
        for(int i = 0; i < chars.length; i++){
            targetNum[i] = Integer.parseInt(chars[i] + "");
        }
        // 统计位数 =》
        // 位数相同  -> 第一位相同 、  第一位更大
        // 位数不相同， 大一位


        // int数组转换为int数字

        return result;
    }

    int[] find(int[] nums, int[] targetNum, int begin){
        int maxNum =  nums[nums.length-1];
        int minNum = nums[0];
        if(begin== targetNum.length-1){
            if(targetNum[begin] >= maxNum){
                int[] result = new int[2];
                // Arrays.fill(result, nums[0]);
                // result[0] = getBigZero(nums);
                return result;
            }else{
                int[] result = new int[1];
                result[0] = getBig(nums, targetNum[begin]);
                return result;
            }
        }
        int[] data = find(nums, targetNum, begin+1);

        int suitLength = targetNum.length - begin -1;
        if(data.length == suitLength){
            int[] result = new int[targetNum.length];
            int i = 0;
            int j = 0;
            if (i < result.length){
                while (i <= begin){
                    result[i] = targetNum[i];
                    i++;
                }
                while (i < result.length){
                    result[i] = data[j++];
                }
            }
            return result;
        }else{
            // 需要考虑在这里加
            return null;

        }
    }

    private int getBig(int[] nums, int num) {
        int begin = 0;
        while(nums[begin] <= num){
            begin++;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        return nums[begin];
    }




    public static void main(String[] args) {
        CalBigOne calBigOne = new CalBigOne();

    }
}
