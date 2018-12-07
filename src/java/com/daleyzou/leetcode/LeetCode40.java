package com.daleyzou.leetcode;

import java.util.*;

/**
 * @Author: DaleyZou
 * @Description:
 * @Date: Created in 9:06 2018-8-23
 * @Modified By:
 */
public class LeetCode40 {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) { // 方法一：运行通过了，但是感觉效率太低了
        List<Integer> result = new ArrayList<>();
        List<List<Integer>> resultList = new ArrayList<>();

        Arrays.sort(candidates); // 对 candidates 进行排序，从而减少递归的数量，达到剪枝的目的
        dfs(candidates, resultList, result, 0, target);

        return resultList;
    }

    private void dfs(int[] candidates, List<List<Integer>> resultList, List<Integer> result, int start, int target) {
        if (target < 0){
            return;
        }
        if (target == 0){
            resultList.add(new ArrayList<>(result));
        }
        for (int i = start; i < candidates.length; i++){
            if (target < candidates[i] || (i > start && candidates[i] == candidates[i - 1])){  // 剪枝，如果数据和前一个重复的话就不用去再次查找了
                continue;
            }
            result.add(candidates[i]);
            dfs(candidates, resultList, result, i + 1, target - candidates[i]);
            result.remove(result.size() - 1);
        }
    }



    public static void main(String[] args){
        LeetCode40 leetCode40 = new LeetCode40();

        int[] candidates = {1,1,2,2,2,9,8,7,76,84,54,45};
        int target = 85;
        List<List<Integer>> lists = leetCode40.combinationSum2(candidates, target);
        System.out.println(lists);
    }
}
