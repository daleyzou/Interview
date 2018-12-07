package com.daleyzou.nowcode;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * @Author: DaleyZou
 * @Description:
 * 牛牛很喜欢对数字进行比较，但是对于3 > 2这种非常睿智的比较不感兴趣。
 * 上了高中之后，学习了数字的幂，他十分喜欢这种数字表示方法，比如xy。
由此，他想出了一种十分奇妙的数字比较方法，给出两个数字x和y，
请你比较xy和yx的大小，如果前者大于后者，输出">"，小于则输出"<"，等于则输出"="。
 * @Date: Created in 21:15 2018/8/5
 * @Modified By:
 */
public class NowCode2 {
    public static void main1(String[] args){  // 解法一，超时
        Scanner scanner = new Scanner(System.in);
        BigInteger num1 = new BigInteger(scanner.nextInt() + "");
        BigInteger num2 = new BigInteger(scanner.nextInt() + "");
        if (num1 == num2){
            System.out.println("=");
            return;
        }
        int temp1 = num1.intValue();
        int temp2 = num2.intValue();
        for (int i = 0; i < temp2 - 1; i++){
            //num1 = num1 * temp1;
            num1 = num1.multiply(BigInteger.valueOf(temp1));
        }
        for (int i = 0; i < temp1 - 1; i++){
            //num2 = num2 * temp2;
            num2 = num2.multiply(BigInteger.valueOf(temp2));
        }

        int i = num1.compareTo(num2);
        if (i == 0) {
            System.out.println("=");
        }else if (i == -1){
            System.out.println("<");
        }else {
            System.out.println(">");
        }
    }

    public static void main(String[] args){



        // 解法二
        Scanner in = new Scanner(System.in);
        double x = in.nextDouble();
        double y = in.nextDouble();
        double sumx = y * Math.log(x);
        double sumy = x * Math.log(y);

        if (sumx == sumy){
            System.out.println("=");
        }else if (sumx < sumy){
            System.out.println("<");
        }else {
            System.out.println(">");
        }

    }
}
