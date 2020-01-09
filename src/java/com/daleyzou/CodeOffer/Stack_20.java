package com.daleyzou.CodeOffer;

import java.util.Stack;

/**
 * Stack_20
 * @description 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））
 *
 * https://www.nowcoder.com/questionTerminal/4c776177d2c04c2494f2555c9fcc1e49?answerType=1&f=discussion
 *
 * https://blog.nowcoder.net/n/498fa52e417c426b8f1f267e43401c2e
 *
 * @author daleyzou
 * @date 2020年01月08日 22:02
 * @version 3.1.2
 */
public class Stack_20 {
    static Stack<Integer> stack = new Stack<>();

    int min;
    static int top;

    public void push(int node) {
        if (stack.isEmpty()){
            min = node;
        }
        stack.push(node - min);
        if (node < min){
            min = node;
        }
        top = node;
    }

    public void pop() {
        if (!stack.isEmpty()){
            if (this.top() < 0){
                min -= top;
            }
            stack.pop();
            if (!stack.isEmpty()){
                top = min + (this.top() > 0?top:0);
            }
        }
    }

    public int top() {
        return top;
    }

    public int min() {
        return min;
    }
}
