package com.daleyzou.interview;

/**
 * MainTest
 *
 * @author zoudaifa
 * @description test ok二面， 链表反转
 * @date 2022年03月16日 5:56 下午
 */
public class LinkReverse {

    static class Node{
        Node next;
        int val;
        public Node(int val){
            this.val = val;
        }
    }

    public Node reverse(Node head){
        if(head == null || head.next == null){
            return head;
        }
        Node temp = head;
        Node first, second, three;
        first = head;
        second = first.next;
        three = second.next;

        while (second != null){
            second.next = first;
            first = second;
            second = three;
            if(three != null){
                three = three.next;
            }
        }
        temp.next = null;
        return first;
    }

    public static void main(String[] args) {
        LinkReverse test = new LinkReverse();
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        node1.next = node2;
        node2.next = node3;
        Node reverse = test.reverse(node1);


        while (reverse != null){
            System.out.println(reverse.val);
            reverse = reverse.next;
        }
    }
}
