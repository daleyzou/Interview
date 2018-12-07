package com.daleyzou.leetcode;

/**
 * @Author: DaleyZou
 * @Description: 58. 最后一个单词的长度
 * @Date: Created in 16:30 2018-10-12
 * @Modified By:
 */
public class LeetCode58 {

    public int lengthOfLastWord(String s) {
        if (s.length() == 0 || s == null){
            return 0;
        }
        if (s.replace(" ","").length() == 0){
            return 0;
        }
        String[] split = s.split(" ");
        return split[split.length - 1].length();
    }
}
