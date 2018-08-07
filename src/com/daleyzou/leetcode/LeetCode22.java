package com.daleyzou.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: DaleyZou
 * @Description:
 * @Date: Created in 7:15 2018/8/7
 * @Modified By:
 */
public class LeetCode22 {

    // 参考博客：https://www.cnblogs.com/tadage/p/7313903.html
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
        char[] buffer = new char[n * 2];   // 存储中间结果
        make(result, buffer, n, n, 0);

        return result;
    }

    private void make(List<String> result, char[] buffer, int leftRemainder, int rightRemainder, int count) {
        if (leftRemainder < 0 || rightRemainder < 0 || rightRemainder < leftRemainder){  // 左括号和右括号的剩余数量最小就是0
            // 右括号的剩余数量不可以小于左括号
            return;
        }
        if (leftRemainder == 0 && rightRemainder == 0){  // 没有括号了
            String str = String.copyValueOf(buffer);
            result.add(str);
        }else {
            if (leftRemainder > 0){
                buffer[count]  = '(';
                make(result, buffer, leftRemainder - 1, rightRemainder, count + 1);
            }
            if (rightRemainder > leftRemainder){  // 剩余的右括号数量比左括号数量多，就可以加入右括号
                buffer[count]  = ')';
                make(result, buffer, leftRemainder, rightRemainder - 1, count + 1);
            }
        }
    }

    public static void main(String[] args) {
        LeetCode22 leetCode22 = new LeetCode22();

        List<String> list = leetCode22.generateParenthesis(3);  // 生成3对括号的所有组合
        for(String str : list) {
            System.out.println(str);
        }
    }

}
