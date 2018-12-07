package com.daleyzou.leetcode;

import java.util.*;

/**
 * @Author: DaleyZou
 * @Description:
 * @Date: Created in 21:52 2018/8/6
 * @Modified By:
 */
public class LeetCode18 {

    private boolean containsC(int i, int[] nums, int c) {
        int begin = i, end = nums.length - 1;
        if (c < nums[i] || c > nums[end]){
            return false;
        }
        if (begin == end){
            if (c == nums[begin]){
                return true;
            }else {
                return false;
            }
        }
        int middle;
        while (begin < end){
            middle = (begin + end) / 2;
            if (c == nums[middle]){
                return true;
            }else if (c < nums[middle]){
                end = middle - 1;
            }else {
                begin = middle + 1;
            }
        }
        if (c == nums[begin]){
            return true;
        }
        return false;
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        Set<List<Integer>> result = new HashSet<>();

        for (int i = 0; i < nums.length - 3; i++){
            //c = -(a+b), 可以考虑用二分法求解
            for (int j = i + 1; j < nums.length - 2; j++){
                for (int k = j + 1; k < nums.length - 1; k++){
                    int c = target - (nums[i] + nums[j] + nums[k]);
                    boolean isContains;
                    isContains = containsC(k + 1, nums, c);
                    if (isContains){
                        List<Integer> list = new ArrayList<Integer>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        list.add(c);
                        result.add(list);
                    }
                }
            }
        }
        List<List<Integer>> list = new ArrayList<>(result);
        return list;
    }

    public static void main(String[] args){
        LeetCode18 leetCode18 = new LeetCode18();


        System.out.println();
    }
}
