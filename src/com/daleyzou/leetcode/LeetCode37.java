package com.daleyzou.leetcode;

/**
 * @Author: DaleyZou
 * @Description:
 * @Date: Created in 11:29 2018-8-21
 * @Modified By:
 */
public class LeetCode37 {

    /**
     * @Description:
     *               参考链接：https://mp.weixin.qq.com/s/c7RX4I8JQg_i5xJpKI6ZJA
     *               我们需要使用递归来实现深度优先搜索
     * @auther: DaleyZou
     * @date: 17:08 2018-8-21
     * @param: board
     * @return: void
     */
    public void solveSudoku(char[][] board) {
        search(board);
    }

    private boolean search(char[][] board){
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++){
                if (board[i][j] != '.')  // 只有是 .号，也就是空格，我们才能填充数据
                    continue;
                for (char ch = '1'; ch <= '9'; ch++){  // 在board[i][j]中填充 0~9 来测试填入数据后board是否还是一个数独
                    if (!isValid(board, i, j, ch)){
                        continue;
                    }
                    board[i][j] = ch;
                    if (search(board)){
                        return true;
                    }else {
                        board[i][j] = '.';
                    }
                }
                return false;
            }
        }
        return true; // 返回 9 X 9的小格子中所有的点都已经搜索完毕了,退出搜索
    }

    private boolean isValid(char[][] board, int i, int j, char ch) {
        // 行不重复
        for (int col = 0; col < 9; col++){
            if (board[i][col] == ch){
                return false;
            }
        }
        // 列不重复
        for (int row = 0; row < 9; row++){
            if (board[row][j] == ch){
                return false;
            }
        }
        // 3 X 3的小方格不重复
        for (int row = i / 3 * 3; row < i / 3 * 3 + 3; row++){
            for (int col = j / 3 * 3; col < j / 3 * 3 + 3; col++){
                if (board[row][col] == ch){
                    return false;
                }
            }
        }
        return true;
    }

}
