package com.yisenjing.second20;

import com.yisenjing.second4.TreeNode;

/**
 * Created by Yisen on 3/23/16.
 */
public class MaximumPathSumBinaryTreeI {

    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int[] max = new int[]{Integer.MIN_VALUE};
        return finder(root, max);
    }

    private int finder(TreeNode root, int[] max) {
        if (root == null) {
            return 0;
        }
        int left = finder(root.left, max);
        int right = finder(root.right, max);
        if (root.left != null && root.right != null) {
            max[0] = Math.max(max[0], left + right + root.key);
            return Math.max(left, right) + root.key; //为上面更新做准备
        }
        return root.left == null ? right + root.key : left + root.key;
    }


}
