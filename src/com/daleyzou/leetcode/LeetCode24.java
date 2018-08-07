package com.daleyzou.leetcode;

/**
 * @Author: DaleyZou
 * @Description:
 * @Date: Created in 14:38 2018-8-7
 * @Modified By:
 */
public class LeetCode24 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null){
            return null;
        }
        ListNode listNode = head;
        while (listNode.next != null){
            listNode = swapTwoListNode(listNode, listNode.next);
            if (listNode.next != null && listNode.next.next != null){
                listNode = listNode.next;
            }else {
                break;
            }
        }
        return head;
    }
    public ListNode swapTwoListNode(ListNode listNode1, ListNode listNode2){
        int temp = 0;
        temp = listNode2.val;
        listNode2.val = listNode1.val;
        listNode1.val = temp;
        return listNode2;
    }
    public static void main(String[] args) {
        LeetCode24 leetCode24 = new LeetCode24();


    }
}
