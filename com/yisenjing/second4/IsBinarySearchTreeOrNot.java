package com.yisenjing.second4;

/**
 * Created by Yisen on 3/1/16.
 */
public class IsBinarySearchTreeOrNot {

    public boolean binarySearchDetermine(TreeNode root) {
        if (root == null) {
            return true;
        }
        return binarySearchDetermine(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }


    private boolean binarySearchDetermine(TreeNode root, int min, int max) {
        if (root == null) {
            return true;
        }
        if (root.key < min || root.key > max) {
            return false;
        }
        return binarySearchDetermine(root.left, min, root.key - 1) && binarySearchDetermine(root.right, root.key + 1, max);
    }

}
