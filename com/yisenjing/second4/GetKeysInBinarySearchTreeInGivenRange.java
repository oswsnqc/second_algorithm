package com.yisenjing.second4;

/**
 * Created by Yisen on 3/1/16.
 */
import java.util.*;
public class GetKeysInBinarySearchTreeInGivenRange {


    public List<Integer> rangeBST(TreeNode root, int min, int max) {
        List<Integer> result = new ArrayList<Integer>();
        if (root == null) {
            return result;
        }
        rangeBST(root, min, max, result);
        return result;
    }


    private void rangeBST(TreeNode root, int min, int max, List<Integer> result) {

        if (root == null) {
            return;
        }

        if (root.key > min) {
            rangeBST(root.left, min, max, result);
        }

        if (root.key <= max && root.key >= min) {
            result.add(root.key);
        }

        if (root.key < max) {
            rangeBST(root.right, min, max, result);
        }
    }

}
