package com.daleyzou.CodeOffer;

/**
 * d38_TreeDepth
 * @description 输入一棵二叉树，求该树的深度。
 * 从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度
 * @author daleyzou
 * @date 2020年02月17日 23:28
 * @version 1.1.11
 */
public class d38_TreeDepth {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
    int result = 0;
    public int TreeDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        int left = TreeDepth(root.left);
        int right = TreeDepth(root.right);
        return left > right ? left+1:right+1;
    }

    private void findPath(TreeNode root, int count) {
        if (root == null){
            result = result > count-1 ? result:count-1;
        }
        findPath(root.left, count + 1);
        findPath(root.right, count + 1);
    }

    public static void main(String[] args){
//        d38_TreeDepth object = new d38_TreeDepth();
//        d38_TreeDepth.TreeNode node1 = new d38_TreeDepth.TreeNode(1);
//        TreeNode node2 = new TreeNode(2);
//        TreeNode node3 = new TreeNode(3);
//        node1.left = node2;
//        node1.right = node3;
//        int i = object.TreeDepth(node1);
//        System.out.println(i);
    }
}
