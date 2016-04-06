package com.yisenjing.second18;

import com.yisenjing.second4.TreeNode;
import java.util.*;

/**
 * Created by Yisen on 3/23/16.
 */
public class LowestCommonAncestorIV {

    public TreeNode lowIV(TreeNode root, List<TreeNode> nodes) {

        Set<TreeNode> set = new HashSet<>(nodes);
        return helper(root, set);
    }

    private TreeNode helper(TreeNode root, Set<TreeNode> set) {


        if (root == null) { //触底
            return root;
        }

        if (set.contains(root)) {   //遇到本层含有root
            return root;
        }

        TreeNode ll = helper(root.left, set);
        TreeNode lr = helper(root.right, set);

        if (ll != null && lr != null) { //此层有共同数值
            return root;
        }
        return ll != null ? ll : lr; //最终特殊情况,也就是全部在一条线上的
    }

}
