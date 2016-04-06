package com.yisenjing.second9;
import com.yisenjing.second4.TreeNode;
/**
 * Created by Yisen on 3/8/16.
 */
public class LowestCommonAncestorI {

    public TreeNode lca(TreeNode root, TreeNode one, TreeNode two) {

        if (root == null) {
            return root;
        }

        if (root == one || root == two) {
            return root;
        }

        TreeNode ll = lca(root.left, one, two);
        TreeNode lr = lca(root.right, one, two);

        if (ll != null && lr != null) {
            return root;
        }

        return ll == null ? lr : ll;
    }

}
