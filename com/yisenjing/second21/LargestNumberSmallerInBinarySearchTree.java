package com.yisenjing.second21;

import com.yisenjing.second4.TreeNode;

/**
 * Created by Yisen on 3/25/16.
 */
public class LargestNumberSmallerInBinarySearchTree {
    public int largestSmaller(TreeNode root, int target) {

        int min = Integer.MIN_VALUE;

        while (root != null) {
            if (root.key < target) {
                min = Math.abs(root.key - target) < Math.abs(min - target) ? root.key : min;
                root = root.right;
            } else {
                root = root.left;
            }
        }
        return min;
    }
}
