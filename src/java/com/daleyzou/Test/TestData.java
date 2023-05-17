package com.daleyzou.Test;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Stack;

/**
 * TestData
 * @description TODO
 * @author daleyzou
 * @date 2022年04月18日 15:40
 * @version 1.1.1
 */
public class TestData {

    public class ListNode{
        int val;
        ListNode next;
        public ListNode(){}


    }

    public static void main(String[] args) {
        System.out.println(Math.pow(2,0));
        Stack<Character> stack = new Stack<>();
        stack.peek();
        Character aa = 'a';

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.deleteCharAt(0);

        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<ListNode>((node1,node2)->{return node1.val-node2.val;});
        //priorityQueue

        StringBuilder stringBuilder1 = new StringBuilder();
       stringBuilder1.append("(");
       stringBuilder1.deleteCharAt(stringBuilder.length()-1);

       int[] nums = new int[]{1,4,5};
        Arrays.sort(nums, 0, nums.length-1);
    }


     public static class LisNode {
       public LisNode(){

        }
    }
}
