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
    /**
     * @Description:
     * @auther: DaleyZou
     * @date: 13:46 2018-8-8
     * @param: head 链表的头结点
     * @param: k k 个节点一组进行翻转
     * @return: ListNode
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode currentNode = head;
        if (currentNode == null || k < 0){
            return head;
        }
        int count = 0;
        while (currentNode != null && count < k){ // find the k+1 node
            currentNode = currentNode.next;
            count++;
        }
        if (count == k){ // if k+1 node is found
            currentNode = reverseKGroup(currentNode, k); // reverse list with k+1 node as head
            while (count-- > 0){ // reverse current k-group:
                ListNode temp = head.next;
                head.next = currentNode;
                currentNode = head;
                head = temp;
            }
            head = currentNode;
        }
        return head;
    }

    /**
     * @Description:
     * @auther: DaleyZou
     * @date: 11:28 2018-8-8 
     * @param: head
     * @param: k
     * @return: com.daleyzou.leetcode.LeetCode25.ListNode
     */
    public ListNode reverse(ListNode head, int k){
        int count = 0;
        ListNode currentNode = head;
        while (currentNode != null && count < k){
            currentNode = currentNode.next;
            count++;
        }
        while (count-- > 0) {
            ListNode tmp = head.next;
            head.next = currentNode;
            currentNode = head;
            head = tmp;
            ListNode out = currentNode;
            while (out != null){
                System.out.print(out.val + " ");
                out = out.next;
            }
            System.out.println();
        }
        return currentNode;
    }
    public static void main(String[] args){
        LeetCode25 leetcode25 = new LeetCode25();

        // 初始化5个链表节点
        ListNode head = new ListNode(1);
        ListNode head1 = new ListNode(2);
        ListNode head2 = new ListNode(3);
        ListNode head3 = new ListNode(4);
        ListNode head4 = new ListNode(5);

        // 添加节点间的关联关系
        head.next = head1;
        head1.next = head2;
        head2.next = head3;
        head3.next = head4;

        // 对前四个节点进行翻转
        ListNode reverse = leetcode25.reverse(head, 4);
    }
}
