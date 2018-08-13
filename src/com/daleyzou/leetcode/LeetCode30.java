package com.daleyzou.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: DaleyZou
 * @Description:
 * @Date: Created in 15:49 2018-8-8
 * @Modified By:
 */
public class LeetCode30 {
    public List<Integer> findSubstring1(String s, String[] words) {// 思想错误，如果words中有重复的字符串就无法判别
        List<Integer> result = new ArrayList<Integer>();
        if (words.length == 0 || s.length() == 0){
            return result;
        }
        label:
        for (int j = 0; j < s.length() - words[0].length() * words.length;j++){
            String str = s.substring(j, j + words[0].length() * words.length);
            int[] array = new int[words.length];
            for(int i = 0; i < words.length; i++){
                array[i] = str.indexOf(words[i]);
                if (array[i] == -1){
                    //break label;
                    continue label;
                }
            }
            Arrays.sort(array);
            for (int i = 0; i < array.length - 1; i++){
                if (array[i] + words[0].length() != array[i+1]){
                    //break label;
                    continue label;
                }
            }
            result.add(j);
        }

        return result;
    }

    // 参考博客：
    // https://www.nowcoder.com/discuss/87526?type=0&order=0&pos=11&page=0
    // http://www.cnblogs.com/migoo/p/9454684.html
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<Integer>();

        return result;
    }

    public static void main(String[] args){
        LeetCode30 leetCode30 = new LeetCode30();

        String[] words = {"foo","bar"};
        List<Integer> results = leetCode30.findSubstring("barfoothefoobarman", words);
        System.out.println(results);
    }
}
