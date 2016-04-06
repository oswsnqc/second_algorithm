package com.yisenjing.second22;

import com.yisenjing.second4.TreeNode;

/**
 * Created by Yisen on 3/25/16.
 */
public class ReconstructBinarySearchTreeWithPostorderTraversal {

    public TreeNode reconsPost(int[] post) {

        int min = Integer.MIN_VALUE;
        int[] index = new int[]{post.length - 1};

        return helper(post, index, min);
    }


    private TreeNode helper(int[] post, int[] index, int min) {

        if (index[0] < 0 || post[index[0]] < min) { //当触底或者遍历完成后返回null
            return null;
        }
        TreeNode root = new TreeNode(post[index[0]--]);
        root.right = helper(post, index, root.key);
        root.left = helper(post, index, min);
        return root;
    }

}
