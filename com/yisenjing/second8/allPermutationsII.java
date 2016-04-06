package com.yisenjing.second8;

/**
 * Created by Yisen on 3/5/16.
 */
import java.util.*;
public class allPermutationsII {

    public List<String> permutations(String set) {
        List<String> result = new ArrayList<String>();
        if (set == null) {
            return result;
        }

        if (set.length() == 0) {
            result.add("");
            return result;
        }

        char[] array = set.toCharArray();
        HashSet<String> hash = new HashSet<>();
        DFS(array, result, hash, 0);
        System.out.println(result);
        return result;
    }

    private void DFS(char[] array, List<String> result, HashSet<String> hash, int index) {
        if (index == array.length && !hash.contains(new String(array))) {
            result.add(new String(array));
            hash.add(new String(array));
        }

        for (int i = index; i < array.length; i++) {
            swap(array, i, index);
            DFS(array, result, hash, index + 1);
            swap(array, i, index);
        }
    }

    private void swap(char[] array, int left, int right) {
        char temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }

}
