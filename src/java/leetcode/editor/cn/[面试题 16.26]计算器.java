package leetcode.editor.cn;//给定一个包含正整数、加(+)、减(-)、乘(*)、除(/)的算数表达式(括号除外)，计算其结果。
//
// 表达式仅包含非负整数，+， - ，*，/ 四种运算符和空格 。 整数除法仅保留整数部分。 
//
// 示例 1: 
//
// 输入: "3+2*2"
//输出: 7
// 
//
// 示例 2: 
//
// 输入: " 3/2 "
//输出: 1 
//
// 示例 3: 
//
// 输入: " 3+5 / 2 "
//输出: 5
// 
//
// 说明： 
//
// 
// 你可以假设所给定的表达式都是有效的。 
// 请不要使用内置的库函数 eval。 
// 
// Related Topics 栈 数学 字符串 
// 👍 57 👎 0


import java.util.Stack;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    Stack<Integer> stack = new Stack<>();
    public int calculate(String s) {
        char[] array = s.toCharArray();
        char sign = '+';
        int num = 0;
        for(int i = 0; i < array.length; i++){
            char c = array[i];
            if(Character.isDigit(c)){
                num = num * 10 + (c - '0');
            }
            if(!Character.isDigit(c) && c != ' ' || i == array.length -1){
                if('+' == sign){
                    stack.push(num);
                }else if('-' == sign){
                    stack.push(-num);
                }else if('*' == sign){
                    int top = stack.pop();
                    stack.push(top * num);
                }else if('/' == sign){
                    int top = stack.pop();
                    stack.push(top / num);
                }
                sign = c;
                num = 0;
            }
        }
        int result = 0;
        while(!stack.isEmpty()){
            result += stack.pop();
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
