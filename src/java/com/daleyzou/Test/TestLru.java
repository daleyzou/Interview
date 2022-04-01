package com.daleyzou.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * TestLru
 *
 * @author zoudaifa
 * @description TODO
 * @date 2022年03月30日 6:57 下午
 */
public class TestLru {

    static class Node {
        Node pre;
        Node next;
        int val;
        public Node(){

        }
        public Node(int val) {
            this.val = val;
        }
    }

    static class DoubleLinked {
        Node head;
        Node tail;
        int size;
        public DoubleLinked(){
            head = new Node();
            tail = new Node;
            head.next = tail;
            tail.pre = head;
        }

        public void remove(Node node) {
            Node pre = node.pre;
            pre.next = node.next;
            node.next.pre = pre;
            node = null;
            size--;
        }

        public Node addLast(Node node) {
            node.next = tail;
            tail.pre.next = node;
            node.pre = tail.pre;
            tail.pre = node;
            size++;
            return node;
        }

    }

    Map<Integer, Node> keyToNode;
    DoubleLinked doubleLinked;
    int maxSize;

    public TestLru(int maxSize) {
        keyToNode = new HashMap<>();
        doubleLinked = new DoubleLinked();

    }

    public Integer get(int key){
        // 元素存在， 访问后移动到链表末尾
        if(keyToNode.containsKey(key)){
            Node oldNode = keyToNode.get(key);
            doubleLinked.remove(oldNode);
            Node newNode = new Node(oldNode.val);
            newNode = doubleLinked.addLast(newNode);
            keyToNode.remove(key);
            keyToNode.put(key, newNode);
            return newNode.val;
        }else {
            return null;
        }
    }

    public int put(int key, int value){
        // 元素存在， 修改后，移动到链表末尾

        // 元素不存在， 判断是否需要移除链表头的元素， 然后将写入的节点加到链表末尾

    }

    public void removeNode(){

    }
    public Node addNode(){

    }
}
