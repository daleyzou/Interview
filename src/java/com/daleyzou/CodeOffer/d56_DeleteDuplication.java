package com.daleyzou.CodeOffer;

import java.util.HashSet;
import java.util.Set;

/**
 * d56_DeleteDuplication
 * @description 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
 * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 * @author daleyzou
 * @date 2020年11月23日 23:47
 * @version 1.1.1
 */
public class d56_DeleteDuplication {
    public class ListNode {
        int val;

        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode deleteDuplication_1(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return pHead;
        }
        ListNode pFirst = pHead;
        Set<Integer> set = new HashSet<>();
        while (pFirst != null) {
            if (pFirst.next != null && pFirst.val == pFirst.next.val) {
                set.add(pFirst.val);
            }
            pFirst = pFirst.next;
        }
        pFirst = pHead.next;
        ListNode pSecond = pHead;
        while (pFirst != null) {
            if (set.contains(pFirst.val)) {
                pSecond.next = pFirst.next;
                pFirst = pSecond.next;
            } else {
                pFirst = pFirst.next;
                pSecond = pSecond.next;
            }
        }
        if (pHead != null && set.contains(pHead.val)) {
            pHead = pHead.next;
        }

        return pHead;
    }

    public ListNode deleteDuplication_2(ListNode pHead) {
        // 用两个指针来做
        if (pHead == null || pHead.next == null) {
            return pHead;
        }
        // 用三个指针来进行处理, 没写出来，失败

        return null;
    }

    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return pHead;
        }
        ListNode next = pHead.next;
        if (pHead.val == next.val) {
            while (next != null && pHead.val == next.val) {
                next = next.next;
            }
            return deleteDuplication(next);
        } else {
            pHead.next = deleteDuplication(next);
            return pHead;
        }
    }

    public ListNode deleteDuplication_3(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return pHead;
        }
        ListNode head = new ListNode(-1);
        ListNode trail = head;
        while (pHead != null){
            ListNode next = pHead.next;
            boolean isSwap  = false;
            while (next != null && pHead.val == next.val){
                next = next.next;
                isSwap = true;
            }
            if (!isSwap){
                trail.next = pHead;
                trail = trail.next;
            }
            pHead = next;
        }
        trail.next = null;
        return head.next;
    }

//    public ListNode deleteDuplication(ListNode pHead) {
//        if (pHead == null || pHead.next == null) {
//            return pHead;
//        }
//
//        ListNode head = new ListNode(-1); // 新建一个头结点，防止链表中头结点是重复节点被删除。
//        ListNode trail = head;
//
//        while (pHead != null) {
//            ListNode node = pHead.next;
//            boolean flag = false;
//            while (node != null && pHead.val == node.val) {
//                node = node.next;
//                flag = true;
//            }
//            if (!flag) {
//                trail.next = pHead;
//                trail = trail.next;
//            }
//            pHead = node;
//        }
//        trail.next = null; // 1->2->3->3->3
//        return head.next;
//    }

    public static void main(String[] args) {
        d56_DeleteDuplication object = new d56_DeleteDuplication();

    }
}
