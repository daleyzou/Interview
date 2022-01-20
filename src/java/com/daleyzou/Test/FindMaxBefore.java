package com.daleyzou.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * FindMaxBefore
 *
 * @author daleyzou
 * @description 给一个数组n， 和一个target值，找到比target大的最小组合数，数字可以重复使用
 * @date 2022年01月19日 11:55 下午
 */
public class FindMaxBefore {
    /**
     * arr[5, 8 ,6]
     * n = 7937
     *
     *
     * 1、排序arr数组
     * 2、将n转换为从最高位到最低位的数组targetArr
     * 3、递归遍历targetArr的每一位，index。边界如下
     * a、如果index >= targetArr，表示前面的每一位都能在arr数组中找到，则（最后一位变成比他大的最小值，如果不存在，上一位继续，必存在一位能够满足条件）
     * b、从arr中找到比targetArr[index]大于等于他的最小值 temp
     * c、如果targetArr[index] == temp, deep(index + 1);
     * d、如果targetArr[index] > temp, 则将当前位设为temp，并将后面的值选出arr最小值填充
     * e、如果targetArr[index] < temp, 则上一位找到比当前值大的最小值，填充，
     * 并且后面的值选出最小值填充，如果递归到第一位还没有找到，则表示arr所有的值都小于targetArr，则用最小值填充为比targetAr多一位的值
     */
    public int find_max_before(int[] arr, int n) {
        ArrayList<Integer> result = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();
        while (n != 0) {
            int temp = n % 10;
            n /= 10;
            stringBuilder.append(temp);
        }

        String nums = stringBuilder.reverse().toString();
        int[] targetArr = new int[nums.length()];
        for (int i = 0; i < nums.length(); ++i) {
            targetArr[i] = nums.charAt(i);
        }

        Arrays.sort(arr);
        int arrMax =  findMax(arr);
        /**
         * 相同位数最大的数
         */
        int maxNum = 1;
        int pow = 1;
        for (int i = 0; i < targetArr.length; ++i) {
            maxNum += arrMax * pow;
            pow *= 10;
        }
        if (n >= maxNum) fullList(findMin(arr), result, targetArr.length + 1);
        deep(arr, targetArr, 0, result);

        int resultNum = 1;
        pow = 1;
        for (int i = result.size() - 1; i >= 0; -- i) {
            resultNum += result.get(i) * pow;
            pow *= 10;
        }
        return resultNum;
    }


    public boolean deep(int[] arr, int[] targetArr, int index, List<Integer> result) {
        if (index == targetArr.length) {
            int maxBefore = finMaxBefore(arr, result.get(result.size() - 1));
            if (maxBefore == -1) return false;
            else {
                result.set(result.size() - 1, maxBefore);
                return true;
            }
        }
        int temp = findMEqu(arr, targetArr[index]);
        if (temp == -1) {
            temp = finMaxBefore(arr, targetArr[index]);
        }
        if (temp > targetArr[index]) {
            result.add(temp);
            fullList(findMin(arr), result, targetArr.length - index - 1);
            return true;
        } else if (temp < targetArr[index]){
            fullList(findMin(arr), result, targetArr.length - index);
            return false;
        }
        result.add(temp);
        boolean b = deep(arr, targetArr, index + 1, result);
        if (!b) {
            int maxBefore = finMaxBefore(arr, temp);
            if (maxBefore == temp) {
                result.set(index, findMin(arr));
                return false;
            } else {
                result.set(index, maxBefore);
                return true;
            }
        }

        return true;
    }


    public int findMEqu(int[] arr, int target) {
        int left = 0;
        int right = arr.length;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (arr[mid] == target) return arr[mid];
            else if (arr[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }

    /**
     * 2, 3, 4, 5, 7 ,8
     * 1
     */
    public int finMaxBefore(int[] arr, int target) {
        int left = 0;
        int right = arr.length;
        int ans = -1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (arr[mid] > target) {
                right = mid - 1;
                ans = mid;
            }
            else left = mid + 1;
        }
        return ans;
    }

    public int findMin(int[] arr) {
        return arr[0];
    }

    public int findMax(int[] arr) {
        return arr[arr.length - 1];
    }


    public void fullList(int target, List<Integer> list, int num) {
        while (num > 0) {
            list.add(target);
            num--;
        }
    }
}
