package com.yisenjing.second18;

/**
 * Created by Yisen on 3/23/16.
 */
public class TreeNodeP {

    public int key;
    public TreeNodeP left;
    public TreeNodeP right;
    public TreeNodeP parent;

    public TreeNodeP(int key, TreeNodeP parent) {
        this.key = key;
        this.parent = parent;
    }


}
