package com.daleyzou.CodeOffer;

/**
 * d53_IsNumeric
 * @description
 *
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
 * 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 *
 * @author daleyzou
 * @date 2020年11月18日 22:33
 * @version 1.3.1
 */
public class d53_IsNumeric {
    public boolean isNumeric_1(char[] str) {
        try {
            double v = Double.parseDouble(str.toString());
            return true;
        }catch (Exception exception){
            return false;
        }
    }

    /**
     *  + - 只出现在第一位或者 eE的后一位
     *  + —— 后紧跟着一定是 数字 或者是 .
     *
     *  eE只出现一次，后面必定为数字或者 + ——
     *  .只出现一次， 后面必定为数字或者最后一位
     *
     * @param str
     * @return
     * @author daleyzou
     */
    public boolean isNumeric(char[] str) {
        if (str.length == 0){
            return false;
        }



        return false;
    }


    public static void main(String[] args){
        d53_IsNumeric test = new d53_IsNumeric();
        System.out.println("-1E-16 : " + test.isNumeric("-1E-16".toCharArray()));;
    }
}
