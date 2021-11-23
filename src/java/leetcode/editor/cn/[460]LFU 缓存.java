package leetcode.editor.cn;//请你为 最不经常使用（LFU）缓存算法设计并实现数据结构。
//
// 实现 LFUCache 类： 
//
// 
// LFUCache(int capacity) - 用数据结构的容量 capacity 初始化对象 
// int get(int key) - 如果键存在于缓存中，则获取键的值，否则返回 -1。 
// void put(int key, int value) - 如果键已存在，则变更其值；如果键不存在，请插入键值对。当缓存达到其容量时，则应该在插入新项之
//前，使最不经常使用的项无效。在此问题中，当存在平局（即两个或更多个键具有相同使用频率）时，应该去除 最近最久未使用 的键。 
// 
//
// 注意「项的使用次数」就是自插入该项以来对其调用 get 和 put 函数的次数之和。使用次数会在对应项被移除后置为 0 。 
//
// 为了确定最不常使用的键，可以为缓存中的每个键维护一个 使用计数器 。使用计数最小的键是最久未使用的键。 
//
// 当一个键首次插入到缓存中时，它的使用计数器被设置为 1 (由于 put 操作)。对缓存中的键执行 get 或 put 操作，使用计数器的值将会递增。 
//
// 
//
// 示例： 
//
// 
//输入：
//["LFUCache", "put", "put", "get", "put", "get", "get", "put", "get", "get", "g
//et"]
//[[2], [1, 1], [2, 2], [1], [3, 3], [2], [3], [4, 4], [1], [3], [4]]
//输出：
//[null, null, null, 1, null, -1, 3, null, -1, 3, 4]
//
//解释：
//// cnt(x) = 键 x 的使用计数
//// cache=[] 将显示最后一次使用的顺序（最左边的元素是最近的）
//LFUCache lFUCache = new LFUCache(2);
//lFUCache.put(1, 1);   // cache=[1,_], cnt(1)=1
//lFUCache.put(2, 2);   // cache=[2,1], cnt(2)=1, cnt(1)=1
//lFUCache.get(1);      // 返回 1
//                      // cache=[1,2], cnt(2)=1, cnt(1)=2
//lFUCache.put(3, 3);   // 去除键 2 ，因为 cnt(2)=1 ，使用计数最小
//                      // cache=[3,1], cnt(3)=1, cnt(1)=2
//lFUCache.get(2);      // 返回 -1（未找到）
//lFUCache.get(3);      // 返回 3
//                      // cache=[3,1], cnt(3)=2, cnt(1)=2
//lFUCache.put(4, 4);   // 去除键 1 ，1 和 3 的 cnt 相同，但 1 最久未使用
//                      // cache=[4,3], cnt(4)=1, cnt(3)=2
//lFUCache.get(1);      // 返回 -1（未找到）
//lFUCache.get(3);      // 返回 3
//                      // cache=[3,4], cnt(4)=1, cnt(3)=3
//lFUCache.get(4);      // 返回 4
//                      // cache=[3,4], cnt(4)=2, cnt(3)=3 
//
// 
//
// 提示： 
//
// 
// 0 <= capacity, key, value <= 104 
// 最多调用 105 次 get 和 put 方法 
// 
//
// 
//
// 进阶：你可以为这两种操作设计时间复杂度为 O(1) 的实现吗？ 
// Related Topics 设计 哈希表 链表 双向链表 
// 👍 458 👎 0


import jdk.internal.org.objectweb.asm.util.CheckAnnotationAdapter;

import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class LFUCache {
    static class Node{
        Node prev;
        Node next;
        int key;
        int value;
        int count;
        public Node(int key, int value, int count){
            this.key = key;
            this.value = value;
            this.count = count;
        }
    }

    static class DoubleList{
        Node head;
        Node tail;

        public DoubleList(){
            head = new Node(-1,-1,0);
            tail = new Node(999,999,0);
            head.next = tail;
            tail.prev = head;
        }

        public Node addNode(Node node){
            Node p = head.next;
            while(p.count <= node.count && p != tail){
                p = p.next;
            }
            node.next = p;
            node.prev = p.prev;
            p.prev.next = node;
            p.prev = node;
            return node;
        }
        public Node removeNode(Node node){
            if(node == null){
                return node;
            }
            if(head.next == tail){
                return node;
            }
            node.prev.next = node.next;
            node.next.prev = node.prev;
            return node;
        }
        public Node getFirst(){
            if(head.next == tail){
                return null;
            }
            return head.next;
        }
    }
    Map<Integer, Node> map;
    DoubleList doubleList;
    int capacity;
    public LFUCache(int capacity) {
        map = new HashMap<>();
        doubleList = new DoubleList();
        this.capacity = capacity;
    }

    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }
        Node node = map.get(key);
        doubleList.removeNode(node);
        Node newNode = new Node(node.key, node.value, node.count+1);
        doubleList.addNode(newNode);
        map.put(key, newNode);
        return newNode.value;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            doubleList.removeNode(node);
            Node newNode = new Node(node.key, value, node.count+1);
            doubleList.addNode(newNode);
            map.put(key, newNode);
        }else{

            if(map.size() > capacity -1){
                Node firstNode = doubleList.getFirst();
                doubleList.removeNode(firstNode);
                map.remove(firstNode.key);
            }

            Node newNode = new Node(key, value, 1);
            doubleList.addNode(newNode);
            map.put(key, newNode);
        }


    }
    public void sout(){
        Node p = doubleList.head.next;
        while(p != doubleList.tail){
            System.out.print("(" + p.key + "," + p.value + ","+   p.count + ")" + "  ");
            p = p.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // cnt(x) = 键 x 的使用计数
// cache=[] 将显示最后一次使用的顺序（最左边的元素是最近的）
        LFUCache lFUCache = new LFUCache(2);
        lFUCache.put(3, 1);   // cache=[1,_], cnt(1)=1
        lFUCache.sout();
        lFUCache.put(2, 1);   // cache=[2,1], cnt(2)=1, cnt(1)=1
        lFUCache.sout();

        // cache=[1,2], cnt(2)=1, cnt(1)=2
        lFUCache.put(2, 2);   // 去除键 2 ，因为 cnt(2)=1 ，使用计数最小
        lFUCache.sout();
        // cache=[3,1], cnt(3)=2, cnt(1)=2
        lFUCache.put(4, 4);   // 去除键 1 ，1 和 3 的 cnt 相同，但 1 最久未使用
        lFUCache.sout();
        // cache=[4,3], cnt(4)=1, cnt(3)=2
        lFUCache.get(2);      // 返回 -1（未找到）
        lFUCache.sout();
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)
