package com.daleyzou.leetcode;

import java.util.*;

/**
 * @Author: DaleyZou
 * @Description:
 * @Date: Created in 10:31 2018-8-3
 * @Modified By:
 */
public class LeetCode15 {

    /**
     * @Description:
     * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，
     * 使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
     * @auther: DaleyZou
     * @date: 14:20 2018-8-3
     * @param: nums
     * @return: java.util.List<java.util.List<java.lang.Integer>>
     */
    public List<List<Integer>> threeSum1(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < nums.length - 2; i++){
            //c = -(a+b), 可以考虑用二分法求解
            for (int j = i + 1; j < nums.length - 1; j++){
                int c = -(nums[i] + nums[j]);
                boolean isContains;
                if (set.contains(c)){
                    isContains = true;
                }else {
                    isContains = containsC(j + 1, nums, c);
                    if (isContains) set.add(c);
                }
                if (isContains){
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(c);
                    if (!result.contains(list)) result.add(list);
                }
            }
        }
        return result;
    }

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

    public List<List<Integer>> threeSum2(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < nums.length - 2; i++){
            //c = -(a+b), 可以考虑用二分法求解
            for (int j = i + 1; j < nums.length - 1; j++){
                int c = -(nums[i] + nums[j]);
                boolean isContains;
                isContains = containsC(j + 1, nums, c);

                if (isContains){
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(c);
                    if (!result.contains(list)) result.add(list);
                }
            }
        }
        return result;
    }
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> result = new HashSet<>();

        for (int i = 0; i < nums.length - 2; i++){
            //c = -(a+b), 可以考虑用二分法求解
            for (int j = i + 1; j < nums.length - 1; j++){
                int c = -(nums[i] + nums[j]);
                boolean isContains;
                isContains = containsC(j + 1, nums, c);
                if (isContains){
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(c);
                    result.add(list);
                }
            }
        }
        List<List<Integer>> list = new ArrayList<>(result);
        return list;
    }

    public static void main(String[] args){

        LeetCode15 leetCode15 = new LeetCode15();

        long ll = System.currentTimeMillis();
//        System.out.println(ll - l);

        long lll = System.currentTimeMillis();
        System.out.println(lll - ll);


    }
}
