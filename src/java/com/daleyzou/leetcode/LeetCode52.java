/**
 * @projectName Interview
 * @package com.daleyzou.leetcode
 * @className com.daleyzou.leetcode.LeetCode52
 * @copyright Copyright 2019 daleyzou, Inc. All rights reserved.
 */
package com.daleyzou.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode52
 * @description TODO
 * @author daleyzou
 * @date 2019年12月25日 21:27
 * @version 1.0.0
 */
public class LeetCode52 {
    List<List<String>> resultList = new ArrayList<>();
    public int totalNQueens(int n) {
        int[] result = new int[n];
        backTrack(0, n ,result);
        return resultList.size();
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
        List<String> tempList = new ArrayList<>();
        for (int i = 0; i < result.length; i++){
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < result.length; j++){
                if (i == result[j]){
                    sb.append("Q");
                }else {
                    sb.append(".");
                }
            }
            tempList.add(sb.toString());
        }
        resultList.add(tempList);
    }
}
