/**
 * @projectName Interview
 * @package com.daleyzou.CodeOffer
 * @className com.daleyzou.CodeOffer.d17_HasSubtree
 * @copyright Copyright 2020 daleyzou, Inc. All rights reserved.
 */
package com.daleyzou.CodeOffer;

/**
 * d17_HasSubtree
 * @description 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 * @author daleyzou
 * @date 2020年01月03日 22:19
 * @version 1.0.0
 */
public class d17_HasSubtree {
    public class TreeNode {
        int val = 0;

        TreeNode left = null;

        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    public boolean isSame(TreeNode root1, TreeNode root2) {
        if (root2 == null){
            return true;
        }

        // 为啥这儿是 false
        if (root1 == null){
            return false;
        }
        if (root1.val != root2.val) {
            return false;
        }
        return isSame(root1.left, root2.left) && isSame(root1.right, root2.right);
    }

    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) {
            return false;
        }
        return isSame(root1, root2) || HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);
    }
}
