package com.daleyzou.leetcode;

import java.util.List;

/**
 * @Author: DaleyZou
 * @Description:
 * @Date: Created in 14:14 2018-8-7
 * @Modified By:
 */
public class LeetCode23 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode mergeKLists(ListNode[] lists) {

        ListNode result = null;
        ListNode head = result;

        if (lists.length == 1){
            return lists[0];
        }
        if (lists.length >= 2) {
            result = mergeTwoListNode(lists[0], lists[1]);
            for (int i = 2; i < lists.length; i++) {
                result = mergeTwoListNode(result, lists[i]);
            }
        }
        return result;
    }
    public ListNode mergeTwoListNode(ListNode listNode1, ListNode listNode2){
        if (listNode1 == null) return listNode2;
        if (listNode2 == null) return listNode1;
        ListNode result = new ListNode(0);
        ListNode head = result;
        while (listNode1 != null && listNode2 != null){
            if (listNode1.val < listNode2.val){
                result.next = listNode1;
                listNode1 = listNode1.next;
                result = result.next;
            }else {
                result.next = listNode2;
                listNode2 = listNode2.next;
                result = result.next;
            }
        }
        while (listNode1 != null){
            result.next = listNode1;
            listNode1 = listNode1.next;
            result = result.next;
        }
        while (listNode2 != null){
            result.next = listNode2;
            listNode2 = listNode2.next;
            result = result.next;
        }
        return head.next;
    }
    public static void main(String[] args) {
        LeetCode23 leetCode23 = new LeetCode23();


    }
}
