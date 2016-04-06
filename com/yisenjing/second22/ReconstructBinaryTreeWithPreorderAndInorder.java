package com.yisenjing.second22;

import com.yisenjing.second4.TreeNode;

/**
 * Created by Yisen on 3/25/16.
 */
public class ReconstructBinaryTreeWithPreorderAndInorder {

    public TreeNode preInCon(int[] in, int[] pre) {


        if (in.length == 0 && pre.length == 0) {
            return null;
        }

        int[] preIndex = new int[]{0};
        int[] inIndex = new int[]{0};

        return helperII(pre, in, preIndex, inIndex, Integer.MAX_VALUE);
    }

    private TreeNode helperII(int[] pre, int[] in, int[] preIndex, int[] inIndex, int target) {
        if (in[inIndex[0]] >= in.length || in[inIndex[0]] == target) {
            return null;
        }

        TreeNode root = new TreeNode(pre[preIndex[0]]);
        preIndex[0]++;
        root.left = helperII(pre, in, preIndex, inIndex, root.key);
        inIndex[0]++;
        root.right = helperII(pre, in, preIndex, inIndex, target);
        return root;
    }




}
