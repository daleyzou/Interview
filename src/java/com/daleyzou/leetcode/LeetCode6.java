package com.daleyzou.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: DaleyZou
 * @Description:
 * @Date: Created in 10:13 2018-7-24
 * @Modified By:
 */
public class LeetCode6 {

    /**
     * @Description: 将字符串 "PAYPALISHIRING" 以Z字形排列成给定的行数：
     * @auther: DaleyZou
     * @date: 10:14 2018-7-24
     * @param: s
     * @param: numRows
     * @return: java.lang.String
     */
    public static String convert(String s, int numRows) {
        /**
         & &            &     &
         &&&&           &   & &   &
         &&&&           & &   & &
         & &            &     &
         */
        if (s.equals("") || s.length() < numRows){
            return s;
        }
        String[] str = new String[numRows];
        String results = "";
        char[] chars = s.toCharArray();

        int i = 0;
        while (i < chars.length) {
            int tempNumRows = numRows;
            if ((chars.length - i + 1) < numRows){
                tempNumRows = chars.length - i + 1;
                System.out.println(tempNumRows);
            }
            for (int j = 0; j < tempNumRows; j++) {
                if (i >= chars.length){
                    break;
                }
                str[j] += chars[i];
                i++;
            }

            int up = 1;
            if ((chars.length - i + 1) < numRows - 2){
                up = numRows - 3 - (chars.length - i + 1);
            }
            for (int j = numRows - 2; j >= up; j--) {
                if (i >= chars.length){
                    break;
                }
                str[j] += chars[i];
                i++;
            }
        }
        for (int j = 0; j < numRows; j++) {
            results += str[j].substring(4);
        }

        return results;
    }

    /**
     * @Description: 第一次对代码逻辑进行重构
     * @auther: DaleyZou
     * @date: 14:10 2018-7-24
     * @param: s
     * @param: numRows
     * @return: java.lang.String
     */
    public static String convert_restructure1(String s, int numRows){
//        从左到右迭代 s，将每个字符添加到合适的行。可以使用当前行和当前方向这两个变量对合适的行进行跟踪。
//        只有当我们向上移动到最上面的行或向下移动到最下面的行时，当前方向才会发生改变。
        if (s.length() <= numRows || numRows == 1){
            return s;
        }
        boolean isgoing = false;  // 判断是否是在向下读取数据
        int currentPoint = 0;     // 当前正在读取的行指针
        List<StringBuilder> list = new ArrayList<StringBuilder>();
        for (int i = 0; i < numRows; i++){
            list.add(new StringBuilder());
        }
        for (char c : s.toCharArray()){      // 行固定，将数据不断的固定到行中
            list.get(currentPoint).append(c);
            if (currentPoint == 0 || currentPoint == numRows - 1){
                isgoing = !isgoing;
            }
            currentPoint += isgoing?1:-1;
        }
        StringBuilder result = new StringBuilder();
        for (StringBuilder sb : list){
            result.append(sb);
        }


        return result.toString();
    }
    public static void main(String[] args) {

        String s = "ABC";
        String paypalishiring = convert_restructure1(s, 2);
        System.out.println(paypalishiring);
    }
}
