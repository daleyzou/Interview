package com.daleyzou.learn.justdo;

/**
 * CountSqurt
 * @description CountSqurt
 *   输入整数x,输出开根号的结果，保留精度0.00001。
 * @author daleyzou
 * @date 2022年04月12日 17:18
 * @version 1.1.1
 */
public class CountSqurt {

    public double squrt(int n){
        double begin = 0.0;
        double end = n / 1.0;
        double decimal = 0.000001;
        double mid = (begin+end)/2.0;
        while(Math.abs(mid*mid - n) > decimal){
            double midMul = mid * mid;
            if(midMul > n){
                end = mid;
            }else if(midMul < n){
                begin = mid;
            }else{
                return mid;
            }
            mid = (begin+end)/2.0;
        }
        return Math.round(mid*100000)/100000.0;
    }

    public static void main(String[] args) {
        CountSqurt test = new CountSqurt();
        System.out.println(test.squrt(2));
    }
}
