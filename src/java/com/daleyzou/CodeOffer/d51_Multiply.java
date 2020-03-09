package com.daleyzou.CodeOffer;

/**
 * d51_Multiply
 * @description
 *
 * 给定一个数组A[0,1,...,n-1],
 * 请构建一个数组B[0,1,...,n-1],其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。
 * 不能使用除法。（注意：规定B[0] = A[1] * A[2] * ... * A[n-1]，B[n-1] = A[0] * A[1] * ... * A[n-2];）
 *
 * @author daleyzou
 * @date 2020年03月09日 23:01
 * @version 3.3.0
 */
public class d51_Multiply {
    public int[] multiply(int[] A) {
        int[] result = new int[A.length];
        for (int i = 0; i < A.length; i++){
            int count = 1;
            for (int j = 0; j < A.length; j++){
                if (i == j){
                    continue;
                }
                count = count * A[j];
            }
            result[i] = count;
        }

        return result;
    }
}
