package com.daleyzou.leetcode;

/**
 * @Author: DaleyZou
 * @Description:
 * @Date: Created in 21:59 2018/7/24
 * @Modified By:
 */
public class LeetCode7 {

    /**
     * @Description: 给定一个 32 位有符号整数，将整数中的数字进行反转。
     * @auther: DaleyZou
     * @date: 22:00 2018/7/24
     * @param: x
     * @return: int
     */
    public static int reverse(int x) {
        int temp = x;
        int result;
        if (temp < 0){
            temp = 0 - temp;
        }
        char[] chars = String.valueOf(temp).toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int j = chars.length - 1; j >= 0; j--){
            sb.append(chars[j]);
        }
        try {
            result =  Integer.parseInt(sb.toString());
            if (x < 0){
                result = 0 - result;
            }
        }catch (Exception e){
            return 0;
        }
        return result;
    }

    public static void main(String[] args){
        System.out.println(reverse(-345999));
    }
}
