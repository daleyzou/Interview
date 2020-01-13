package com.daleyzou.CodeOffer;

/**
 * d18_Mirror
 * @description TODO
 * @author daleyzou
 * @date 2020年01月08日 20:02
 * @version 3.1.2
 */
public class d18_Mirror {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
    public void Mirror(TreeNode root) {
        swapNode(root);
    }

    private void swapNode(TreeNode root) {
        if (root == null){
            return;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        swapNode(root.left);
        swapNode(root.right);
    }
}
