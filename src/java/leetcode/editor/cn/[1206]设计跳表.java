package leetcode.editor.cn;//不使用任何库函数，设计一个跳表。
//
// 跳表是在 O(log(n)) 时间内完成增加、删除、搜索操作的数据结构。跳表相比于树堆与红黑树，其功能与性能相当，并且跳表的代码长度相较下更短，其设计思想
//与链表相似。 
//
// 例如，一个跳表包含 [30, 40, 50, 60, 70, 90]，然后增加 80、45 到跳表中，以下图的方式操作： 
//
// 
//Artyom Kalinin [CC BY-SA 3.0], via Wikimedia Commons 
//
// 跳表中有很多层，每一层是一个短的链表。在第一层的作用下，增加、删除和搜索操作的时间复杂度不超过 O(n)。跳表的每一个操作的平均时间复杂度是 O(log(
//n))，空间复杂度是 O(n)。 
//
// 在本题中，你的设计应该要包含这些函数： 
//
// 
// bool search(int target) : 返回target是否存在于跳表中。 
// void add(int num): 插入一个元素到跳表。 
// bool erase(int num): 在跳表中删除一个值，如果 num 不存在，直接返回false. 如果存在多个 num ，删除其中任意一个即可。 
//
// 
//
// 了解更多 : https://en.wikipedia.org/wiki/Skip_list 
//
// 注意，跳表中可能存在多个相同的值，你的代码需要处理这种情况。 
//
// 样例: 
//
// Skiplist skiplist = new Skiplist();
//
//skiplist.add(1);
//skiplist.add(2);
//skiplist.add(3);
//skiplist.search(0);   // 返回 false
//skiplist.add(4);
//skiplist.search(1);   // 返回 true
//skiplist.erase(0);    // 返回 false，0 不在跳表中
//skiplist.erase(1);    // 返回 true
//skiplist.search(1);   // 返回 false，1 已被擦除
// 
//
// 约束条件: 
//
// 
// 0 <= num, target <= 20000 
// 最多调用 50000 次 search, add, 以及 erase操作。 
// 
// Related Topics 设计 链表 
// 👍 91 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Skiplist {
    /**
     * 最大层数
     */
    private static int DEFAULT_MAX_LEVEL = 32;
    /**
     * 随机层数概率，也就是随机出的层数，在 第1层以上(不包括第一层)的概率，层数不超过maxLevel，层数的起始号为1
     */
    private static double DEFAULT_P_FACTOR = 0.25;

    Node head = new Node(null,DEFAULT_MAX_LEVEL); //头节点

    int currentLevel = 1; //表示当前nodes的实际层数，它从1开始


    public Skiplist() {
    }

    public boolean search(int target) {
        Node searchNode = head;
        for (int i = currentLevel-1; i >=0; i--) {
            searchNode = findClosest(searchNode, i, target);
            if (searchNode.next[i]!=null && searchNode.next[i].value == target){
                return true;
            }
        }
        return false;
    }

    /**
     *
     * @param num
     */
    public void add(int num) {
        int level = randomLevel();
        Node updateNode = head;
        Node newNode = new Node(num,level);
        // 计算出当前num 索引的实际层数，从该层开始添加索引
        for (int i = currentLevel-1; i>=0; i--) {
            //找到本层最近离num最近的list
            updateNode = findClosest(updateNode,i,num);
            if (i<level){
                if (updateNode.next[i]==null){
                    updateNode.next[i] = newNode;
                }else{
                    Node temp = updateNode.next[i];
                    updateNode.next[i] = newNode;
                    newNode.next[i] = temp;
                }
            }
        }
        if (level > currentLevel){ //如果随机出来的层数比当前的层数还大，那么超过currentLevel的head 直接指向newNode
            for (int i = currentLevel; i < level; i++) {
                head.next[i] = newNode;
            }
            currentLevel = level;
        }

    }

    public boolean erase(int num) {
        boolean flag = false;
        Node searchNode = head;
        for (int i = currentLevel-1; i >=0; i--) {
            searchNode = findClosest(searchNode, i, num);
            if (searchNode.next[i]!=null && searchNode.next[i].value == num){
                //找到该层中该节点
                searchNode.next[i] = searchNode.next[i].next[i];
                flag = true;
                continue;
            }
        }
        return flag;
    }

    /**
     * 找到level层 value 大于node 的节点
     * @param node
     * @param levelIndex
     * @param value
     * @return
     */
    private Node findClosest(Node node,int levelIndex,int value){
        while ((node.next[levelIndex])!=null && value >node.next[levelIndex].value){
            node = node.next[levelIndex];
        }
        return node;
    }


    /**
     * 随机一个层数
     */
    private static int randomLevel(){
        int level = 1;
        while (Math.random()<DEFAULT_P_FACTOR && level<DEFAULT_MAX_LEVEL){
            level ++ ;
        }
        return level;
    }


    class Node{
        Integer value;
        Node[] next;

        public Node(Integer value,int size) {
            this.value = value;
            this.next = new Node[size];
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }
    }

}

/**
 * Your Skiplist object will be instantiated and called as such:
 * Skiplist obj = new Skiplist();
 * boolean param_1 = obj.search(target);
 * obj.add(num);
 * boolean param_3 = obj.erase(num);
 */
//leetcode submit region end(Prohibit modification and deletion)
