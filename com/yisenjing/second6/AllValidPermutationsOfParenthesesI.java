package com.yisenjing.second6;

/**
 * Created by Yisen on 3/3/16.
 */
import java.util.*;
public class AllValidPermutationsOfParenthesesI {

    public List<String> parenthesesi(int n) {
        List<String> result = new ArrayList<String>();
        if (n == 0) {
            return result;
        }
        char[] array = new char[2 * n];
        helper(array, n, n, 0, result);
        return result;
    }

    private void helper(char[] array, int left, int right, int index, List<String> result) {
        if (left == 0 && right == 0) {
            result.add(new String(array));
            return;
        }
        if (left > 0) {
            array[index] = '(';
            helper(array, left - 1, right, index + 1, result);
        }
        if (right > left) {
            array[index] = ')';
            helper(array, left, right - 1, index + 1, result);
        }
    }
}
