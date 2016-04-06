package com.yisenjing.second4;


import java.util.*;

/**
 * Created by Yisen on 2/26/16.
 */
public class InorderTraversalOfBinaryTree {

    public List<Integer> inorderiterative(TreeNode root) {
        List<Integer> inorder = new ArrayList<Integer>();
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.offerFirst(cur);
                cur = cur.left;
            } else {
                cur = stack.pollFirst();
                inorder.add(cur.key);
                cur = cur.right;
            }
        }
        return inorder;
    }


}
