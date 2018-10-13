package com.daleyzou.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: DaleyZou
 * @Description: 60. 第k个排列
 * @Date: Created in 14:42 2018-10-13
 * @Modified By:
 */
public class LeetCode60 {
    public String getPermutation_method1(int n, int k) {  // 方法超时
        List<List<Integer>> resultList = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        int[] nums = new int[n];
        for (int i = 1; i <= n; i++){
            nums[i - 1] = i;
        }
        backTrack(resultList, result, nums, k);
        StringBuilder sb = new StringBuilder();
        for (Integer i : resultList.get(k - 1)){
            sb.append(i);
        }
        return sb.toString();
    }

    private void backTrack(List<List<Integer>> resultList, List<Integer> result, int[] nums, int k) {
        if (resultList.size() >= k){
            return;
        }

        if (result.size() == nums.length){
            resultList.add(new ArrayList<>(result));
        }else {
            for (int i = 0; i < nums.length; i++){
                if (result.contains(nums[i])){
                    continue;
                }
                result.add(nums[i]);
                backTrack(resultList, result, nums, k);
                result.remove(result.size() - 1);
            }
        }
    }

    public String getPermutation(int n, int k) {
        List<Integer> result = new ArrayList<>();
        List<Integer> finalResult = new ArrayList<>();
        int nums[] = new int[n];
        for (int i = 0; i < n; i++){
            nums[i] = i + 1;
        }
        int count = 0;
        boolean[] isUsed = new boolean[n];
        findK(result, finalResult, nums, k, count, isUsed);
        StringBuilder sb = new StringBuilder();
        for (Integer i : finalResult){
            sb.append(i);
        }

        return sb.toString();
    }

    private void findK(List<Integer> result, List<Integer> finalResult, int[] nums, int k, int count, boolean[] isUsed) {
        if (result.size() == nums.length && count >= k){
            for (Integer i : result){
                finalResult.add(i);
            }
            return;
        }
        if (result.size() == nums.length){
            count++;
        }else {
            for (int i = 0; i < nums.length; i++){
                if (isUsed[i]){
                    continue;
                }
                isUsed[i] = true;
                result.add(nums[i]);
                findK(result, finalResult, nums, k, count, isUsed);
                result.remove(result.size() - 1);
                isUsed[i] = false;
            }
        }
    }

    public static void main(String[] args){
        LeetCode60 leetCode60 = new LeetCode60();

        String result = leetCode60.getPermutation(3, 3);
        System.out.println(result);
    }
}
