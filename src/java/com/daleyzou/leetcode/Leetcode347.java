package com.daleyzou.leetcode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Leetcode347
 * @description 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 * @author daleyzou
 * @date 2020年11月30日 22:24
 * @version 1.1.1
 */
public class Leetcode347 {
    public int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k];
        if (nums.length <= k){
            return  nums;
        }
        Map<Integer, Integer> tempMap = new HashMap<>(nums.length);
        for (int num : nums) {
            tempMap.put(num, tempMap.getOrDefault(num, 0)+1);
        }

        // 构建一个小顶堆
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);

        for (Map.Entry<Integer, Integer> entry : tempMap.entrySet()) {
            if (queue.size() == k){
                if (queue.peek()[1] < entry.getValue()){
                    queue.poll();
                    queue.offer(new int[]{entry.getKey(), entry.getValue()});
                }
            }else {
                queue.offer(new int[]{entry.getKey(), entry.getValue()});
            }
        }
        for (int i = 0; i < k; i++) {
            result[i] = queue.poll()[0];
        }
        return result;
    }
}
