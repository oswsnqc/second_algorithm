package com.yisenjing.second24;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by Yisen on 3/26/16.
 */
public class T2SumAllPairI {
    public List<List<Integer>> allPairs(int[] array, int target) {

        List<List<Integer>> result = new ArrayList<List<Integer>>();

        Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();

        for (int i = 0; i < array.length; i++) {
            List<Integer> indice = map.get(target - array[i]);
            if (indice != null) {
                for (int j : indice) {
                    result.add(Arrays.asList(j, i));
                }
            }
            if (!map.containsKey(array[i])) {
                map.put(array[i], new ArrayList<Integer>());
            }
            map.get(array[i]).add(i);
        }
        return result;
    }
}
