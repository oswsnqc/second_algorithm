package com.yisenjing.second7;

import java.util.HashSet;
import java.util.Hashtable;

/**
 * Created by Yisen on 3/4/16.
 */
public class MissingNumberI {

    public int missing(int[] array) {

        HashSet<Integer> set = new HashSet<>();

        int n = array.length + 1;

        for (int i = 0; i < array.length; i++) {
            set.add(array[i]);
        }

        for (int i = 1; i < n; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }
        return n;
    }

}
