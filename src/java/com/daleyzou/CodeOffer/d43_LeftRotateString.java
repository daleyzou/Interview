package com.daleyzou.CodeOffer;

/**
 * d43_LeftRotateString
 * @description 汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，
 * 就是用字符串模拟这个指令的运算结果。对于一个给定的字符序列S，
 * 请你把其循环左移K位后的序列输出。
 * 例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。是不是很简单
 * @author daleyzou
 * @date 2020年02月21日 0:19
 * @version 1.1.11
 */
public class d43_LeftRotateString {
    public String LeftRotateString(String str,int n) {
        if (str == null || str.length() <= 1){
            return str;
        }
        n = (n % str.length());
        if (n == 0){
            return str;
        }
        String beginStr = str.substring(0, n);
        String endStr = str.substring(n);
        return endStr+beginStr;
    }

    public static void main(String[] args){
        d43_LeftRotateString object = new d43_LeftRotateString();
        String str = "abcXYZdef";
        String s = object.LeftRotateString(str, 3);
        System.out.println(s);
    }
}
