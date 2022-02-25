package com.daleyzou.interview;

import org.omg.CORBA.INTERNAL;

import java.util.ArrayList;
import java.util.List;

/**
 * Test
 *
 * @author zoudaifa
 * @description TODO
 * @date 2022年02月11日 6:37 下午
 */
public class Test {
    List<List<Integer>> resultList = new ArrayList<>();
    //
    public  List<List<Integer>> find(int[] nums){
        List<Integer> list = new ArrayList<>();
        backTrack(nums, list, 0);
        return resultList;
    }

    private void backTrack(int[] nums, List<Integer> list, int begin) {
        resultList.add(new ArrayList<>(list));

        for(int i = begin; i < nums.length; i++){
            if(list.contains(nums[i])){
                continue;
            }
            list.add(nums[i]);
            backTrack(nums, list, i+1);
            list.remove(list.size()-1);
        }
    }

    public static void main(String[] args) {
        Test test = new Test();
        List<List<Integer>> lists = test.find(new int[]{1, 2, 3, 4});

        for (List<Integer> list : lists) {
            System.out.println(list.toString());
        }

        String s = "";

    }
}
