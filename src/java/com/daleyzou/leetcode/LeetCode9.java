package com.daleyzou.leetcode;

/**
 * @Author: DaleyZou
 * @Description:
 * @Date: Created in 21:24 2018/7/24
 * @Modified By:
 */
public class LeetCode9 {

    /**
     * @Description: 判断一个整数是否是回文数。
     * @auther: DaleyZou
     * @date: 21:25 2018/7/24
     * @param: x
     * @return: boolean
     */
    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }else if (x < 10){
            return true;
        }else {
            char[] chars = String.valueOf(x).toCharArray();
            int i = 0;
            int j = chars.length - 1;
            while (i != j && i < chars.length / 2){
                if (chars[i] == chars[j]){
                    i++;
                    j--;
                }else {
                    return false;
                }
            }
            return true;
        }
    }
    public static void main(String[] args){
        System.out.println(isPalindrome(12211));
    }

}
