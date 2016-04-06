package com.yisenjing.second5;

import com.yisenjing.second4.*;

import java.util.ArrayList;
import java.util.*;

/**
 * Created by Yisen on 3/3/16.
 */
public class GetKeysInBinaryTreeLayerByLayer {

    public List<List<Integer>> layer(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> subList = new ArrayList<Integer>();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                subList.add(cur.key);

                if (cur.left != null) {
                    queue.offer(cur.left);
                }

                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }

            result.add(subList);
        }

        return result;
    }


}
