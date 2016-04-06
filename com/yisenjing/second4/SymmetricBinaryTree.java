package com.yisenjing.second4;

/**
 * Created by Yisen on 3/1/16.
 */
public class SymmetricBinaryTree {

    public boolean symmetricBT(TreeNode root) {

        if (root == null) {
            return true;
        }
        return symmetricBT(root.left, root.right);
    }

    private boolean symmetricBT(TreeNode one, TreeNode two) {
        if (one == null && two == null) {
            return true;
        } else if (one == null || two == null) {
            return false;
        } else if (one.key != two.key) {
            return false;
        }
        return symmetricBT(one.left, two.right) && symmetricBT(one.right, two.left);
    }

}
