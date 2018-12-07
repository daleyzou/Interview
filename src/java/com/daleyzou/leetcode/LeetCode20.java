package com.daleyzou.leetcode;

/**
 * @Author: DaleyZou
 * @Description:
 * @Date: Created in 23:20 2018/8/6
 * @Modified By:
 */
public class LeetCode20 {
    public boolean isValid(String s) {
        StringBuffer sb = new StringBuffer(s);
       int i = 0;
       while ( i < s.length()){
           while (sb.indexOf("()") != -1){
               sb.delete(sb.indexOf("()"), sb.indexOf("()") + 2);
           }
           while (sb.indexOf("[]") != -1){
               sb.delete(sb.indexOf("[]"), sb.indexOf("[]") + 2);
           }
           while (sb.indexOf("{}") != -1){
               sb.delete(sb.indexOf("{}"), sb.indexOf("{}") + 2);
           }
           i++;
       }

        if (sb.length() == 0){
            return true;
        }else {
            return false;
        }
    }


    public static void main(String[] args){
        LeetCode20 leetCode20 = new LeetCode20();


        System.out.println();
    }
}
