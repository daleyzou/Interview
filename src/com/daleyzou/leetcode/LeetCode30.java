package com.daleyzou.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
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
    // http://www.cnblogs.com/migoo/p/9454684.html
    // 用了滑动窗口的方法
    public List<Integer> findSubstring_method1(String s, String[] words) {
        List<Integer> result = new ArrayList<Integer>();
        // 如果s，或者是words为空，那么也返回一个空的列表
        if (s.length() == 0 || s == null || words.length == 0 || words == null){
            return result;
        }
        int size = words[0].length(), length = words.length;

        // 把字符串数组中的的字符串全部插入HashMap中
        HashMap<String, Integer> map = generate(words);
        // 窗口的不同的起点，有size个不同的起点
        for (int i = 0; i < size; i++){
            HashMap<String, Integer> window= new HashMap<>();  // 一个滑动的窗口
            int left,right;
            left = right = i;
            while (right <= s.length() - size && left <= s.length() - length * size){
                String word = s.substring(right, right + size);
                incr(window, word);
                if (!map.containsKey(word)){
                    window.clear();
                    right += size;
                    left = right;
                    continue;
                }
                while (window.get(word) > map.get(word)){
                    String w = s.substring(left, left + size);
                    decr(window, w);
                    left += size;
                }
                right += size;
                if (right - left == size * length){
                    result.add(left);
                }
            }
        }
        return result;
    }
    private HashMap<String, Integer> generate(String[] strs){
        HashMap<String, Integer> map = new HashMap<>();
        for (String str : strs){
            incr(map, str);
        }
        return map;
    }

    private void incr(HashMap<String, Integer> map, String str) {
        map.put(str, map.getOrDefault(str,0) + 1);
    }
    private void decr(HashMap<String, Integer> map, String str) {
        Integer num = map.get(str);
        if (num <= 1){
            map.remove(str);
        }else {
            map.put(str, num - 1);
        }
    }

    // 参考博客
    // https://www.nowcoder.com/discuss/87526?type=0&order=0&pos=11&page=0
    // 暴力法
    public List<Integer> findSubstring_method2(String s, String[] words) {
        List<Integer> result = new ArrayList<Integer>();
        if (s.length() == 0 || s == null || words.length == 0 || words == null){
            return result;
        }
        int size = words[0].length();
        int length = words.length;
        // 截取字符串时，取左不取右，所以这里的for循环中i的最大值可以取等号
        for (int i = 0; i <= s.length() - size * length; i++){
            HashMap<String, Integer> map = new HashMap<>();
            for (String word : words){
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
            if (check(s,i,map,size)){
                result.add(i);
            }
        }
        return result;
    }

    private boolean check(String s, int i, HashMap<String, Integer> map, int size) {
        if (map.size() == 0){
            return true;
        }
        if (i > s.length() || i + size > s.length()){
            return false;
        }
        String word = s.substring(i, i + size);
        if (!map.containsKey(word)){
            return false;
        }else {
            Integer num = map.get(word);
            if (num <= 1){
                map.remove(word);
            }else {
                map.put(word, num - 1);
            }

           return check(s, i + size, map, size);
        }
    }

    public static void main(String[] args){
        LeetCode30 leetCode30 = new LeetCode30();

        String[] words = {"foo","bar"};
        List<Integer> results = leetCode30.findSubstring_method2("barfoothefoobarman", words);
        System.out.println(results);
    }
}
