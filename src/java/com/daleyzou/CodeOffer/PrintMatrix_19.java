package com.daleyzou.CodeOffer;

import java.util.ArrayList;

/**
 * PrintMatrix_19
 * @description TODO
 * @author daleyzou
 * @date 2020年01月08日 20:29
 * @version 3.1.2
 */
public class PrintMatrix_19 {

    /***
     * 终于搞出来了，这种做法太 low 了
     */
    public ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> resultList = new ArrayList<>(matrix.length * matrix[0].length);
        for (int i = 0; i <= matrix.length / 2; i++) {
            int rowBegin = i;
            int rowEnd = matrix.length - rowBegin - 1;

            if (rowBegin > matrix[0].length - rowBegin - 1){
                break;
            }
            if (rowBegin > rowEnd){
                break;
            }

            for (int j = rowBegin; j <= matrix[0].length - rowBegin - 1; j++) {
                resultList.add(matrix[rowBegin][j]);
            }

            if (rowBegin == rowEnd) {
                break;
            }
            for (int j = rowBegin + 1; j < rowEnd; j++) {
                resultList.add(matrix[j][matrix[0].length - rowBegin - 1]);
            }
            for (int j = matrix[0].length - rowBegin - 1; j >= rowBegin; j--) {
                resultList.add(matrix[rowEnd][j]);
            }
            if (rowBegin == matrix[0].length - rowBegin - 1){
                break;
            }
            for (int j = rowEnd - 1; j > rowBegin; j--) {
                resultList.add(matrix[j][rowBegin]);
            }

        }
        return resultList;
    }

    public static void main(String[] args) {
        int[][] matrix = { { 1,2 }, { 3,4 }, { 5,6 }, { 7,8 }, { 9,10 } };
        PrintMatrix_19 object = new PrintMatrix_19();
        ArrayList<Integer> integers = object.printMatrix(matrix);
        integers.forEach(System.out::print);

    }
}
