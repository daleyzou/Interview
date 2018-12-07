package com.daleyzou.blog;


import java.util.Arrays;

/**
 * @Author: DaleyZou
 * @Description: 使用泛型实现对int数组或者String数组进行排序
 *                  基于快速排序实现
 * @Date: Created in 21:07 2018/10/29
 * @Modified By:
 */
public class BubbleSort<T extends Comparable<T>> extends Sort<T> {
    @Override
    public void sort(T[] nums) {
        boolean isSorted = false;
        for (int i = 0; i < nums.length; i++){
            isSorted = true;
            for (int j = 1; j < nums.length - i; j++){
                if (nums[j].compareTo(nums[j - 1]) < 0){
                    swap(nums, j, j - 1);
                    isSorted = false;
                }
            }
            if (isSorted){
                break;
            }
        }
    }

    public static void main(String[] args){
        // 验证String类型
        String[] strs = new String[]{"123", "1234", "1"};
        BubbleSort<String> strSort = new BubbleSort<>();
        strSort.sort(strs);
        System.out.println("验证String类型:");
        Arrays.stream(strs).forEach(System.out::println);

        // 验证int类型
        Integer[] ints = new Integer[]{123,1234,1};
        BubbleSort<Integer> intSort = new BubbleSort<>();
        intSort.sort(ints);
        System.out.println("验证int类型");
        Arrays.stream(ints).forEach(System.out::println);
    }
}
