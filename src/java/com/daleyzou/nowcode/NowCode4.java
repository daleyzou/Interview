package com.daleyzou.nowcode;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: DaleyZou
 * @Description:
 * 有一个长度为N的序列。一开始，这个序列是1, 2, 3,... n - 1, n的一个排列。
 *
 * 对这个序列，可以进行如下的操作：
 *
 * 每次选择序列中k个连续的数字，然后用这k个数字中最小的数字替换这k个数字中的每个数字。
 *
 * 我们希望进行了若干次操作后，序列中的每个数字都相等。请你找出需要操作的最少次数。
 * @Date: Created in 9:07 2018-8-6
 * @Modified By:
 */
/**
 输入描述:
 第一行：两个数字n, k，含义如题，满足2 <= k <= n <= 105；

 第二行：n个数字，是1, 2, 3,...n的一个排列。



 输出描述:
 一个整数，表示最少的次数。

 输入例子1:
 2 2
 2 1

 输出例子1:
 1
 */
public class NowCode4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int result = 0;
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] arrays = new int[n];
        for (int i = 0; i < n; i++){
            arrays[i] = scanner.nextInt();
        }
        int temp = 0;
        while (true){
            result++;
            temp =  temp + k - 1;
            if (temp >= arrays.length - 1) {
                break;
            }
        }
        // 输出最后的次数
        System.out.println(result);
    }
}
