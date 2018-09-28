package com.daleyzou.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: DaleyZou
 * @Description: 全排列
 * @Date: Created in 10:56 2018-9-28
 * @Modified By:
 */
public class LeetCode46 {

    // 参考链接；https://mp.weixin.qq.com/s/U-w3nXRvIuzopqNzeIETXw

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>(new ArrayList<>());

        List<Integer> list = new ArrayList<>();
        backTrack(result, list, nums);

        return result;
    }

    private void backTrack(List<List<Integer>> result, List<Integer> list, int[] nums) {
        if (list.size() == nums.length){
            result.add(new ArrayList<>(list));
        }else {
            for (int i = 0; i < nums.length; i++){
                if (list.contains(nums[i])){
                    continue;
                }else {
                    list.add(nums[i]);
                    backTrack(result, list, nums);
                    // 通过移除list的最后一个元素，达到从叶子节点回到根节点的目的
                    list.remove(list.size() - 1);
                }
            }
        }
    }

    public static void main(String[] args){
        LeetCode46 leetCode46 = new LeetCode46();
        int[] nums = new int[]{1,2,3};
        List<List<Integer>> permute = leetCode46.permute(nums);

        permute.stream().forEach(System.out::println);
    }

}
