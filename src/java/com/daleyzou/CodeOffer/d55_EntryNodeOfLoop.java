package com.daleyzou.CodeOffer;

import java.util.HashSet;
import java.util.Set;

/**
 * d55_EntryNodeOfLoop
 * @description 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 * @author daleyzou
 * @date 2020年11月20日 13:38
 * @version 1.1.1
 */
public class d55_EntryNodeOfLoop {
    public class ListNode {
        int val;

        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    /**
     *  使用一个 set 来做去重判断
     *
     * @param pHead
     * @return
     * @author daleyzou
     */
    public ListNode EntryNodeOfLoop_1(ListNode pHead) {
        if (pHead == null || pHead.next == null){
            return null;
        }
        Set<ListNode> sets = new HashSet<>();
        sets.add(pHead);
        ListNode tempNode;
        while ((pHead = pHead.next) != null){
            if (sets.contains(pHead)){
                return pHead;
            }
            sets.add(pHead);
        }
        return null;
    }

    public ListNode EntryNodeOfLoop(ListNode pHead)
    {
        if (pHead == null || pHead.next == null){
            return null;
        }
        ListNode pFirst = pHead;
        ListNode pEnd = pHead;
        pFirst = pFirst.next;
        pEnd = pEnd.next.next;
        while (pFirst != pEnd){
            pFirst = pFirst.next;
            pEnd = pEnd.next.next;
            if (pFirst == null ||pEnd == null){
                return null;
            }
        }
        pFirst = pHead;
        while (true){
            if (pFirst == pEnd){
                return pFirst;
            }
            pFirst = pFirst.next;
            pEnd = pEnd.next;
        }
    }
}
