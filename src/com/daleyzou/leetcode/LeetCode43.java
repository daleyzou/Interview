package com.daleyzou.leetcode;

/**
 * @Author: DaleyZou
 * @Description:
 * @Date: Created in 20:01 2018-8-23
 * @Modified By:
 */
public class LeetCode43 {

    public String multiply(String num1, String num2) {
        char[] ch1 = new StringBuilder(num1).reverse().toString().toCharArray(); // 对字符串进行翻转
        char[] ch2 = new StringBuilder(num2).reverse().toString().toCharArray();
        int[] result = new int[ch1.length + ch2.length];

        // 将数组ch1 和数组ch2 的各位数进行相乘，并把各位数相乘的结果放到结果数组 result 中，不考虑进位问题
        for (int i = 0; i < ch1.length; i++){
            int a = ch1[i] - '0';
            for (int j = 0; j < ch2.length; j++){
                int b = ch2[j] - '0';
                result[i + j] += a * b;
            }
        }

        StringBuilder sb = new StringBuilder();

        // 对结果数组 result 中大于等于10的结果进行进位
        for (int i = 0; i < result.length; i++){
            int digit = result[i] % 10;
            int carry = result[i] / 10;

            if (i + 1 < result.length){
                result[i + 1] += carry;
                sb.insert(0, digit);
            }else {
                sb.insert(0, result[i]);
            }
        }

        // 去掉字符串中开头的一连串的 0
        while (sb.length() > 0 && sb.charAt(0) == '0'){
            sb.deleteCharAt(0);
        }

        return sb.length() > 0 ? sb.toString() : "0";
    }

    public static void main(String[] args){
        System.out.println(Integer.MAX_VALUE);
    }
}
