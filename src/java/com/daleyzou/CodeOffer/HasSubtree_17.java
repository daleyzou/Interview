/**
 * @projectName Interview
 * @package com.daleyzou.CodeOffer
 * @className com.daleyzou.CodeOffer.HasSubtree_17
 * @copyright Copyright 2020 daleyzou, Inc. All rights reserved.
 */
package com.daleyzou.CodeOffer;

/**
 * HasSubtree_17
 * @description TODO
 * @author daleyzou
 * @date 2020年01月03日 22:19
 * @version 1.0.0
 */
public class HasSubtree_17 {
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
        if (root1 == null){
            return false;
        }
        if (root1.val != root2.val) {
            return false;
        }
        return isSame(root1.left, root2.left) && isSame(root1.right, root2.right);
    }

    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if (root1 == null | root2 == null) {
            return false;
        }
        return isSame(root1, root2) || HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);
    }
}
