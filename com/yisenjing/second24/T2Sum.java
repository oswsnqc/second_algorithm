package com.yisenjing.second24;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Yisen on 3/26/16.
 */
public class T2Sum {

    public boolean existSum(int[] array, int target) {

        Set<Integer> hash = new HashSet<Integer>();
        for (int num : array) {
            if (hash.contains(target - num)) {
                return true;
            }
            hash.add(num);
        }
        return false;
    }
}
