package com.daleyzou.CodeOffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * d22_PrintFromTopToBottom
 * @description 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 * @author zoudaifa
 * @date 2020年01月09日 21:45
 * @version 3.1.2
 */
public class d22_PrintFromTopToBottom {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> begin = new ArrayList<>();
        if (root == null){
            return begin;
        }
        begin.add(root.val);
        getValue(root, begin);
        return begin;
    }

    private void getValue(TreeNode root, ArrayList<Integer> begin) {
        if (root.left != null){
            begin.add(root.left.val);
        }
        if (root.right != null){
            begin.add(root.right.val);
        }
        if (root.left != null){
            getValue(root.left, begin);
        }
        if (root.right != null){
            getValue(root.right, begin);
        }
    }
}
