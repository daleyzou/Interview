package com.daleyzou.algorithm.huffman;

/**
 * @Author: DaleyZou
 * @Description: Huffman节点类
 * @Date: Created in 10:43 2018-9-17
 * @Modified By:
 */
public class HuffmanNode implements Comparable, Cloneable {
    protected int key;// 权值
    protected HuffmanNode left; // 左孩子
    protected HuffmanNode right; // 右孩子
    protected HuffmanNode parent; // 父节点

    protected HuffmanNode(int key, HuffmanNode left, HuffmanNode right, HuffmanNode parent){
        this.key = key;
        this.left = left;
        this.right = right;
        this.parent = parent;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Object obj = null;
        try {
            // Object 中的clone()识别出你要复制的是哪一个对象
            obj = (HuffmanNode)super.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println(e.toString());
        }
        return obj;
    }

    @Override
    public int compareTo(Object o) {
        return this.key - ((HuffmanNode)o).key;
    }
}
