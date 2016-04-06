package com.yisenjing.second24;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Yisen on 3/26/16.
 */
public class T4Sum {

    public boolean exist(int[] array, int target) {

        Map<Integer, int[]> map = new HashMap<Integer, int[]>();

        for (int i = 1; i < array.length; i++) {
            for (int j = 0; j < i; j++) {
                int pairSum = array[i] + array[j];

                if (map.containsKey(target - pairSum) && map.get(target - pairSum)[1] < j) {
                    return true;
                }
                if (!map.containsKey(pairSum)) {
                    map.put(pairSum, new int[]{j, i});
                }
            }
        }
        return false;
    }




}
