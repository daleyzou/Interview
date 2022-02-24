package leetcode.editor.cn;//给你一个大小为 m x n 的矩阵 mat ，请以对角线遍历的顺序，用一个数组返回这个矩阵中的所有元素。
//
// 
//
// 示例 1： 
//
// 
//输入：mat = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[1,2,4,7,5,3,6,8,9]
// 
//
// 示例 2： 
//
// 
//输入：mat = [[1,2],[3,4]]
//输出：[1,2,3,4]
// 
//
// 
//
// 提示： 
//
// 
// m == mat.length 
// n == mat[i].length 
// 1 <= m, n <= 104 
// 1 <= m * n <= 104 
// -105 <= mat[i][j] <= 105 
// 
// Related Topics 数组 矩阵 模拟 
// 👍 271 👎 0


import java.util.Arrays;
import java.util.PriorityQueue;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b)->{
            if(a[0] + a[1] == b[0]+b[1]){
                return a[1] - b[1];
            }else {
                return a[0] + a[1] -(b[0]+b[1]);
            }
        });
        int m = mat.length;
        int n = mat[0].length;
        for(int i = 0; i < m; i++){
            for(int j = 0; j< n; j++){
                queue.add(new int[]{i, j});
            }
        }

        int[] result = new int[m*n];
        int i = 0;
        while(!queue.isEmpty()){
            int[] data = queue.poll();
            result[i] = mat[data[0]][data[1]];
            i++;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] mat = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        int[] diagonalOrder = solution.findDiagonalOrder(mat);
        System.out.println(Arrays.toString(diagonalOrder));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
