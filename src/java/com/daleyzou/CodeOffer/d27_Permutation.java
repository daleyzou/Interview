package com.daleyzou.CodeOffer;

import com.sun.org.apache.bcel.internal.generic.SWAP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * d27_Permutation
 *
 题目描述
 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。


 输入描述:
 输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
 * @author daleyzou
 * @date 2020年02月03日 23:46
 * @version 3.2.0
 */
public class d27_Permutation {

    ArrayList<String> resultList = new ArrayList<>();

    public ArrayList<String> Permutation(String str) {
        char[] chars = str.toCharArray();
        getAllArrangement(chars, 0);
        Collections.sort(resultList);
        return resultList;
    }

    private void getAllArrangement(char[] chars, int begin) {
        if (chars == null || chars.length <= 0) {
            return;
        }
        if (begin == chars.length - 1) {
            resultList.add(String.valueOf(chars));
            return;
        }
        // 第一个一次和后面的进行交换
        for (int j = begin; j < chars.length; j++) {
            if (isSwap(chars, begin, j)) {
                swap(chars, begin, j);
                getAllArrangement(chars, begin + 1);
                swap(chars,begin, j);
            }
        }
    }

    private boolean isSwap(char[] chars, int i, int length) {
        for (int j = i; j < length; j++) {
            if (chars[i] == chars[length]) {
                return false;
            }
        }
        return true;
    }

    private void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

    public static void main(String[] args) {

        d27_Permutation object = new d27_Permutation();
        ArrayList<String> a = object.Permutation("abc");
        a.stream().forEach(System.out::println);

    }
}
