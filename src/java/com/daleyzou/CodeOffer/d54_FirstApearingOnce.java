package com.daleyzou.CodeOffer;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * d54_FirstApearingOnce
 * @description TODO
 * @author daleyzou
 * @date 2020年11月19日 20:59
 * @version 1.1.1
 */
public class d54_FirstApearingOnce {
        Map<Character, Integer> tempMap = new LinkedHashMap<>();
        StringBuilder stringBuilder = new StringBuilder();
    //    public void Insert(char ch)
    //    {
    //        if (tempMap.containsKey(ch)){
    //            tempMap.remove(ch);
    //        }else {
    //            tempMap.put(ch, 1);
    //        }
    //    }
        //return the first appearence once char in current stringstream
        public char FirstAppearingOnce_1()
        {
            if (tempMap.size() == 0){
                return '#';
            }else {
               return tempMap.entrySet().iterator().next().getKey();
            }
        }

    /**
     *  请实现一个函数用来找出字符流中第一个只出现一次的字符。
     *  例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。
     *  当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
     */
    //Insert one char from stringstream
//    public void Insert(char ch) {
//
//    }

    //return the first appearence once char in current stringstream
//    public char FirstAppearingOnce() {
//        String str = stringBuilder.toString();
//        int[] nums = new int[128];
//        for (int i = 0; i < str.length();i ++){
//            nums[str.charAt(i)]++;
//        }
//        for (int i = 0;  i < nums.length; i++){
//            if (nums[i] == 1){
//
//            }
//        }
//        return '#';
//    }

    int[] charCnt = new int[128];
    Queue<Character> queue = new LinkedList<Character>();

    //Insert one char from stringstream
    public void Insert(char ch) {
        if (charCnt[ch]++ == 0) //新来的单身字符，入队
            queue.add(ch);
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        Character CHAR = null;
        char c = 0;
        while ((CHAR = queue.peek()) != null) {
            c = CHAR.charValue();
            if (charCnt[c] == 1) //判断是否脱单了，没脱单则输出
                return c;
            else queue.remove(); //脱单了就移出队列，它不会再回来了
        }
        return '#'; //队空，返回#
    }
    public static void main(String[] args){

        int i = 'c';
        System.out.println(i);
        int j = 'a';
        System.out.println(j);
        int t = 'A';
        System.out.println(t);
    }
}
