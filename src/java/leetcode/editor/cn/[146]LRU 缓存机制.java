package leetcode.editor.cn;//运用你所掌握的数据结构，设计和实现一个 LRU (最近最少使用) 缓存机制 。
//
// 
// 
// 实现 LRUCache 类： 
//
// 
// LRUCache(int capacity) 以正整数作为容量 capacity 初始化 LRU 缓存 
// int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。 
// void put(int key, int value) 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字-值」。当缓存容量达到上
//限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。 
// 
//
// 
// 
// 
//
// 进阶：你是否可以在 O(1) 时间复杂度内完成这两种操作？ 
//
// 
//
// 示例： 
//
// 
//输入
//["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
//[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
//输出
//[null, null, null, 1, null, -1, null, -1, 3, 4]
//
//解释
//LRUCache lRUCache = new LRUCache(2);
//lRUCache.put(1, 1); // 缓存是 {1=1}
//lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
//lRUCache.get(1);    // 返回 1
//lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
//lRUCache.get(2);    // 返回 -1 (未找到)
//lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
//lRUCache.get(1);    // 返回 -1 (未找到)
//lRUCache.get(3);    // 返回 3
//lRUCache.get(4);    // 返回 4
// 
//
// 
//
// 提示： 
//
// 
// 1 <= capacity <= 3000 
// 0 <= key <= 10000 
// 0 <= value <= 105 
// 最多调用 2 * 105 次 get 和 put 
// 
// Related Topics 设计 哈希表 链表 双向链表 
// 👍 1729 👎 0


import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class LRUCache {
    static class Node{
        int key;
        int value;
        Node next;
        Node prev;
        public Node(){
        }
        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    static class DoubleList{
        Node head;
        Node tail;
        int size;
        public DoubleList(){
            head = new Node();
            tail = new Node();
            head.next = tail;
            tail.prev = head;
            size = 0;
        }

        public void remove(Node node){
            if(node == null){
                return;
            }
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        public Node removeFirst(){
            if(head.next == tail){
                return null;
            }
            Node first = head.next;
            remove(first);
            return first;
        }
        public Node addLast(Node node){
            tail.prev.next = node;
            node.prev = tail.prev;
            tail.prev = node;
            node.next = tail;
            return node;
        }


    }
    DoubleList doubleList;
    Map<Integer, Node> map;
    int capacity;
    public LRUCache(int capacity) {
        doubleList = new DoubleList();
        map = new HashMap<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }
        Node node = map.get(key);
        makeRecently(node);
        return node.value;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            remove(map.get((key)));
            Node node = new Node(key, value);
            addNode(node);
            makeRecently(node);
        }else{
            Node node = new Node(key, value);
            addNode(node);
            if(map.size() > capacity){
                removeFirst();
            }
        }
    }

    public void makeRecently(Node node){
        doubleList.remove(node);
        doubleList.addLast(node);
        map.put(node.value, node);
    }

    public Node addNode(Node node){
        doubleList.addLast(node);
        map.put(node.key, node);
        return node;
    }

    public Node removeFirst(){
        Node first = doubleList.removeFirst();
        map.remove(first.key);
        return first;
    }

    public void remove(Node node){
        doubleList.remove(node);
        map.remove(node.key);
        return ;
    }

    public static void main(String[] args) {
        LRUCache obj = new LRUCache(2);
        int param_1 = obj.get(1);
        System.out.println(param_1);
        obj.put(1,2);
        obj.put(1,1);
        System.out.println(obj.get(1));
        obj.put(2,2);
        System.out.println(obj.get(2));
        obj.put(3,3);
        System.out.println(obj.get(3));
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)
