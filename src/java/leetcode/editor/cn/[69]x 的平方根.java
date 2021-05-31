package leetcode.editor.cn;//实现 int sqrt(int x) 函数。
//
// 计算并返回 x 的平方根，其中 x 是非负整数。 
//
// 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。 
//
// 示例 1: 
//
// 输入: 4
//输出: 2
// 
//
// 示例 2: 
//
// 输入: 8
//输出: 2
//说明: 8 的平方根是 2.82842..., 
//     由于返回类型是整数，小数部分将被舍去。
// 
// Related Topics 数学 二分查找 
// 👍 685 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution69 {
    public int mySqrt(int x) {
        return sqrtData(1, x, x);
    }

    private int sqrtData(int begin, int end, int originData) {
        if (begin >= end){
            return end;
        }
        int tempLocation = begin + (end - begin) / 2;
        long tempSqrt = (long)tempLocation * tempLocation;
        if (tempSqrt > originData){
            return sqrtData(begin, tempLocation - 1, originData);
        }else if (tempSqrt < originData){
            long nextSqrt = (long)(tempLocation + 1) * (tempLocation + 1);
            if (nextSqrt > originData){
                return tempLocation;
            }
            return sqrtData(tempLocation + 1, end, originData);
        }else {
            return tempLocation;
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)
