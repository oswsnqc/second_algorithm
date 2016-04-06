package com.yisenjing.second4;

/**
 * Created by Yisen on 2/26/16.
 */
public class CheckIfBinaryTreeIsBalanced {

    public boolean balanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        return height(root) != -1;
    }

    private int height(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int leftHeight = height(root.left);

        //左支流
        if (leftHeight == -1) {
            return -1;
        }

        int rightHeight = height(root.right);

        //右支流
        if (rightHeight == -1) {
            return -1;
        }


        //由初始化绝对高度往判断语句的转变
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }

        //初始化要返回的
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
