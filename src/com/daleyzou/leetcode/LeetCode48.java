package com.daleyzou.leetcode;

import java.util.Arrays;
import java.util.List;

/**
 * @Author: DaleyZou
 * @Description: 48. 旋转图像
 * @Date: Created in 20:01 2018-9-28
 * @Modified By:
 */
public class LeetCode48 {

    public void rotate(int[][] matrix) {
        int n = matrix[0].length; // 二维数组的宽度
        for (int i = 0; i <= n / 2; i++){  // i代表一个个的小正方形的起点
            for (int j = i; j < n - i - 1; j++){ // j代表当前正方形的每条边上的值
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - j - 1][i];
                matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
                matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
                matrix[j][n - i - 1] = temp;
                System.out.println("("+i+","+j+")->" + "("+j+","+(n - i - 1)+")->"+ "("+(n - i - 1)+","+(n - j - 1)+")->"+ "("+(n - j - 1)+","+i+")->");
            }
        }
    }

    public static void main(String[] args){
        LeetCode48 leetCode48 = new LeetCode48();
        int[][] matrix = {{1,2,3},
                {4,5,6},
                {7,8,9}};
        leetCode48.rotate(matrix);

        Arrays.stream(matrix).forEach(System.out::println);
    }
}
