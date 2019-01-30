package com.daleyzou.CodeOffer;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @Author: DaleyZou
 * @Description: 从尾到头打印链表
 * 输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
 * @Date: Created in 23:38 2019/1/28
 * @Modified By:
 */

public class PrintListFromTailToHead_3 {
    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

        public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> resultList = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        while (listNode != null){
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        while (!stack.isEmpty()){
            Integer pop = stack.pop();
            resultList.add(pop);
        }

        return resultList;
    }

    public static void main(String[] args){
        PrintListFromTailToHead_3 printListFromTailToHead = new PrintListFromTailToHead_3();

        ListNode listNode = new ListNode(1);
        ListNode listNode1 = new ListNode(2);
        listNode.next = listNode1;

        ArrayList<Integer> integers = printListFromTailToHead.printListFromTailToHead(listNode);

    }
}
