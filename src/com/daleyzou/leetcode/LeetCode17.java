package com.daleyzou.leetcode;

import java.util.*;

/**
 * @Author: DaleyZou
 * @Description:
 * @Date: Created in 20:20 2018/8/6
 * @Modified By:
 */
public class LeetCode17 {


    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<String>();
        if(digits.equals("")) return list;
        Map<String,List<String>> map = new HashMap<String, List<String>>();

        List<String> list2 = new ArrayList<String>();
        list2.add("a");
        list2.add("b");
        list2.add("c");

        List<String> list3 = new ArrayList<String>();
        list3.add("d");
        list3.add("e");
        list3.add("f");

        List<String> list4 = new ArrayList<String>();
        list4.add("g");
        list4.add("h");
        list4.add("i");

        List<String> list5 = new ArrayList<String>();
        list5.add("j");
        list5.add("k");
        list5.add("l");

        List<String> list6 = new ArrayList<String>();
        list6.add("m");
        list6.add("n");
        list6.add("o");

        List<String> list7 = new ArrayList<String>();
        list7.add("p");
        list7.add("q");
        list7.add("r");
        list7.add("s");

        List<String> list8 = new ArrayList<String>();
        list8.add("t");
        list8.add("u");
        list8.add("v");

        List<String> list9 = new ArrayList<String>();
        list9.add("w");
        list9.add("x");
        list9.add("y");
        list9.add("z");
        map.put("2",list2);
        map.put("3",list3);
        map.put("4",list4);
        map.put("5",list5);
        map.put("6",list6);
        map.put("7",list7);
        map.put("8",list8);
        map.put("9",list9);
        char[] chars = digits.toCharArray();
//        System.out.println(String.valueOf(chars[0]));
//        System.out.println(map.get(2+""));
        if (chars.length == 1){
            return map.get(digits);
        }
        List<String> result = combinationTwoList(map.get(String.valueOf(chars[0])), map.get(String.valueOf(chars[1])));
        if (digits.length() > 2){
            for (int j = 2; j < chars.length; j++){
                result = combinationTwoList(result, map.get(String.valueOf(chars[j])));
            }
        }
        return result;
    }
    public List<String> combinationTwoList(List<String> list1, List<String> list2){
//        System.out.println(list1);
//        System.out.println(list2);
        List<String> result = new ArrayList<String>();
        for (int i = 0; i < list1.size(); i++){
            for (int j = 0; j < list2.size(); j++){
                result.add(list1.get(i) + list2.get(j));
            }
        }
//        System.out.print("combinationTwoList: ");
//        System.out.println(result);
        return result;
    }

    public static void main(String[] args){
        LeetCode17 leetCode17 = new LeetCode17();

        System.out.println(leetCode17.letterCombinations("234"));
    }
}
