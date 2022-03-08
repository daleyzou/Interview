package com.daleyzou.learn.justdo;

import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * MaxTwoSum
 *
 * @author daleyzou
 * @description //[1,2,3,-1, 4, 4, 5]  找出两数和最大的组合数 2
 * @date 2022年03月08日 9:40 上午
 */
public class MaxTwoSum {
    public int findMaxTwoSumCount(int[] nums){
        int n = nums.length;
        if(n < 2){
            throw new RuntimeException("nums length is wrong");
        }
        if(nums.length == 2){
            return 1;
        }
        int[] top = new int[2];
        top[0] = nums[0];
        top[1] = nums[0];
        HashMap<Integer, Integer> map = new HashMap<>(n*2);
        PriorityQueue<Integer>  queue = new PriorityQueue<>();
        for(int i = 0; i < n; i++){
            putTop(top, nums[i]);
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        int maxCount = 0;
        if(map.get(top[1]) > 1){
            int tempN = map.get(top[1]) -1;
            maxCount  = tempN*(tempN +1)/2;
        }else{
            maxCount = map.get(top[0]);
        }
        return maxCount;
    }

    public  void putTop(int[] top, int data){
        int currentMax = Math.max(top[0], top[1]);
        int currentMin = Math.min(top[0], top[1]);
        if(data <= currentMin){
            return;
        }else if(data > currentMax){
            top[0] = currentMax;
            top[1] = data;
        }else {
            top[0] = data;
            top[1] = currentMax;
        }
    }
    public static void main(String[] args) {
        MaxTwoSum maxTwoSum = new MaxTwoSum();
        int maxTwoSumCount = maxTwoSum.findMaxTwoSumCount(new int[]{1, 2, 3, -1, 4, 4, 5, 5, 5, 5});
        System.out.println(maxTwoSumCount);
    }
}
