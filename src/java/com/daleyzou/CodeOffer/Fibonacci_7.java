package com.daleyzou.CodeOffer;

/**
 * @Author: DaleyZou
 * @Description: 斐波那契数列
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。
 * n<=39
 * @Date: Created in 19:38 2019/2/28
 * @Modified By:
 */
public class Fibonacci_7 {
    public int Fibonacci(int n) {
        if (n <= 1){
            return n;
        }
        if (n == 2){
            return 1;
        }

        return Fibonacci(n - 1) + Fibonacci(n - 2);
    }
}
