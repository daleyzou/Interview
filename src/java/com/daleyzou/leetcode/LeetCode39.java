package com.daleyzou.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: DaleyZou
 * @Description:
 *              参考链接：https://mp.weixin.qq.com/s/elSiUq9Xd105Yh48DJYk3w
 * @Date: Created in 13:44 2018-8-22
 * @Modified By:
 */
public class LeetCode39 {

    /**
     * @Description: 使用dfs递归来实现的深度优先搜索来进行数据的查找
     * @auther: DaleyZou
     * @date: 17:11 2018-8-22
     * @param: candidates
     * @param: target
     * @return: java.util.List<java.util.List<java.lang.Integer>>
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> resultList = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates, resultList, result, 0, target);
        return resultList;
    }

    private void dfs(int[] candidates, List<List<Integer>> resultList, List<Integer> result, int start, int target) {
        if (target < 0){            // target不符合
            return;
        }else if (target == 0){   // target符合
            resultList.add(new ArrayList<>(result));
        }else {                  // 继续进行数的查找
            for (int i = start; i < candidates.length; i++){
                if (target - candidates[i] >= 0){
                    result.add(candidates[i]);
                    dfs(candidates, resultList, result, i, target - candidates[i]);
                    result.remove(result.size() - 1);     // 数查找完后要进行回溯
                }else {
                    break;
                }
            }
        }
    }


}
