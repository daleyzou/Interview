package com.daleyzou.leetcode;

public class LeetCode2 {
    public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode listNode1 = new ListNode(0);
        ListNode listNode_ = new ListNode(2);
        listNode_ = listNode1;
        while (l1 != null && l2 != null) {
            ListNode temp = new ListNode(l1.val + l2.val);
            listNode1.next = temp;

            listNode1 = listNode1.next;
            l1 = l1.next;
            l2 = l2.next;
        }
//        if (l1.next == null && l2.next == null){
//            l1.val += l2.val;
//            listNode1.next = l1;
//        }
        while (l1 != null){
            listNode1.next = l1;
            l1 = l1.next;
            listNode1 = listNode1.next;

        }
        while (l2 != null){
            listNode1.next = l2;
            l2 = l2.next;
            listNode1 = listNode1.next;

        }
        if (listNode_.next != null) {
            listNode_ = listNode_.next;
        }
        listNode1 = listNode_;
        while (listNode1.next != null){
            if (listNode1.val >= 10){
                listNode1.next.val += 1;
                listNode1.val -= 10;
            }
            listNode1 = listNode1.next;
        }
        if (listNode1.val >= 10){
            listNode1.next = new ListNode(1);
            listNode1.val -= 10;
        }
        return listNode_;
    }

    public static void main(String[] args){
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode listNode = addTwoNumbers(l1, l2);



        System.out.println("结束");
        System.out.println(listNode);
    }
}
