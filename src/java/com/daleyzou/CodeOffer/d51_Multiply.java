package com.daleyzou.CodeOffer;

/**
 * d51_Multiply
 * @description
 *
 * 给定一个数组A[0, 1, ..., n-1],
 * 请构建一个数组B[0,1,...,n-1],其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。
 * 不能使用除法。（注意：规定B[0] = A[1] * A[2] * ... * A[n-1]，B[n-1] = A[0] * A[1] * ... * A[n-2];）
 *
 * @author daleyzou
 * @date 2020年03月09日 23:01
 * @version 3.3.0
 */
public class d51_Multiply {
    /***
     * @Description: https://www.nowcoder.com/questionTerminal/94a4d381a68b47b7a8bed86f2975db46?f=discussion
     *               看看大家的吧
     * @date: 23:20 2020/3/9
     * @param: A
     * @return: int[]
     */
    public int[] multiply(int[] A) {
        int[] result = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            int count = 1;
            for (int j = 0; j < A.length; j++) {
                if (i == j) {
                    continue;
                }
                count = count * A[j];
            }
            result[i] = count;
        }

        return result;
    }

    /**
     *
     * B[i]的意义是A数组不包括i位置的所有乘积，分为 i左边的元素乘积和 i右边的所有元素乘积。
     * 第一个for计算i左边的乘积，第二个for计算右边的。初始化B[0]=1，是因为0左边没有元素，所以乘积为1。
     *
     */
    public int[] multiply_2(int[] A) {
        int length = A.length;
        int[] B = new int[length];
        if (length != 0) {
            // 计算下三角连乘
            B[0] = 1;
            for (int i = 1; i < length; i++) {
                B[i] = B[i - 1] * A[i-1];
            }
            int temp = 1;
            // 计算上三角连乘
            for (int j = length - 2; j >= 0; j--) {
                temp *= A[j + 1];
                B[j] *= temp;
            }
        }
        return B;
    }
}
