package leetcode.editor.cn;//给你一个 n x n 的 方形 整数数组 matrix ，请你找出并返回通过 matrix 的下降路径 的 最小和 。
//
// 下降路径 可以从第一行中的任何元素开始，并从每一行中选择一个元素。在下一行选择的元素和当前行所选元素最多相隔一列（即位于正下方或者沿对角线向左或者向右的第
//一个元素）。具体来说，位置 (row, col) 的下一个元素应当是 (row + 1, col - 1)、(row + 1, col) 或者 (row + 1
//, col + 1) 。 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [[2,1,3],[6,5,4],[7,8,9]]
//输出：13
//解释：下面是两条和最小的下降路径，用加粗+斜体标注：
//[[2,1,3],      [[2,1,3],
// [6,5,4],       [6,5,4],
// [7,8,9]]       [7,8,9]]
// 
//
// 示例 2： 
//
// 
//输入：matrix = [[-19,57],[-40,-5]]
//输出：-59
//解释：下面是一条和最小的下降路径，用加粗+斜体标注：
//[[-19,57],
// [-40,-5]]
// 
//
// 示例 3： 
//
// 
//输入：matrix = [[-48]]
//输出：-48
// 
//
// 
//
// 提示： 
//
// 
// n == matrix.length 
// n == matrix[i].length 
// 1 <= n <= 100 
// -100 <= matrix[i][j] <= 100 
// 
// Related Topics 数组 动态规划 矩阵 
// 👍 121 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution931 {
    public int minFallingPathSum(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int dp[][] = new int[row][col];
        for(int i = 0; i < col; i++){
            dp[row-1][i] = matrix[row-1][i];
        }
        for(int i = row-2; i >= 0; i --){
            for(int j = 0; j < col; j++){
                int current = matrix[i][j];
                int nextValue;
                if(j-1 < 0 || j + 1 >= col){
                    if(j-1 < 0 && j + 1 >= col){
                        nextValue = matrix[i+1][j];
                    }else if(j-1 < 0){
                        nextValue = Math.min(matrix[i+1][j], matrix[i+1][j+1]);
                    }else{
                        nextValue = Math.min(matrix[i+1][j], matrix[i+1][j-1]);
                    }

                }else{
                    nextValue = Math.min(matrix[i+1][j], matrix[i+1][j+1]);
                    nextValue = Math.min(nextValue, matrix[i+1][j-1]);
                }
                dp[i][j] = current + nextValue;
            }
        }

        int res = dp[0][0];
        for(int i = 0; i < col; i++){
            if(dp[0][i] < res){
                res = dp[0][i];
            }
        }
        return res;

    }

    public static void main(String[] args) {
        Solution931 solution931 = new Solution931();
        int [][] matrix = new int[][]{{2,1,3},{6,5,4},{7,8,9}};
        int i = solution931.minFallingPathSum(matrix);
        System.out.println(i);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
