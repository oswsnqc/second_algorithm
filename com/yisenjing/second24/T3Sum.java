package com.yisenjing.second24;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Yisen on 3/26/16.
 */
public class T3Sum {

    public List<List<Integer>> allTriples(int[] array, int target) {

        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(array);

        for (int i = 0; i < array.length - 2; i++) {
            int left = i + 1;
            int right = array.length - 1;

            if (i > 0 && array[i] == array[i - 1]) {
                continue;
            }

            while (left < right) {
                int sum = array[left] + array[right];
                if (sum + array[i] == target) {
                    result.add(Arrays.asList(array[left], array[right], array[i]));
                    left++;
                    while (left < right && array[left] == array[left - 1]) {
                        left++;
                    }
                } else if (sum + array[i] < target) {
                    left++;
                } else {
                    right--;
                }
            }

        }
        return result;
    }

}
