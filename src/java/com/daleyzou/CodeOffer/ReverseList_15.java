/**
 * @projectName Interview
 * @package com.daleyzou.CodeOffer
 * @className com.daleyzou.CodeOffer.ReverseList_15
 * @copyright Copyright 2020 daleyzou, Inc. All rights reserved.
 */
package com.daleyzou.CodeOffer;

/**
 * ReverseList_15
 * @description TODO
 * @author daleyzou
 * @date 2020年01月02日 22:20
 * @version 1.0.0
 */
public class ReverseList_15 {
    public class ListNode {
        int val;

        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode ReverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode step1 = head;
        ListNode step2 = step1.next;
        ListNode step3 = step2.next;
        step1.next = null;
        step2.next = step1;
        while (step3 != null){
            ListNode temp = step3.next;
            step3.next = step2;
            step2.next = step1;
            step1 = step2;
            step2 = step3;
            step3 = temp;
        }

        return step2;
    }
}
