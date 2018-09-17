package com.daleyzou.algorithm.huffman;

import jdk.nashorn.internal.ir.WhileNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: DaleyZou
 * @Description: 最小堆的类
 * @Date: Created in 10:40 2018-9-17
 * @Modified By:
 */
public class MinHeap {
    private List<HuffmanNode> mHeap; // 存放堆的数组

    /**
     * @Description: 创建最小堆
     * @date: 10:58 2018-9-17
     * @param: a 数据所在的数组
     * @return:
     */
    public MinHeap(int a[]) {
        mHeap = new ArrayList<HuffmanNode>();
        // 初始化数组
        for (int i = 0; i < a.length; i++){
            HuffmanNode node = new HuffmanNode(a[i], null, null, null);
            mHeap.add(node);
        }

        // 从(size/2-1) --> 0逐次遍历。遍历之后，得到的数组实际上是一个最小堆。
        for (int i = a.length / 2 - 1; i >= 0; i--){
            filterdown(i, a.length - 1);
        }
    }

    /**
     * @Description: 最小堆向下调整算法
     *              注：
     *              数组实现的堆中，第N个节点的左孩子的索引值是（2N+1）,右孩子的索引是(2N+2)。
     * @date: 11:04 2018-9-17
     * @param: start 被下调节点的起始位置（一般为0，表示从第一个开始）
     * @param: end 截止范围（一般为数组中最后一个元素的索引）
     * @return: void
     */
    private void filterdown(int start, int end) {
        int c = start; // 当前（current）节点的位置
        int l = 2 * c + 1; // 左（left）节点的位置
        HuffmanNode tmp = mHeap.get(c);// 当前（current）jied
        while (l <= end){
            // “l”是左节点， “l+1”是右节点
            if (l < end && (mHeap.get(l).compareTo(mHeap.get(l + 1)) > 0)){
                l++; // 左右两孩子中选择较小者，即mHeap[l+1]
            }
            int cmp = tmp.compareTo(mHeap.get(l));
            if (cmp <= 0){
                break; // 调整结束
            }else {
                mHeap.set(c, mHeap.get(l));
                c = l;
                l = 2 * l + 1;
            }
        }
        mHeap.set(c, tmp);
    }

    /**
     * @Description: 最小堆的向上调整算法（从start开始向上知道0，调整堆）
     * 注： 数组实现的堆中，第N个节点的左孩子的索引值是（2N+1），右孩子的索引是（2N+2）、
     * @date: 11:37 2018-9-17
     * @param: start 被上调节点的起始位置（一般为数组中最后一个元素的索引）
     * @return: void
     */
    private void filterup(int start){
        int c = start; // 当前节点的位置
        int p = (c - 1) / 2;// 父节点的位置
        HuffmanNode tmp = mHeap.get(c); // 当前节点

        while (c > 0){
            int cmp = mHeap.get(p).compareTo(tmp);
            if (cmp <= 0){
                break;
            }else {
                mHeap.set(c, mHeap.get(p));
                c = p;
                p = (p - 1) / 2;
            }
        }
        mHeap.set(c, tmp);
    }

    /**
     * @Description: 将node插入二叉堆中
     * @date: 11:54 2018-9-17
     * @param: node 一个节点
     * @return: void
     */
    protected void insert(HuffmanNode node){
        int size = mHeap.size();

        mHeap.add(node); // 将“数组”插在表尾
        filterup(size); // 向上调整堆
    }

    /**
     * @Description: 交换两个Huffman节点的全部数据
     * @date: 11:57 2018-9-17
     * @param: i
     * @param: j
     * @return: void
     */
    private void swapNode(int i , int j){
        HuffmanNode tmp = mHeap.get(i);
        mHeap.set(i, mHeap.get(j));
        mHeap.set(j, tmp);
    }

    /**
     * @Description: 新建一个节点，并将最小堆中最小节点的数据复制给该节点，
     *              然后除最小节点之外的数据重新构造成最小堆。
     * @date: 12:50 2018-9-17
     * @param:
     * @return: 成功返回根节点，失败返回null
     */
    protected HuffmanNode dumpFromMinimum(){
        int size = mHeap.size();

        // 如果堆已空，则返回null
        if (size == 0){
            return null;
        }
        HuffmanNode node = null;
        try {
            // 将 “最小节点” 克隆一份，将克隆得到的对象赋值给node
            node = (HuffmanNode)mHeap.get(0).clone();
        } catch (CloneNotSupportedException e) {
            System.out.println(e.toString());
        }
        // 交换“最小节点”和最后一个节点
        mHeap.set(0, mHeap.get(size - 1));
        // 删除最后的元素
        mHeap.remove(size - 1);
        if (mHeap.size() > 1){
            filterdown(0, mHeap.size() - 1);
        }
        return node;
    }

    protected void destroy(){
        mHeap.clear();;
        mHeap = null;
    }
}
