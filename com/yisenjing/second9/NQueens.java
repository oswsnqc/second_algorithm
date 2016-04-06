package com.yisenjing.second9;

/**
 * Created by Yisen on 3/8/16.
 */
import java.util.*;
public class NQueens {

    public List<List<Integer>> nqueens(int n) {

        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> cur = new ArrayList<>();
        helper(result, cur, n);
        return result;
    }



    private void helper(List<List<Integer>> result, List<Integer> cur, int n) {
        if (cur.size() == n) {
            result.add(new ArrayList<Integer>(cur));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (ifValid(cur, i)) {
                cur.add(i);
                helper(result, cur, n);
                cur.remove(cur.size() - 1);
            }
        }
    }

    private boolean ifValid(List<Integer> cur, int column) {
        int row = cur.size();
        for (int i = 0; i < row; i++) {
            if (cur.get(i) == column || Math.abs(cur.get(i) - column) == row - i) {
                return false;
            }
        }
        return true;
    }

}
