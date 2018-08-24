package com.daleyzou.algorithm;

import java.util.*;

/**
 * @Author: DaleyZou
 * @Description:  对 candidates 数组进行排序、去重
 * @Date: Created in 10:43 2018-8-23
 * @Modified By:
 */
public class sortArray {
    public static void main(String[] args){
        /**
         思路：
         1、使用 HashSet 进行去重
         2、将 HashSet 变为 TreeSet
         3、使用 TreeSet 进行排序
         4、将 Set 变为 Integer 数组
         5、将 Integer 数组变为 int 数组
         */
        int[] candidates = {1,1,2,2,2,9,8,7,76,84,54,45}; // 初始化一个需要排序、去重的int数组
        HashSet<Integer> hashSet = new HashSet<Integer>(); // 去重
        for (int i = 0; i < candidates.length; i++){
            hashSet.add(candidates[i]);
        }
        Set<Integer> set = new TreeSet(hashSet);            // 利用TreeSet排序
        Integer[] integers = set.toArray(new Integer[]{});

        int[] result = new int[integers.length];            // 我们排序、去重后的结果数组
        for (int i = 0; i < integers.length; i++){
            result[i] = integers[i].intValue();
        }

        Arrays.stream(result).forEach(System.out::println); // 将结果数组输出
    }
}

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList();
        Arrays.sort(candidates);
        backtracking(candidates, 0, result, target, new ArrayList());
        return result;
    }

    void backtracking(int[] candidates, int start, List<List<Integer>> result, int target,
                      List<Integer> curr) {
        if (target > 0) {
            for (int i = start; i < candidates.length; i++) {
                if (candidates[i] > target || ((i > start) && (candidates[i - 1] == candidates[i]))) {
                    continue;
                }
                curr.add(candidates[i]);
                backtracking(candidates, i + 1, result, target - candidates[i], curr);
                curr.remove(curr.size() - 1);
            }
        } else if (target == 0) {
            result.add(new ArrayList(curr));
        }
    }
}
class Solution1 {
    public boolean isMatch(String s, String p) {
        boolean[] match = new boolean[s.length() + 1];
        match[s.length()] = true;
        for(int i = p.length() - 1; i >=0; i--){
            if(p.charAt(i) == '*'){
                //如果是星号，从后往前匹配
                for(int j = s.length() - 1; j >= 0; j--){
                    match[j] = match[j] || (match[j + 1] && (p.charAt(i - 1) == '.'
                            || (p.charAt(i - 1) == s.charAt(j))));
                }
                //记得把i多减1，因为星号是和其前面的字符匹配使用
                i--;

            }else{
                //如果不是星号，从前往后匹配
                for(int j = 0; j < s.length(); j++){
                    match[j] = match[j + 1] && (p.charAt(i) == '.' || (p.charAt(i) == s.charAt(j)));
                }
                //只要试过了pattern中最后一个字符，就要把match【s。length（）】置为false
                match[s.length()] = false;
            }
        }
        return match[0];
    }
}
