/**
 * @projectName Interview
 * @package com.daleyzou.CodeOffer
 * @className com.daleyzou.CodeOffer.Merge_16
 * @copyright Copyright 2020 daleyzou, Inc. All rights reserved.
 */
package com.daleyzou.CodeOffer;

/**
 * Merge_16
 * @description TODO
 * @author daleyzou
 * @date 2020年01月02日 22:40
 * @version 1.0.0
 */
public class Merge_16 {

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode Merge(ListNode list1,ListNode list2) {
        if (list1 == null){
            return list2;
        }
        if (list2 == null){
            return list1;
        }
        ListNode head = new ListNode(0);
        ListNode temp = head;
        while (list1 != null && list2 != null){
            if (list1.val < list2.val){
                head.next = list1;
                list1 = list1.next;
            }else {
                head.next = list2;
                list2 = list2.next;
            }
            head = head.next;
        }
        if (list1 != null){
            head.next = list1;
        }
        if (list2 != null){
            head.next = list2;
        }
        return temp.next;
    }
}
