package com.daleyzou.CodeOffer;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.Queue;
import java.util.Stack;

/**
 * @Author: DaleyZou
 * @Description: 用两个栈实现队列
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 * @Date: Created in 18:58 2019/2/28
 * @Modified By:
 */
public class QueueInTwoStack_5 {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        while (!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
        stack1.push(node);
    }

    public int pop() {
        while (!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        return stack2.pop();
    }

    /**
     * @Description:
     * 栈 先进后出、
     * 队列 先进先出
     *  push 压一个数
     *  pop 出一个数
     * @param: null
     * @return:
     */

    public static void main(String[] args){
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        int n = stack.pop();
        n = stack.pop();
        System.out.println(n);
    }
}
