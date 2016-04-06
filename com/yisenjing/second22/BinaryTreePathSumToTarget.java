package com.yisenjing.second22;

import com.yisenjing.second4.TreeNode;

/**
 * Created by Yisen on 3/25/16.
 */
public class BinaryTreePathSumToTarget {


    public boolean exist(TreeNode root, int target, int sum) {

        if (root == null) {
            return false;
        }

        return summer(root, target, 0);
    }


    private boolean summer(TreeNode root, int target, int sum) {
        if (root == null) {
            return false;
        }
        sum = sum + root.key;
        if (sum == target) {
            return true;
        }
        boolean ll = summer(root.left, target, sum);
        boolean lr = summer(root.right, target, sum);
        return ll || lr || summer(root.left, target, 0) || summer(root.right, target, 0);
    }



}
