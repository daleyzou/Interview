package com.daleyzou.algorithm;

/**
 * @Author: DaleyZou
 * @Description: java实现大数的乘法
 * @Date: Created in 22:56 2018/10/29
 * @Modified By:
 */
public class BigMultiply {

    // 参考链接：https://blog.csdn.net/antgan/article/details/51044098
    // 公式：AB*CD = AC (BC+AD) BD
    public String multiply(String str1, String str2){
        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();
        int[] ints1 = new int[str1.length()];
        int[] ints2 = new int[str2.length()];

        for (int i = 0; i < str1.length(); i++){
            ints1[i] = chars1[i] - '0';
        }
        for (int i = 0; i < str2.length(); i++){
            ints2[i] = chars2[i] - '0';
        }
        int[] resultInts = new int[str1.length()+str2.length()];
        for (int i = 0; i < str1.length(); i++){
            for (int j = 0; j < str2.length(); j++){
                resultInts[i + j] += ints1[i] * ints2[j];
            }
        }
        // 从后往前 满10进位
        for (int i = resultInts.length - 1; i >= 1; i--){
            resultInts[i - 1] += resultInts[i] / 10;
            resultInts[i] = resultInts[i] % 10;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < resultInts.length - 1; i++){
            sb.append(resultInts[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args){
        String str1 = "2";
        String str2 = "1";
        BigMultiply bigMultiply = new BigMultiply();
        String result = bigMultiply.multiply(str1, str2);
        System.out.println(result);
    }
}
