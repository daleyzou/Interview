package com.daleyzou.leetcode;

/**
 * @Author: DaleyZou
 * @Description:
 * @Date: Created in 7:23 2018/7/27
 * @Modified By:
 */
public class LeetCode12 {

    /**
     * @Description: 整数转罗马数字
     * @auther: DaleyZou
     * @date: 11:24 2018-7-27
     * @param: num
     * @return: java.lang.String
     */
    public String intToRoman(int num) {

        char[] chars = {'I','V','X','L','C','D','M'}; // 没有用
        int [] ints = {1,5,10,50,100,500,1000};         // 没有用

        // 特殊值列表
        String[] specialValues = new String[1001];
        specialValues[1] = "I";
        specialValues[5] = "V";
        specialValues[10] = "X";
        specialValues[50] = "L";
        specialValues[100] = "C";
        specialValues[500] = "D";
        specialValues[1000] = "M";


        // 特殊的不按照从左到右的顺序是大值到小值的套路
        specialValues[4] = "IV";
        specialValues[9] = "IX";
        specialValues[40] = "XL";
        specialValues[90] = "XC";
        specialValues[400] = "CD";
        specialValues[900] = "CM";

        String str = String.valueOf(num);
        String strReverse = new StringBuilder(str).reverse().toString();
        String result = "";
        for (int i = 0; i < str.length(); i++){
            int value = Integer.parseInt(str.charAt(i) + "");
            int digit = (int)Math.pow(10, str.length() - i - 1);   // 得到位数  比如：将1940，那么digit=1000,100,10,1
            value = value * digit;
            System.out.println(value);
            if (value == 4 || value == 9 || value == 40 || value == 90 || value == 400 || value == 900){
                result += specialValues[value];
            }else {
                int temp = (int)Math.pow(10, str.length() - i) / 2; // 得到中间数，比如5，50,500  因为罗马数字小于他们是一种表示法，而大于他们又是一种表示法
                if (value < temp){
                    int p = value / digit;
                    for (int j = 1; j <= p; j++){
                        result += specialValues[digit];    // 比如3的表示：III,其实就是把I循环了三次
                    }
                }else {
                    result += specialValues[temp];
                    int p = (value - temp) / digit;
                    for (int j = 1; j <= p; j++){
                        result += specialValues[digit];   // 比如7的表示：VII,就是（5+2）V + I循环两次
                    }
                }
            }
        }
        return result;
    }
    public static void main(String[] args){

        LeetCode12 leetCode12 = new LeetCode12();
        int str1 = 1994;
        System.out.println(leetCode12.intToRoman(str1));
    }
}
