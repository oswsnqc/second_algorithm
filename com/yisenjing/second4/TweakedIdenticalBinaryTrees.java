package com.yisenjing.second4;

/**
 * Created by Yisen on 3/1/16.
 */
public class TweakedIdenticalBinaryTrees {
    public boolean tweaked(TreeNode one, TreeNode two) {
        if (one == null && two == null) {
            return true;
        } else if (one == null || two == null) {
            return false;
        } else if (one.key != two.key) {
            return false;
        }
        return tweaked(one.left, two.left) && tweaked(one.right, two.right) || tweaked(one.left, two.right) && tweaked(one.right, two.left);
    }
}
