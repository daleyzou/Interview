package com.daleyzou.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: DaleyZou
 * @Description: 78. 子集
 * @Date: Created in 15:14 2018/12/26
 * @Modified By:
 */
public class LeetCode78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();

        Arrays.sort(nums);

        backTrack(resultList, temp, nums, 0);

        return resultList;
    }

    private void backTrack(List<List<Integer>> resultList, List<Integer> temp, int[] nums, int count) {
        resultList.add(new ArrayList<>(temp));
        for (int i = count; i < nums.length; i++){
            temp.add(nums[i]);
            // 回溯
            backTrack(resultList, temp, nums, i + 1);
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args){
        LeetCode78 leetCode78 = new LeetCode78();
        int[] nums = new int[]{1,2,3};

        List<List<Integer>> subsets = leetCode78.subsets(nums);
        System.out.println(subsets.toString());
    }
}
