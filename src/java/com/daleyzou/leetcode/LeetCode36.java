package com.daleyzou.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: DaleyZou
 * @Description:
 * @Date: Created in 9:31 2018-8-21
 * @Modified By:
 */
public class LeetCode36 {
    public boolean isValidSudoku(char[][] board) {
        boolean result = false;
        for (int i = 0; i < 9; i++){
            Map<Integer, Integer> row = new HashMap<>();  // 行的map
            Map<Integer, Integer> column = new HashMap<>();  // 列的map

            for (int j = 0; j < 9; j++){
                // 数字 1-9 在每一行只能出现一次。
                if (Character.isDigit(board[i][j])){
                    int num = (int)board[i][j] - (int)('0');
                    if (row.containsKey(num)){
                        return false;
                    }else {
                        row.put(num,1);
                    }
                }

                // 数字 1-9 在每一列只能出现一次。
                if (Character.isDigit(board[j][i])){
                    int num = (int)board[j][i] - (int)('0');
                    if (column.containsKey(num)){
                        return false;
                    }else {
                        column.put(num,1);
                    }
                }
            }
        }

        // 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次
        for (int i = 0; i <= 6; i = i + 3){
            for (int j = 0; j <= 6; j = j + 3){
                Map<Integer, Integer> block = new HashMap<>();
                for (int p = 0; p <= 2; p++){ // 遍历3x3 的格子
                    for (int q = 0; q <= 2; q++){
                        if (Character.isDigit(board[i + p][j + q])){
                            int num = (int)board[i + p][j + q] - (int)('0');
                            if (block.containsKey(num)){
                                return false;
                            }else {
                                block.put(num,1);
                            }
                        }
                    }
                }
            }
        }
        result = true;
        return result;
    }

    public static void main(String[] args){
        LeetCode36 leetcode36 = new LeetCode36();

        char[][] board =  {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };
        boolean validSudoku = leetcode36.isValidSudoku(board);
        System.out.println(validSudoku);
    }
}
