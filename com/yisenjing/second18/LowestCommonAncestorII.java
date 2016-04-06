package com.yisenjing.second18;

/**
 * Created by Yisen on 3/23/16.
 */
public class LowestCommonAncestorII {


    public TreeNodeP lowII(TreeNodeP one, TreeNodeP two) {
        int ll = getHeight(one);
        int lr = getHeight(two);

        if (ll > lr) {
            return merge(two, one, ll - lr);
        } else {
            return merge(one, two, lr - ll);
        }
    }

    private int getHeight(TreeNodeP node) {
        int length = 0;
        while (node != null) {
            length++;
            node = node.parent;
        }
        return length;
    }

    private TreeNodeP merge(TreeNodeP shorter, TreeNodeP longer, int diff) {

        while (diff > 0) {
            diff--;
            longer = longer.parent;
        }

        while (longer != shorter) { //可能key有重复,但是node其本身不会重复
            longer = longer.parent;
            shorter = shorter.parent;
        }
        return longer;
    }





}
