package com.daleyzou.leetcode;

import java.util.*;

/**
 * @Author: DaleyZou
 * @Description: 49. 字母异位词分组
 * @Date: Created in 21:40 2018-9-28
 * @Modified By:
 */
public class LeetCode49 {
    /**
     * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
     *
     * 示例:
     *
     * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
     * 输出:
     * [
     *   ["ate","eat","tea"],
     *   ["nat","tan"],
     *   ["bat"]
     * ]
     */

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();

        Map<HashMap<Character, Integer>, List<String>> anagrams = new HashMap<>();
        for (String str : strs){
            HashMap<Character, Integer> frequency = new HashMap<>();
            for (Character c : str.toCharArray()){
                frequency.put(c, frequency.getOrDefault(c, 0) + 1);
            }

            List<String> stringList = anagrams.get(frequency);
            if (stringList == null){ // 不包含
                stringList = new ArrayList<>();
            }
            stringList.add(str);
            anagrams.put(frequency, stringList);
        }
        for (HashMap<Character, Integer> map:anagrams.keySet()){
            result.add(anagrams.get(map));
        }
        return result;
    }
}
