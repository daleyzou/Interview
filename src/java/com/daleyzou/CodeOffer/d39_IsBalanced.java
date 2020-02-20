package com.daleyzou.CodeOffer;

/**
 * d39_IsBalanced
 * @description 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 * @author daleyzou
 * @date 2020年02月18日 0:10
 * @version 1.1.11
 */
public class d39_IsBalanced {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
    public boolean IsBalanced_Solution(TreeNode root) {
        int[] depth = new int[]{0};

        return isBalance(root, depth);
    }

    private boolean isBalance(TreeNode root, int[] depth) {
        if (root == null){
            depth[0] = 0;
            return true;
        }
        int[] left = new int[]{0};
        int[] right = new int[]{0};
        if (isBalance(root.left, left)&&isBalance(root.right, right)){
            if (left[0] - right[0] >=-1 && left[0] - right[0] <=1){
                depth[0] = 1+ Math.max(left[0], right[0]);
                return true;
            }
        }
        return false;
    }
}
