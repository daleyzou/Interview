package com.daleyzou.algorithm.sort;

import java.util.Arrays;

/**
 * @Author: DaleyZou
 * @Description: 直接插入排序
 * @Date: Created in 21:38 2018-9-20
 * @Modified By:
 */
public class InsertSort {
    /**
     * @Description: 使用插入排序算法对 nums数组按从小到大进行排序
     * @date: 21:39 2018-9-20
     * @param: nums
     * @return: void
     */
    public void sort(int[] nums){
        for (int i = 1; i < nums.length; i++){
            int temp = nums[i];     // 用于记录当前需要填充到前面有序数组中的值
            int j = i;              // 用于记录当前位置
            while (j >= 1 && nums[j - 1] > temp){
                nums[j] = nums[j - 1]; // 数组的中依次后移
                j--;
            }
            nums[j] = temp;
        }
    }

    public static void main(String[] args){

        int[] nums = new int[]{9,8,7,6,5,4,3,3,2,1};
        InsertSort insertSort = new InsertSort();
        insertSort.sort(nums);

        Arrays.stream(nums).forEach(e-> System.out.print(e + " "));
    }
}
