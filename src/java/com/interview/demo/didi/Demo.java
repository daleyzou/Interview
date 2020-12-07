package com.interview.demo.didi;

import java.util.*;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Demo
 * @description didi一面笔试题
 * @author daleyzou
 * @date 2020年12月05日 17:18
 * @version 1.1.1
 */
public class Demo {
    class Node{
        Character ch;
        Node next;
        boolean isInstall;

        public Node(Character ch) {
            this.ch = ch;
            this.isInstall = false;
        }
    }

    public void test(LinkedHashMap<Character, Node> map){

    }

    public static void main(String[] args){
        LinkedHashMap<Character, Node> map = new LinkedHashMap<>();
//        Stack<Character> stack1 = new Stack<>();
//        Stack<Character> stack2 = new Stack<>();
        Map<Character, List<String>> map1 = new HashMap<>(1);
        /**
         *
         * H F D E C B A
         * Install C
         * Install A
         **
          * A->B
         * B->C
         * B->D
         * C->E
         * D->F
         * D->H
         * H->F
         *
         *
         *   A->B->C->E
         *   B->D->F
         *   D->H
         *   H->F
          */
//        stack1.push('H');
//        stack1.push('F');
//        stack1.push('D');
//        stack1.push('E');
//        stack1.push('C');
//        stack1.push('B');
//        stack1.push('A');


    }
}
