package com.daleyzou.leetcode;

/**
 * @Author: DaleyZou
 * @Description:
 * 提示一；
1.     1
2.     11
3.     21
4.     1211
5.     111221
6.     312211
7.     13112221
8.     1113213211
9.     31131211131221
10.     13211311123113112211
 * 提示二：
To generate the nth term, just count and say the n-1th term.
 * @Date: Created in 11:02 2018-8-22
 * @Modified By:
 */
public class LeetCode38 {
    public String countAndSay(int n) {
        String start = "1";
        for (int i = 1; i < n; i++){
            char[] chars = start.toCharArray();
            int begin = 0;
            StringBuffer sb = new StringBuffer();
            while (begin < chars.length){
                int count = 0;
                char ch = chars[begin];
                while (begin < chars.length && chars[begin] == ch){
                    count++;
                    begin++;
                }
                sb.append(count + "" + ch);
            }
            start = sb.toString();
        }
        return start;
    }
}
