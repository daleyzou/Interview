/**
 * @projectName Interview
 * @package com.daleyzou.leetcode
 * @className com.daleyzou.leetcode.LeetCode66
 * @copyright Copyright 2019 daleyzou, Inc. All rights reserved.
 */
package com.daleyzou.leetcode;

/**
 * LeetCode66
 * @description TODO
 * @author daleyzou
 * @date 2019年12月24日 23:59
 * @version 1.0.0
 */
public class LeetCode66 {
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--){
            digits[i] = digits[i] + 1;

            if (digits[i] < 10){
                break;
            }else {
                if (i == 0){
                    break;
                }
                digits[i] = 0;
            }
        }
        if (digits[0] == 10){
            int[] result = new int[digits.length + 1];
            if (digits.length > 1){
                int count = 0;
                result[count] = 1;
                count++;
                result[count] = 0;
                for (int i = 1; i < digits.length; i++){
                    result[count] = digits[i];
                    count++;
                }
            }else {
                int count = 0;
                result[count] = 1;
                count++;
                result[1] = 0;
            }
            return result;
        }else {
            return digits;
        }
    }

    public static void main(String[] args){
        LeetCode66 leetCode66 = new LeetCode66();
        int[] num = new  int[]{9,9};
        int[] ints = leetCode66.plusOne(num);
    }
}
