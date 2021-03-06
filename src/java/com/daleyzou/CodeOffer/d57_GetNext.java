package com.daleyzou.CodeOffer;

/**
 * d57_GetNext
 * @description 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
 *              注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 * @author daleyzou
 * @date 2020年11月24日 15:11
 * @version 1.1.1
 */
public class d57_GetNext {
    public class TreeLinkNode {
        int val;

        TreeLinkNode left = null;

        TreeLinkNode right = null;

        TreeLinkNode next = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }

    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        // 分两种情况 1、节点右子树不为空 -》 第一个没有左子节点的   2、有子树为空 -》最左的父节点
        if (pNode == null){
            return null;
        }
        if (pNode.right != null){
            TreeLinkNode node = pNode.right;
            while (node.left != null){
                node = node.left;
            }
            return node;
        }else {
            TreeLinkNode parent = pNode.next;
            while (parent != null){
                if (parent.left == pNode){
                    return parent;
                }
                pNode = parent;
                parent = parent.next;
            }
        }
        return null;
    }
}
