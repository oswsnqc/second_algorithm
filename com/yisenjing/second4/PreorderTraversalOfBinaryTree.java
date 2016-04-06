package com.yisenjing.second4;

import java.util.*;

/**
 * Created by Yisen on 2/26/16.
 */
public class PreorderTraversalOfBinaryTree {

    public List<Integer> preOrder(TreeNode root) {
        List<Integer> preorder = new ArrayList<Integer>();

        if (root == null) {
            return preorder;
        }

        Deque<TreeNode> stack = new LinkedList<TreeNode>();

        stack.offerFirst(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pollFirst();
            if (cur.right != null) {
                stack.offerFirst(cur.right);
            }
            if (cur.left != null) {
                stack.offerFirst(cur.left);
            }
            preorder.add(cur.key);

        }
        return preorder;
    }


}
