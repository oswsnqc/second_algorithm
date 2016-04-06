package com.yisenjing.second21;

import com.yisenjing.second4.TreeNode;

/**
 * Created by Yisen on 3/24/16.
 */
public class DeleteInBinarySearchTree {

    public TreeNode delete(TreeNode root, int key) {

        if (root == null) {
            return null;
        }

        if (root.key < key) {
            root.right = delete(root.right, key);
        }

        if (root.key > key) {
            root.left = delete(root.left, key);
        }

        if (root.key == key) {
            if (root.left == null && root.right == null) {
                return null;
            } else if (root.left == null) {
                return root.right;      //无数层root.right
            } else if (root.right == null) {
                return root.left;
            } else {
                if (root.right.left == null) {
                    TreeNode temp = root.right;
                    temp.left = root.left;
                    temp.right = root.right.right;
                    return temp;
                } else {
                    TreeNode temp = findSmallest(root.right);
                    temp.left = root.left;
                    temp.right = root.right;
                    return temp;
                }
            }
        }
        return root;
    }


    private TreeNode findSmallest(TreeNode root) {
        while (root.left.left != null) {
            root = root.left;
        }

        TreeNode cur = root.left;
        root.left = root.left.left;
        return cur;
    }




}
