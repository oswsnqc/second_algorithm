package com.yisenjing.second4;

/**
 * Created by Yisen on 2/26/16.
 */
import java.util.*;
public class PostorderTraversalOfBinaryTree {

    public List<Integer> postOrder(TreeNode root) {

        List<Integer> postorder = new ArrayList<Integer>();

        if (root == null) {
            return postorder;
        }

        Deque<TreeNode> stack = new LinkedList<TreeNode>();

        stack.offerFirst(root);

        while (!stack.isEmpty()) {

            TreeNode cur = stack.pollFirst();

            if (cur.left != null) {
                stack.offerFirst(cur.left);
            }

            if (cur.right != null) {
                stack.offerFirst(cur.right);
            }
            postorder.add(cur.key);
        }

        Collections.reverse(postorder);
        return postorder;

    }

}
