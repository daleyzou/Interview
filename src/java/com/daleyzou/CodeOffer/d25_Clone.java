package com.daleyzou.CodeOffer;

import java.util.HashMap;
import java.util.Map;

/**
 * d25_Clone
 * @description 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
 * 返回结果为复制后复杂链表的head。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 * @author daleyzou
 * @date 2020年01月21日 17:52
 * @version 3.1.2
 */
public class d25_Clone {
    public class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }

    public RandomListNode Clone(RandomListNode pHead)
    {
        if (pHead == null){
            return pHead;
        }
        RandomListNode head = new RandomListNode(pHead.label);
        RandomListNode point = head;

        RandomListNode source = pHead;

        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        while (source != null){
            // source 跑得比 head 快一个
            RandomListNode target = new RandomListNode(source.label);
            head.next = target;
            head = head.next;
            map.put(source, head);
            source = source.next;
//            target.random = source.random;
        }
        head.next = null;

        head = point.next;
        source = pHead;
        while (source != null){
            head.random = map.get(source.random);
            head = head.next;
            source = source.next;
        }
        return point.next;
    }
}
