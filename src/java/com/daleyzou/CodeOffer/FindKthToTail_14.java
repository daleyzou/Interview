/**
 * @projectName Interview
 * @package com.daleyzou.CodeOffer
 * @className com.daleyzou.CodeOffer.FindKthToTail_14
 * @copyright Copyright 2020 daleyzou, Inc. All rights reserved.
 */
package com.daleyzou.CodeOffer;

import java.util.HashMap;
import java.util.Map;

/**
 * FindKthToTail_14
 * @description TODO
 * @author daleyzou
 * @date 2020年01月02日 21:41
 * @version 1.0.0
 */
public class FindKthToTail_14 {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode FindKthToTail(ListNode head,int k) {
        Map<Integer, ListNode> map = new HashMap();
        Integer i = 1;
        while (head != null){
            map.put(i, head);
            head = head.next;
            i++;
        }
        Integer index = i - k;
        return map.get(index);

    }

    public ListNode FindKthToTail_2(ListNode head,int k) {
        // 两个指针，他们之间的间距为 k - 1
        if (k < 1 || head == null){
            return null;
        }
        ListNode step1 = head;
        ListNode step2 = head;

        while (k > 1){
            step1 = step1.next;
            if (step1 == null){
                return null;
            }
            k--;
        }
        while (step1.next != null){
            step1 = step1.next;
            step2 = step2.next;
        }
        return step2;
    }
}
