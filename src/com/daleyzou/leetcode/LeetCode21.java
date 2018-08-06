package com.daleyzou.leetcode;

/**
 * @Author: DaleyZou
 * @Description:
 * @Date: Created in 23:26 2018/8/6
 * @Modified By:
 */
public class LeetCode21 {
    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode result = new ListNode(0);
        ListNode head = result;
        while (l1 != null && l2 != null){
            if (l1.val < l2.val){
                result.next = l1;
                l1 = l1.next;
                result = result.next;
            }else {
                result.next = l2;
                l2 = l2.next;
                result = result.next;
            }
        }
        while (l1 != null){
            result.next = l1;
            l1 = l1.next;
            result = result.next;
        }
        while (l2 != null){
            result.next = l2;
            l2 = l2.next;
            result = result.next;
        }

        return head.next;
    }
}
