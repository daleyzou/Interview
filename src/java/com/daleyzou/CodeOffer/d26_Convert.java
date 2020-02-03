package com.daleyzou.CodeOffer;

/**
 * d26_Convert
 * @description 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 *              要求不能创建任何新的结点，只能调整树中结点指针的指向。
 * @author daleyzou
 * @date 2020年01月21日 18:45
 * @version 3.1.2
 */
public class d26_Convert {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null){
            return null;
        }
        if (pRootOfTree.left == null && pRootOfTree.right == null){
            return pRootOfTree;
        }

        TreeNode left = Convert(pRootOfTree.left);

        left.right = pRootOfTree;
        pRootOfTree.left = left;

        TreeNode right = Convert(pRootOfTree.right);

        TreeNode rightPoint = right;
        while (rightPoint.left != null){
            rightPoint = right.left;
        }
        rightPoint.left = pRootOfTree;
        pRootOfTree.right = rightPoint;
        return left != null ? left : pRootOfTree;
    }
}
