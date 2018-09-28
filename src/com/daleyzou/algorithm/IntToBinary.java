package com.daleyzou.algorithm;

/**
 * @Author: DaleyZou
 * @Description: 递归实现十进制转二进制
 * @Date: Created in 20:55 2018-9-27
 * @Modified By:
 */
public class IntToBinary {
    /**
     * @Description: 思路：“除 2 取余”
     * @date: 20:56 2018-9-27
     * @param: num 带转换的十进制数
     * @return: void
     */
    public static void changToBinary(int num){
        if (num == 0){
            return;
        }

        changToBinary(num / 2);
        System.out.print(num % 2);
    }

    public static void main(String[] args){
        changToBinary(10);
    }
}
