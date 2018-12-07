package com.daleyzou.leetcode;

/**
 * @Author: DaleyZou
 * @Description:
 * @Date: Created in 14:43 2018-8-2
 * @Modified By:
 */
public class LeetCode14 {

    /**
     * @Description: 编写一个函数来查找字符串数组中的最长公共前缀。
     *
     * 如果不存在公共前缀，返回空字符串 ""。
     * @auther: DaleyZou
     * @date: 10:10 2018-8-3
     * @param: strs
     * @return: java.lang.String
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 1) return strs[0];
        if (strs.length >= 2) {
            int i = 0;
            String result = countCommonPrefix(strs[0], strs[1]);
            if (result.equals("")) return result;
            if (strs.length >=3) {
                for (int j = 2; j < strs.length; j++) {
                    result = countCommonPrefix(result, strs[j]);
                    if (result.equals("")) break;
                }
            }
            return result;
        }
        return "";
    }
    public String countCommonPrefix(String str1, String str2){
        String result = "";
        for (int i = 0; i < Math.min(str1.length(), str2.length()); i++){
            if (str1.charAt(i) == str2.charAt(i)){
                result += str1.charAt(i);
            }else {
                break;
            }
        }
        return result;
    }

    public static void main(String[] args){
        LeetCode14 leetCode14 = new LeetCode14();

        System.out.println("-------------------------------------");
    }
}
