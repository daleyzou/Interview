package leetcode.editor.cn;//以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返
//回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。 
//
// 
//
// 示例 1： 
//
// 
//输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
//输出：[[1,6],[8,10],[15,18]]
//解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
// 
//
// 示例 2： 
//
// 
//输入：intervals = [[1,4],[4,5]]
//输出：[[1,5]]
//解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。 
//
// 
//
// 提示： 
//
// 
// 1 <= intervals.length <= 104 
// intervals[i].length == 2 
// 0 <= starti <= endi <= 104 
// 
// Related Topics 数组 排序 
// 👍 1302 👎 0


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length <= 1){
            return intervals;
        }
        // 1、 排序  2、 逐个合并
        for(int i = 0; i < intervals.length; i++){
            for(int j = 0; j < intervals.length; j++){
                if(intervals[i][0] > intervals[j][0]){
                    int[] temp = intervals[i];
                    intervals[i] = intervals[j];
                    intervals[j] = temp;
                }
            }
        }
        Stack<int[]> stack = new Stack<>();
        for(int i = 0; i < intervals.length; i++){
            stack.push(intervals[i]);
        }

        List<int[]> list = new ArrayList<>();

        Stack<int[]> resultStack = new Stack<>();

        int[] temp = stack.pop();
        resultStack.push(temp);
        while(!stack.isEmpty()){
            int[] ite =  stack.pop();
            temp = resultStack.pop();
            int a1 = temp[0], a2 = temp[1];
            int b1 = ite[0], b2 = ite[1];
            if(a1<= b2 && b1<=a2){
                resultStack.push(new int[]{Math.min(a1, b1), Math.max(a2,b2)});
            }else {
                resultStack.push(temp);
                resultStack.push(ite);
            }
        }

        int[][] result = new int[resultStack.size()][2];
        int i = 0;
        while(!resultStack.isEmpty()){
            result[i] = resultStack.pop();
            i++;
        }
        return result;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] intervals = new int[][]{{2,3},{4,5},{6,7},{8,9},{1,10}};
        int[][] merge = solution.merge(intervals);
        System.out.println(merge);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
