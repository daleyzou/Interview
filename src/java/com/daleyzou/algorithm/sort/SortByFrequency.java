package com.daleyzou.algorithm.sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

/**
 * @Author: DaleyZou
 * @Description: 数组元素排序：按出现次数大小排序，次数相同按大小升序排序
 * @Date: Created in 18:58 2018/11/22
 * @Modified By:
 */
public class SortByFrequency {

    /**
     * @Description: 使用传统方法，重载compare
     * @param: nums
     * @return: void
     */
    public void sort(Integer[] nums){
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        // 输出map的数据
        System.out.println("map:" + map);
        System.out.println("orign:" + Arrays.toString(nums));

        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (map.get(o1).equals(map.get(o2))){
                    return Integer.compare(map.get(o1), map.get(o2));
                }else {
                    return Integer.compare(o1, o2);
                }
            }
        };
        Arrays.sort(nums, comparator);
        System.out.println("after sort:" + Arrays.toString(nums));
    }

    /**
     * @Description: 使用lambda语法，简化代码行数
     * @param: nums 待排序数组
     * @return: void
     */
    public void sortUseLambda(Integer[] nums){
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        // 输出map的数据
        System.out.println("map:" + map);
        System.out.println("orign:" + Arrays.toString(nums));

        Arrays.sort(nums, (Integer o1, Integer o2)->{
            // 出现次数相同
            if (map.get(o1) == map.get(o2)){
                return o1.compareTo(o2);
            }else { // 根据出现次数比大小
                return map.get(o1).compareTo(map.get(o2));
            }
        });

        System.out.println("after sort:" + Arrays.toString(nums));
    }

    public static void main(String[] args){
        Integer[] nums = new Integer[]{1,9,4,3,2,1,8,2,2,2};

        SortByFrequency sortByFrequency = new SortByFrequency();
//        sortByFrequency.sort(nums);
        sortByFrequency.sortUseLambda(nums);
    }
}
