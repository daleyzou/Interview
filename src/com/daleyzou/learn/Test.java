package com.daleyzou.learn;

import java.util.Arrays;

/**
 * @Author: DaleyZou
 * @Description:
 * @Date: Created in 19:55 2018/8/5
 * @Modified By:
 */
public class Test {
    public static void main(String[] args) {
        String a=new String("A");
        String b=new String("B");
        oper(a,b);
        System.out.println(a+","+b);

        String a1 = new String("A");
        String b1 = new String("B");
        a1.concat("aa");
        System.out.println(a1 + "," + b1);

        int[] as = new int[]{3,2,1};
        Arrays.sort(as);
    }
    static void oper(String c,String d){
        c.concat("B");
        d=c;
    }

}
