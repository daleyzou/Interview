package com.daleyzou.CodeOffer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

/**
 * d59_PrintZ
 * @description TODO
 * @author daleyzou
 * @date 2020年11月25日 23:04
 * @version 1.1.1
 */
public class d59_PrintZ {
    public class TreeNode {
        int val = 0;

        TreeNode left = null;

        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> resultList = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (pRoot == null) {
            return resultList;
        }
        queue.add(pRoot);
        boolean isReverse = false;
        while (!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<Integer> tempList = new ArrayList<>();
            while (size-- > 0) {
                TreeNode poll = queue.poll();
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
                tempList.add(poll.val);
            }
            if (isReverse) {
                Collections.reverse(tempList);
            }
            isReverse = !isReverse;
            if (tempList.size() != 0) {
                resultList.add(tempList);
            }
        }
        return resultList;
    }
}
