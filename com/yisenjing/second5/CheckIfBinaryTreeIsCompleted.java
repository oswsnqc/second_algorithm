package com.yisenjing.second5;
import com.yisenjing.second4.*;
import java.util.*;

import java.util.LinkedList;

/**
 * Created by Yisen on 3/2/16.
 */
public class CheckIfBinaryTreeIsCompleted {

    public boolean isBalance(TreeNode root) {
        if (root == null) {
            return true;
        }

        Queue<TreeNode> storage = new LinkedList<TreeNode>();
        storage.offer(root);
        boolean flag = false;
        while (storage.size() != 0) {
            TreeNode cur = storage.poll();
            if (cur.left == null) {
                flag = true;
            } else if (flag) {
                return false;
            } else {
                storage.offer(cur.left);
            }

            if (cur.right == null) {
                flag = true;
            } else if (flag) {
                return false;
            } else {
                storage.offer(cur.right);
            }
        }
        return true;
    }
}
