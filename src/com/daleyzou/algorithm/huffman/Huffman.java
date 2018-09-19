package com.daleyzou.algorithm.huffman;

/**
 * @Author: DaleyZou
 * @Description: Huffman树  参考博客：https://www.cnblogs.com/skywang12345/p/3706833.html
 * @Date: Created in 13:55 2018-9-17
 * @Modified By:
 */
public class Huffman {
    private HuffmanNode mRoot;  // 根节点

    /**
     * @Description: 创建Huffman树
     * @date: 13:57 2018-9-17
     * @param: a 权值数组
     * @return:
     */
    public Huffman(int a[]) {
        HuffmanNode parent = null;
        MinHeap heap;
        // 建立数组a对应的最小堆
        heap = new MinHeap(a);

        for (int i = 0; i < a.length - 1; i++){
            HuffmanNode left = heap.dumpFromMinimum(); // 最小节点是左孩子
            HuffmanNode right = heap.dumpFromMinimum(); // 其次才是右孩子
            // 新建parent节点，左右孩子分别是left/right；
            // parent的大小是左右孩子之和
            parent = new HuffmanNode(left.key +right.key, left, right, null);
            left.parent = parent;
            right.parent = parent;
            // 将最小节点数据拷贝到“最小堆” 中
            heap.insert(parent);
        }
        mRoot = parent;
        // 销毁最小堆
        heap.destroy();
    }

    /**
     * @Description: 前序遍历 “Huffman树”
     * @date: 14:13 2018-9-17
     * @param: tree
     * @return: void
     */
    private void preOrder(HuffmanNode tree){
        if (tree != null){
            System.out.println(tree.key+ " ");
            preOrder(tree.left);
            preOrder(tree.right);
        }
    }

    public void preOrder(){
        preOrder(mRoot);
    }

    /**
     * @Description: 中序遍历 “Huffman树”
     * @date: 14:17 2018-9-17
     * @param: tree
     * @return: void
     */
    private void inOrder(HuffmanNode tree){
        if (tree != null){
            inOrder(tree.left);
            System.out.println(tree.key + " ");
            inOrder(tree.right);
        }
    }

    public void inOrder(){
        inOrder(mRoot);
    }

    private void postOrder(HuffmanNode tree){
        if (tree != null){
            postOrder(tree.left);
            postOrder(tree.right);
            System.out.println(tree.key + " ");
        }
    }

    public void postOrder(){
        postOrder(mRoot);
    }

    /**
     * @Description: 销毁“Huffman树”
     * @date: 14:20 2018-9-17
     * @param: tree
     * @return: void
     */
    private void destroy(HuffmanNode tree){
        if (tree == null){
            return;
        }
        if (tree.left != null){
            destroy(tree.left);
        }
        if (tree.right != null){
            destroy(tree.right);
        }

        tree = null;
    }

    public void destroy(){
        destroy(mRoot);
        mRoot = null;
    }

    /**
     * @Description: 打印“Huffman树”
     * @date: 14:35 2018-9-17
     * @param: tree
     * @param: key 节点的键值
     * @param: direction    -- 0 表示该节点是根节点
     *                      -- -1 表示该节点是它的父节点的左孩子
     *                      -- 1 表示该节点是它的父节点的右孩子
     * @return: void
     */
    private void print(HuffmanNode tree, int key, int direction){
        if (tree != null){
            if (direction == 0){
                System.out.printf("%2d is root\n", tree.key);
            }else {
                System.out.printf("%2d is %2d's %6s child\n", tree.key, key, direction == 1 ? "right" : "left");
            }

            print(tree.left, tree.key, -1);
            print(tree.right, tree.key, 1);
        }
    }

    public void print(){
        if (mRoot != null){
            print(mRoot, mRoot.key, 0);
        }
    }
}
