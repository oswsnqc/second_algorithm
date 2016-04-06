package com.yisenjing.second21;

import com.yisenjing.second4.TreeNode;

/**
 * Created by Yisen on 3/24/16.
 */
public class SearchInBinarySearchTree {

    public TreeNode search(TreeNode root, int key) {

        if (root == null) {
            return root;
        }

        if (root.key == key) {
            return root;
        }

        if (root.key < key) {
            return search(root.right, key);
        }

        if (root.key > key) {
            return search(root.left, key);
        }
        return root;
    }



}
