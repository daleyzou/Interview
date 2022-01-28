package com.daleyzou.Test;


import java.util.LinkedList;
import java.util.Stack;

/**
 * TestEverything
 *
 * @author zoudaifa
 * @description test
 * @date 2022年01月28日 12:04 下午
 */
public class TestEverything {

    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<>();

        Stack<String> stack = new Stack<>();
        java.lang.String str = "123";
        for(int i = 0; i< 3; i++){
            stack.push(str.charAt(i)+"");
        }
        StringBuilder sb = new StringBuilder();

        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        System.out.println(sb.toString());
    }
}
