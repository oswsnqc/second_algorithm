package com.yisenjing.second24;

import javafx.util.Pair;

import java.util.*;

/**
 * Created by Yisen on 3/26/16.
 */
public class T2SumAllPairII {

    public List<List<Integer>> allPairs(int[] array, int target) {

        List<List<Integer>> result = new ArrayList<List<Integer>>();

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int num : array) {

            Integer count = map.get(num);
            if (num * 2 == target && count != null && count == 1) {
                result.add(Arrays.asList(num, num));
            } else if (map.containsKey(target - num) && count == null) {
                result.add(Arrays.asList(target - num, num));
            }

            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }

        }
        return result;
    }



}
