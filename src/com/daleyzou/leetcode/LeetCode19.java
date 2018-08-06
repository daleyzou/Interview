package com.daleyzou.leetcode;

/**
 * @Author: DaleyZou
 * @Description:
 * @Date: Created in 22:06 2018/8/6
 * @Modified By:
 */
public class LeetCode19 {

    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int i = 1;
        ListNode temp = head;
        while (temp.next != null){
            i++;
            temp = temp.next;
        }
        if (i == n){
            return head.next;
        }
        int j = i - n;
        temp = head;
        for (int k = 1; k < j; k++){
            temp = temp.next;
        }
        temp.next = temp.next.next;
        return head;
    }

    public static void main(String[] args){
        LeetCode19 leetCode19 = new LeetCode19();


        System.out.println();
    }
}
