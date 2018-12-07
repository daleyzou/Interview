package com.daleyzou.algorithm;

/**
 * @Author: DaleyZou
 * @Description: 递归实现 “汉诺塔” 算法
 * @Date: Created in 17:39 2018-9-21
 * @Modified By:
 */
public class Hanoi {
    public static void move(int number, String from, String buffer, String to){

        if (number == 1){
            System.out.println("from: " + from + " to " + to);
            return;
        }

        move(number - 1, from, to, buffer);
        move(1, from, buffer, to);
        move(number - 1, buffer, from, to);
    }

    public static void main(String[] args){
        Hanoi.move(3, "H1", "H2", "H3");
    }

}
