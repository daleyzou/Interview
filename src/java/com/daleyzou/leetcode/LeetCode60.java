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

    List<Integer> finalResult;
    int count = 0;
    public String getPermutation_method2(int n, int k) {    // 方法二，使用计数器来进行查找
        List<Integer> result = new ArrayList<>();
        int nums[] = new int[n];
        for (int i = 0; i < n; i++){
            nums[i] = i + 1;
        }
        int count = 0;
        boolean[] isUsed = new boolean[n];
        findK(result, nums, k, isUsed);
        StringBuilder sb = new StringBuilder();
        for (Integer i : finalResult){
            sb.append(i);
        }

        return sb.toString();
    }

    private void findK(List<Integer> result, int[] nums, int k, boolean[] isUsed) {
        if (result.size() == nums.length){
            count++;
        }

        if (result.size() == nums.length && count == k-1){
            finalResult = new ArrayList<>(result);
            return;
        }else if (count < k && result.size() == nums.length) {
            result = new ArrayList<>();
        }
        for (int i = 0; i < nums.length; i++){
            if (isUsed[i]){
                continue;
            }
            isUsed[i] = true;
            result.add(nums[i]);
            findK(result, nums, k, isUsed);
            result.remove(result.size() - 1);
            isUsed[i] = false;
        }
    }

    // 参考链接：https://blog.csdn.net/withoutbugs/article/details/80805114
    // https://www.programcreek.com/2013/02/leetcode-permutation-sequence-java/
    public String getPermutation(int n, int k) {
        List<Integer> nums = new ArrayList<>();
        // 将数据添加到数组 nums 中
        for (int i = 1; i <= n; i++){
            nums.add(i);
        }

        String result = "";
        k--;
        int mod = 1;
        // 计算n的阶乘
        for (int i = 1; i<=n; i++){
            mod *= i;
        }

        for (int i = 0; i < n; i++){
            mod = mod / (n - i);    // 计算当前位置合适的阶乘
            int curIndex = k / mod; // 计算当前的索引
            k = k % mod;
            result += nums.get(curIndex);
            nums.remove(curIndex); // 从数组中移除已使用的数据项
        }
        return result;
    }

    public static void main(String[] args){
        LeetCode60 leetCode60 = new LeetCode60();

        String result = leetCode60.getPermutation(3, 3);
        System.out.println(result);
    }
}
