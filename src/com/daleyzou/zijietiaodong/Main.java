package com.daleyzou.zijietiaodong;

import java.util.Scanner;

/**
 * @Author: DaleyZou
 * @Description:
 * @Date: Created in 19:01 2018/11/5
 * @Modified By:
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {//注意while处理多个case
            int a = in.nextInt();
            int b = in.nextInt();
            int result = 0;
            int i = 1;
            while (i <= b){
                result += a / i;
                i++;
                if (i > a){
                    break;
                }
            }
            System.out.println(result);
        }
    }
}
