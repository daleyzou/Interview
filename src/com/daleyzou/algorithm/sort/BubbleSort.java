package com.daleyzou.algorithm.sort;

import java.util.Arrays;

/**
 * @Author: DaleyZou
 * @Description: 快速排序
 * @Date: Created in 14:53 2018-9-20
 * @Modified By:
 */
public class BubbleSort {
    public void bubbleSort(int nums[]){
        for (int i = 0; i < nums.length; i++){

            boolean isSwap = false;  // 用于判断这一次排序是否发生了交换

            for (int j = 1; j < nums.length - i; j++){
                if (nums[j - 1] > nums[j]){
                    int temp = nums[j - 1];
                    nums[j - 1] = nums[j];
                    nums[j] = temp;
                    isSwap = true;
                }
            }
            // 输出每一趟排序后的结构
            System.out.println("第" + (i + 1) + "趟排序");
            Arrays.stream(nums).forEach(e-> System.out.print(e + " "));
            System.out.println();

            if (!isSwap){
                break;
            }
        }
    }

    public static void main(String[] args){
        int[] nums = new int[]{9,8,7,6,5,4,3,2,1};
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.bubbleSort(nums);

        // 输出排序后的结果
        Arrays.stream(nums).forEach(System.out::println);
    }
}
