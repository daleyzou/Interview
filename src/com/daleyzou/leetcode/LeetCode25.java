package com.daleyzou.leetcode;

import java.util.List;

/**
 * @Author: DaleyZou
 * @Description:
 * @Date: Created in 15:32 2018-8-7
 * @Modified By:
 */
public class LeetCode25 {
    // 参考博客：https://leetcode.com/problems/reverse-nodes-in-k-group/discuss/11423/Short-but-recursive-Java-code-with-comments
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode curr = head;
        int count = 0;
        while (curr != null && count != k) { // find the k+1 node
            curr = curr.next;
            count++;
        }
        if (count == k) { // if k+1 node is found
            curr = reverseKGroup(curr, k); // reverse list with k+1 node as head
            // head - head-pointer to direct part,
            // curr - head-pointer to reversed part;
            while (count-- > 0) { // reverse current k-group:
                ListNode tmp = head.next; // tmp - next head in direct part
                head.next = curr; // preappending "direct" head to the reversed list
                curr = head; // move head of reversed part to a new node
                head = tmp; // move "direct" head to the next node in direct part
            }
            head = curr;
        }
        return head;
    }

    public ListNode reverse(ListNode head, ListNode tail){
        ListNode curr = tail;
        while (head != tail) { // reverse current k-group:
            ListNode tmp = head.next; // tmp - next head in direct part
            head.next = curr; // preappending "direct" head to the reversed list
            curr = head; // move head of reversed part to a new node
            head = tmp; // move "direct" head to the next node in direct part
            ListNode out = curr;
            while (out != null){
                System.out.print(out.val + " ");
                out = out.next;
            }
            System.out.println();
        }
        return curr;
    }
    public static void main(String[] args){
        LeetCode25 leetcode25 = new LeetCode25();
        ListNode head = new ListNode(1);
        ListNode head1 = new ListNode(2);
        ListNode head2 = new ListNode(3);
        ListNode head3 = new ListNode(4);

        head.next = head1;
        head1.next = head2;
        head2.next = head3;

        ListNode reverse = leetcode25.reverse(head, head3);
        System.out.println("一下结果；————————————————————————————————————");
        while (reverse != null){
            System.out.println(reverse.val);
            reverse = reverse.next;
        }
    }
}
