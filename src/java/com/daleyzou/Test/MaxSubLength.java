package com.daleyzou.Test;

/**
 * MaxSubLength
 * @description TODO
 * @author daleyzou
 * @date 2020年12月02日 23:59
 * @version 1.1.1
 */
public class MaxSubLength {


    public static int getMaxLength(int[] arr, int k) {
        if (arr == null || arr.length == 0 || k <= 0) {
            return 0;
        }
        int left = 0;
        int right = 0;
        int sum = arr[0];
        int len = 0;
        while (right < arr.length) {
            if (sum == k) {
                len = Math.max(len, right - left + 1);
                sum -= arr[left++];
            } else if (sum < k) {
                right++;
                if (right == arr.length) {//边界判断
                    break;
                }
                sum += arr[right];
            } else {
                sum -= arr[left++];
            }
        }
        return len;




    }

    public static void main(String[] args){
        int maxLength = getMaxLength(new int[] { 10, 2, 3 }, 5);
        System.out.println(maxLength);
    }
}
