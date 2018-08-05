package com.daleyzou.nowcode;

import java.util.Scanner;

/**
 * @Author: DaleyZou
 * @Description:
 * 给出一个含有n个数字的序列a1,a2,a3,...an，可以进行以下操作：
一次操作定义为对这个序列的每个数字进行以下两种改变之一：
1.ai ÷ 2
2.ai × 3
每一次的操作中，必须保证至少有一个数字是第1种改变；并且经过每次操作后，每一个数字都必须是整数。
牛牛得知，每进行一次操作，他就可以得到一颗西瓜糖，但是由于孱弱的数学功底，
他不知道何时该对某一个数字进行第一种还是第二种改变，
这使得他十分纠结，于是他找来了睿智的你，希望你帮他计算出，他最多可以得到多少颗西瓜糖。
 * @Date: Created in 20:52 2018/8/5
 * @Modified By:
 */
public class NowCode1 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        Integer[] nums = new Integer[num];
        for (int i = 0; i < num; i++){
            nums[i] = scanner.nextInt();
        }

        int result = 0;
        while (true){
            boolean b = false;
            for (int i = 0; i < num; i++){
                if (b){
                    nums[i] = nums[i] * 3;
                    continue;
                }
                if (nums[i] % 2 == 0){
                    //if ((nums[i] / 2) % 2 == 0){
                    nums[i] = nums[i] / 2;
                    b = true;
                   // }
                }else {
                    nums[i] = nums[i] * 3;
                }

            }
            if (!b) break;
            result++;
        }
        System.out.println(result);
//        for (int i = 0; i < num; i++){
//            System.out.println(nums[i]);
//        }
    }
}
