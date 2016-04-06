package com.yisenjing.second22;

import com.yisenjing.second4.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Yisen on 3/25/16.
 */
public class ReconstructBinaryTreeWithLevelorderAndInorder {

    public TreeNode reconstruct(int[] in, int[] level) {


        Map<Integer, Integer> memory = new HashMap<Integer, Integer>();

        for (int i = 0; i < in.length; i++) {
            memory.put(in[i], i);
        }

        List<Integer> levelList = new ArrayList<Integer>();

        for (int pp : level) {
            levelList.add(pp);
        }
        return helper(memory, levelList);
    }


    private TreeNode helper(Map<Integer, Integer> memory, List<Integer> levelList) {

        if (levelList.isEmpty()) {
            return null;
        }

        TreeNode root = new TreeNode(levelList.remove(0));

        List<Integer> left = new ArrayList<Integer>();
        List<Integer> right = new ArrayList<Integer>();

        for (int pl : levelList) {
            if (memory.get(pl) < memory.get(root.key)) {
                left.add(pl);
            } else {
                right.add(pl);
            }
        }

        root.left = helper(memory, left);
        root.right = helper(memory, right);
        return root;
    }


}
