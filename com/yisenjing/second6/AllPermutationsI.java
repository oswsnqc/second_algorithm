package com.yisenjing.second6;

/**
 * Created by Yisen on 3/3/16.
 */
import java.util.*;
public class AllPermutationsI {

    public List<String> permutationi(String set) {
        List<String> result = new ArrayList<String>();
        if (set == null) {
            return result;
        }
        char[] array = set.toCharArray();
        helper(array, 0, result);
        return result;
    }

    private void helper(char[] array, int index, List<String> result) {
        if (index == array.length) {
            result.add(new String(array));
            return;
        }

        for (int i = index; i < array.length; i++) {
            swap(array, i, index);
            helper(array, index + 1, result);
            swap(array, i, index);
        }
    }

    private void swap(char[] array, int x, int y) {
        char tmp = array[x];
        array[x] = array[y];
        array[y] = tmp;
    }

}
