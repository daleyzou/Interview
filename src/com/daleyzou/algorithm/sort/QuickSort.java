package com.daleyzou.algorithm.sort;

/**
 * @Author: DaleyZou
 * @Description: 快速排序
 * @Date: Created in 14:55 2018/8/4
 * @Modified By:
 */
public class QuickSort {

    public void quick_Sort(int[] nums, int left, int right){
        if (left < right){
            int i = left, j = right;
             /**
              * 第一趟快速排序，在数组中找到X的合适位置，实现X
                    左边的值都比X小，X右边的值都比X大
              */
            int x = nums[i];
            while (i < j){
                // 从数组的右边开始扫描，找到第一个比 X 小的值
                while (i < j && nums[j] > x){
                    j--;
                }
                if (i < j){
                    nums[i++] = nums[j];
                }
                // 从数组的左边开始扫描，找到第一个比 X 大的值
                while (i < j && nums[i] < x){
                    i++;
                }
                if (i < j){
                    nums[j--] = nums[i];
                }
            }
            nums[i] = x;
            quick_Sort(nums, left, i - 1); // 递归对X左边的值进行排序
            quick_Sort(nums, i + 1, right); // 递归对X右边的值进行排序
        }

    }

    public static void main(String[] args){
        int[] nums = {-1,0,1,2,-1,-4};
        QuickSort quickSort = new QuickSort();
        quickSort.quick_Sort(nums, 0, nums.length - 1);
        for (int i = 0; i < nums.length; i++){
            System.out.print(nums[i] + " ");
        }
    }
}
