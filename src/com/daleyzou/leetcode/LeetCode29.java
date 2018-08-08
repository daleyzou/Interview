package com.daleyzou.leetcode;

/**
 * @Author: DaleyZou
 * @Description:
 * @Date: Created in 15:38 2018-8-8
 * @Modified By:
 */
public class LeetCode29 {
    public int divide(int dividend, int divisor) {

        if (dividend == divisor){
            return 1;
        }
        boolean single = false;
        if ((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0)){
            single = true;
        }
        if (divisor == 1){
            return dividend;
        }
        if (divisor == -1){
            if (dividend == Integer.MIN_VALUE){
                return Integer.MAX_VALUE;
            }else {
                return 0 - dividend;
            }
        }
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        if (dividend == Integer.MIN_VALUE){
            dividend = Integer.MAX_VALUE;
        }
        int result = 0;
        int temp = divisor;
        while (divisor < dividend){
            if (temp > 0){
                if (Integer.MAX_VALUE - divisor < temp){
                    result++;
                    break;
                }
            }
            if (temp < 0){
                if (Integer.MIN_VALUE - divisor > temp){
                    result--;
                    break;
                }
            }
            divisor += temp;
            if (single){
                result--;
            }else {
                result++;
            }
        }
        return result;
    }

    public static void main(String[] args){
        LeetCode29 leetCode29 = new LeetCode29();
       int result = leetCode29.divide(-2147483648,2);
       System.out.println(result);

        System.out.println(Integer.MAX_VALUE);
    }
}
