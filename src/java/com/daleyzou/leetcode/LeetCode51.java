package com.daleyzou.leetcode;

import java.lang.management.MemoryType;
import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode51
 * @description https://www.cnblogs.com/daleyzou/p/NQueen.html
 * @author daleyzou
 * @date 2019年12月25日 12:45
 * @version 3.1.0
 */
public class LeetCode51 {
    List<List<String>> resultList = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {

        int[] result = new int[n];
        backTrack(0, n, result);
        return resultList;
    }

    private void backTrack(int row, int n, int[] result) {
        if (row == n){
            printResult(result);
            return;
        }
        for (int column = 0; column < n; column++){
            if (isOK(row, column, result)){
                result[row] = column;
                backTrack(row + 1, n, result);
            }
        }

    }

    private boolean isOK(int row, int column, int[] result) {
        for (int i = 0; i < row; i++){
            if (column == result[i] || Math.abs(column - result[i]) == Math.abs(row - i)){
                return false;
            }
        }
        return true;
    }

    private void printResult(int[] result) {
        List<String> item = new ArrayList<>();
        for (int i = 0; i < result.length; i++){
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < result.length; j++){
                if (j == result[i]){
                    sb.append("Q");
                }else {
                    sb.append(".");
                }
            }
            item.add(sb.toString());
        }
        resultList.add(item);
    }
}
