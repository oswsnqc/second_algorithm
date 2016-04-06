package com.yisenjing.second22;

import com.yisenjing.second4.TreeNode;

/**
 * Created by Yisen on 3/25/16.
 */
public class MaximumPathSumBinaryTreeIII {

    public int maxPathIII(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int[] sum = new int[]{Integer.MIN_VALUE};
        maxFinder(root, sum);
        return sum[0];
    }


    private int maxFinder(TreeNode root, int[] sum) {

        if (root == null) {
            return 0;
        }

        int left = maxFinder(root.left, sum);
        int right = maxFinder(root.right, sum);

        sum[0] = Math.max(sum[0], Math.max(root.key, Math.max(left, right) + root.key));
        return Math.max(root.key, root.key + Math.max(left, right));
    }


}
