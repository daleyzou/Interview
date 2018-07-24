package com.daleyzou.leetcode;

/**
 * @Author: DaleyZou
 * @Description:
 * @Date: Created in 22:19 2018/7/24
 * @Modified By:
 */
public class LeetCode8 {

    /**
     * @Description: 将字符串转为整数
     * @auther: DaleyZou
     * @date: 22:20 2018/7/24
     * @param: str
     * @return: int
     */
    public static int myAtoi(String str) {
        str = str.trim();
        //str = str.replace(" ", "");
        if (str.length() == 0){
            // 或字符串为空；或字符串仅包含空白字符时
            return 0;
        }

        char[] chars = str.toCharArray();
        if (!('-'==chars[0]) && !('+'==chars[0])){
            if (!Character.isDigit(chars[0])){
                return 0; // 第一个既不是符号位，也不是数字
            }
        }

        boolean single = false;// 判断是否存在符号位
        int begin = 0;
        if (!Character.isDigit(chars[0])){
            if ('+'==chars[0] || '-'==chars[0]){
                //chars[1]   || '0'==chars[1]
                if (chars.length > 1){
                    if (!Character.isDigit(chars[1])){// 符号位后面不为数字
                        return 0;
                    }else {
                        begin = 1;
                        if ('-'==chars[0]){
                            single = true;  //存在负号
                        }else {
                            if ('0'==chars[1]){  // 处理这样的"-000000000000001" 和+00000000000001
                                return 0;
                            }
                        }
                    }
                }else { //字符串去空格后长度为1，且不存在数字
                    return 0;
                }
            }
        }else {
            begin = 0;
        }


        StringBuilder sb = new StringBuilder();
        for (int i = begin; i < chars.length; i++){
            if (Character.isDigit(chars[i])){
                sb.append(chars[i]);
            }else {
                break;
            }
        }
        int result;
        try {
            result = Integer.parseInt(sb.toString());
            if (single){
                result = 0 - result;
            }
        }catch (Exception e){
            if (single){
                return Integer.MIN_VALUE;
            }else {
                return Integer.MAX_VALUE;
            }
        }

        //System.out.println(str);
        return result;
    }


    public static void main(String[] args){
        String str1 = "                -00000100d              a           l e y          ";
        String str2 = "1";
        int i = myAtoi(str1);
        //System.out.println(Integer.MIN_VALUE);
        System.out.println(i);
    }
}
