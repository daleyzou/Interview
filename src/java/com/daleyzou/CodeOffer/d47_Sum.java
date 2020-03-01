package com.daleyzou.CodeOffer;

/**
 * d47_Sum
 * @description 1+2+3+...+n，
 * 要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）
 * @author daleyzou
 * @date 2020年03月01日 21:02
 * @version 3.3.0
 */
public class d47_Sum {

    public int Sum_Solution_1(int n) {
        int ans = n;
        boolean stauts = (ans>0) && ((ans += Sum_Solution_1(n - 1))>0);
        return ans;
    }

    public int Sum_Solution(int n) {
        int sum = (int)(Math.pow(n, 2) + n) >> 1;
        return 0;
    }
}
