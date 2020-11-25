package com.daleyzou.CodeOffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * d60_PrintMany
 * @description 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行
 * @author daleyzou
 * @date 2020年11月25日 23:58
 * @version 1.1.1
 */
public class d60_PrintMany {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> resultList = new ArrayList<>();
        if (pRoot == null){
            return resultList;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(pRoot);
        while (!queue.isEmpty()){
            ArrayList<Integer> tempList = new ArrayList<>();
            int size = queue.size();
            while (size-- > 0){
                TreeNode node = queue.poll();
                if (node.left != null){
                    queue.offer(node.left);
                }
                if (node.right != null){
                    queue.offer(node.right);
                }
                tempList.add(node.val);
            }
            if (tempList.size() != 0){
                resultList.add(tempList);
            }
        }
        return resultList;
    }
}
