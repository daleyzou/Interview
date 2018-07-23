package com.daleyzou.leetcode;

/**
 * @Author: DaleyZou
 * @Description:
 * @Date: Created in 22:41 2018/7/23
 * @Modified By:
 */
public class LeetCode3 {
    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 0 || s.equals("")){
            return 0;
        }
        char[] chars = s.toCharArray();
        int temp = 0;
        for (int i = 0; i < chars.length; i++){
            String str = "";
            for (int j = i; j < chars.length; j++){
                if (str.contains(chars[j]+"")){
                    break;
                }else {
                    str += (chars[j]+"");
                }
            }
            if (str.length() > temp){
                temp = str.length();
            }
        }
        return temp;
    }

    public static void main(String[] args){
        String s = "abcccabcde";
        int i = lengthOfLongestSubstring(s);
        System.out.println(i);
    }
}
