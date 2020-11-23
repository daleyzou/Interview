package com.daleyzou.CodeOffer;

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
    public ListNode deleteDuplication(ListNode pHead)
    {
        // 用两个指针来做
        if (pHead == null ||pHead.next == null){
            return pHead;
        }
        ListNode pFirst = pHead;
        ListNode pSecond = pHead;
        while (pSecond != null){
            if (pFirst.next != null && pFirst.next.val == pSecond.val){
                pFirst = pFirst.next;
                continue;
            }

            pFirst = pFirst.next;
            pSecond = pSecond.next;
        }
    }
}
