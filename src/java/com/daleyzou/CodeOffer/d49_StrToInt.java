package com.daleyzou.CodeOffer;

import com.sun.deploy.util.StringUtils;

/**
 * d49_StrToInt
 * @description 将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。
 *              数值为0或者字符串不是一个合法的数值则返回0
 * @author daleyzou
 * @date 2020年03月01日 23:01
 * @version 3.3.0
 */
public class d49_StrToInt {
    public int StrToInt(String str) {
        if (str == null || str.length() <= 0){
            return 0;
        }
        char[] chars = str.toCharArray();
        boolean symble = true;
        char aChar = chars[0];
        if ('+' == aChar){
            if (str.length() == 1){
                return 0;
            }
            chars = str.substring(1).toCharArray();
        }
        if ('-' == aChar){
            if (str.length() == 1){
                return 0;
            }
            chars = str.substring(1).toCharArray();
            symble = false;
        }
        int[] results = new int[chars.length];
        try {
            for (int i = 0; i < chars.length; i++){
                int numFromChar = getNumFromChar(chars[i]);
                results[i] = numFromChar;
            }
        }catch (Exception e){
            return 0;
        }
        int result = 0;
        int j = 0;
        for (int i = results.length - 1; i >= 0; i--){
            int temp = results[i] * (int)Math.pow(10, j);
            if (Integer.MAX_VALUE - result < temp){
                if (!symble && Integer.MAX_VALUE - result == -1){

                }else {

                    return 0;
                }
            }
            result += temp;
            j++;
        }
        if (!symble){
            return 0 - result;
        }
        return result;
    }
    public int getNumFromChar(char ch){
        int result = 0;
        switch (ch){
            case '0':
                result = 0;
                break;
            case '1':
                result = 1;
                break;
            case '2':
                result = 2;
                break;
            case '3':
                result = 3;
                break;
            case '4':
                result = 4;
                break;
            case '5':
                result = 5;
                break;
            case '6':
                result = 6;
                break;
            case '7':
                result = 7;
                break;
            case '8':
                result = 8;
                break;
            case '9':
                result = 9;
                break;
            default:
                throw new RuntimeException();
        }
        return result;
    }

    public static void main(String[] args){
        d49_StrToInt object = new d49_StrToInt();
        String str = "-2147483649";
        int i = object.StrToInt(str);
        System.out.println(i);
    }
}
