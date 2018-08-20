package com.daleyzou.leetcode;

import java.util.Stack;

/**
 * @Author: DaleyZou
 * @Description:
 * @Date: Created in 7:43 2018/8/15
 * @Modified By:
 */
public class LeetCode32 {
    /**
     * @Description: 没有写出来
     *               参考链接：https://mp.weixin.qq.com/s/Kc9j5IH8HF0uGOULYmqYtw
     *               参考博客：https://www.cnblogs.com/zhangmingzhao/p/7630123.html
     * @auther: DaleyZou
     * @date: 19:30 2018-8-20
     * @param: s
     * @return: int
     */
    public int longestValidParentheses(String s) {
        int result = 0;  // 记录最大的匹配括号长度
        int lastPos = 0;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == '('){   // 如果是左括号，直接入栈
                stack.push(i);
            }else {
                if (stack.empty()){  // 是右括号，但是栈是空的
                    lastPos = i + 1;
                }else {
                    stack.pop();
                    if (stack.isEmpty()){
                        result = Math.max(result, i - lastPos + 1);
                    }else {
                        result = Math.max(result, i - stack.peek());
                    }
                }
            }
        }
        return result;
    }
}
