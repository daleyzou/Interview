package com.daleyzou.leetcode;

/**
 * @Author: DaleyZou
 * @Description: 59. 螺旋矩阵 II
 * @Date: Created in 16:34 2018-10-12
 * @Modified By:
 */
public class LeetCode59 {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int num = 1;
        int left = 0;
        int right = n - 1;
        int top = 0;
        int bottom = n - 1;


        while (true){
            // left -> right
            for (int i = left; i <= right; i++){
                result[left][i] = num++;
            }
            top++;
            if (left > right || top > bottom) break;

            // top -> bottom
            for (int i = top; i <= bottom; i++){
                result[i][right] = num++;
            }
            right--;
            if (left > right || top > bottom) break;

            // right -> left
            for (int i = right; i >= left; i--){
                result[bottom][i] = num++;
            }
            bottom--;
            if (left > right || top > bottom) break;

            // bottom -> top
            for (int i = bottom; i >= top; i--){
                result[i][left] = num++;
            }
            left++;
            if (left > right || top > bottom) break;
        }

        return result;
    }
}
