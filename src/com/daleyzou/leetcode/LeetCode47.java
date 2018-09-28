package com.daleyzou.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @Author: DaleyZou
 * @Description: 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 * @Date: Created in 14:28 2018-9-28
 * @Modified By:
 */
public class LeetCode47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();
        boolean[] isUsed = new boolean[nums.length]; // 记录当前数据是否使用过的数组，初始化全部都是false

        List<Integer> list = new ArrayList<>();
        backTrack(result, list, nums, isUsed);

        return result;
    }

    private void backTrack(List<List<Integer>> result, List<Integer> list, int[] nums, boolean[] isUsed) {
        if (list.size() == nums.length){
            result.add(new ArrayList<>(list));
        }else {
            for (int i = 0; i < nums.length; i++){
                if (isUsed[i]){
                    continue;
                }
                if (i > 0 && nums[i - 1] == nums[i] && !isUsed[i - 1]){
                    continue;
                }
                isUsed[i] = true;
                list.add(nums[i]);
                backTrack(result, list, nums, isUsed);
                isUsed[i] = false;
                list.remove(list.size() - 1);
            }
        }
    }

    public static void main(String[] args){
        LeetCode47 leetCode47 = new LeetCode47();
        int[] nums = new int[]{1,1,3};
        List<List<Integer>> lists = leetCode47.permuteUnique(nums);

        lists.stream().forEach(System.out::println);
    }
}
