package com.daleyzou.leetcode;

/**
 * @Author: DaleyZou
 * @Description: 50. Pow(x, n)
 * @Date: Created in 14:09 2018-9-29
 * @Modified By:
 */
public class LeetCode50 {
    public double myPow(double x, int n) {
        double result;
        if (n >= 0){
            result = pow(x, n);
        }else {
            result = 1 / pow(x, -n);
        }

        return result;
    }

    private double pow(double x, int n) {
        if (n == 0){
            return 1;
        }
        double half = pow(x, n / 2);
        if (n % 2 == 0){
            return half * half;
        }else {
            return half * half * x;
        }
    }
}
