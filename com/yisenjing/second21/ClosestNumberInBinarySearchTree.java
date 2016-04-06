package com.yisenjing.second21;

import com.yisenjing.second4.TreeNode;

/**
 * Created by Yisen on 3/25/16.
 */
public class ClosestNumberInBinarySearchTree {

    public int finder(TreeNode root, int target) {

        int min = Integer.MAX_VALUE;

        while (root != null && min != target) {
            min = Math.abs(root.key - target) < Math.abs(min - target) ? root.key : min;
            if (root.key == target) {
                min = target;
            } else if (root.key < target) {
                root = root.right;
            } else if (root.key > target) {
                root = root.left;
            }
        }
        return min;
    }


}

