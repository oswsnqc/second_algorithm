package com.yisenjing.second18;

import com.yisenjing.second4.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Yisen on 3/23/16.
 */
public class GetKeysInBinaryTreeLayerByLayerZigZagOrder {


    public List<Integer> zigZag(TreeNode root) {

        if (root == null) {
            return new ArrayList<Integer>();
        }
        Deque<TreeNode> storage = new LinkedList<TreeNode>();
        storage.offer(root);
        List<Integer> result = new ArrayList<Integer>();
        int layer = 1;
        while (!storage.isEmpty()) {
            int curSize = storage.size();
            for (int i = 0; i < curSize; i++) {
                if (layer % 2 == 1) {
                    TreeNode temp = storage.pollLast();
                    if (temp.right != null) {
                        storage.offerFirst(temp.right);
                    }
                    if (temp.left != null) {
                        storage.offerFirst(temp.left);
                    }
                    result.add(temp.key);
                } else {
                    TreeNode temp = storage.pollFirst();
                    if (temp.left != null) {
                        storage.offerLast(temp.left);
                    }
                    if (temp.right != null) {
                        storage.offerLast(temp.right);
                    }
                    result.add(temp.key);
                }
            }
            layer++;
        }
        return result;
    }
}
