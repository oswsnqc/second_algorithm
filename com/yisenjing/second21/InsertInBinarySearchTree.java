package com.yisenjing.second21;

import com.yisenjing.second4.TreeNode;

/**
 * Created by Yisen on 3/24/16.
 */
public class InsertInBinarySearchTree {


    public TreeNode insert(TreeNode root, int key) {


        if (root == null) {
            return new TreeNode(root.key);
        }

        if (root.key < key) {
            if (root.right == null) {
                root.right = new TreeNode(key);
            } else {
                insert(root.right, key);
            }
        }

        if (root.key > key) {
            if (root.left == null) {
                root.left = new TreeNode(key);
            } else {
                insert(root.left, key);
            }
        }
        return root;
    }



}
