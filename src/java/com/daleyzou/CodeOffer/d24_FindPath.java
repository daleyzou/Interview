package com.daleyzou.CodeOffer;

import java.util.ArrayList;

/**
 * d24_FindPath
 * @description
 * 输入一颗二叉树的跟节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。(注意: 在返回值的list中，数组长度大的数组靠前)
 * @author daleyzou
 * @date 2020年01月13日 22:05
 * @version 3.1.2
 */
public class d24_FindPath {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
    ArrayList<ArrayList<Integer>> resultList = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {

        if (root == null || root.val > target){
            return resultList;
        }
        ArrayList<Integer> path = new ArrayList<>();
        find(root, target, path);
        return resultList;
    }

    private void find(TreeNode root, int target, ArrayList<Integer> path) {
        if (root == null || root.val > target){
            path.remove(path.size() - 1);
            return;
        }
        if (root.val == target){
            path.add(root.val);
            resultList.add(new ArrayList<>(path));
            path.remove(path.size() - 1);
//            path.clear();
            return;
        }
        if (root.val < target){
            path.add(root.val);
            find(root.left, target - root.val, path);
            path.remove(path.size() - 1);
            find(root.right, target - root.val, path);
        }
    }
}
