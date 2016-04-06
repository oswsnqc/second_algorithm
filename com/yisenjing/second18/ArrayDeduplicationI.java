package com.yisenjing.second18;

import java.util.Arrays;

/**
 * Created by Yisen on 3/23/16.
 */
public class ArrayDeduplicationI {

    public int[] dedup(int[] array) {

        if (array.length <= 1) {
            return array;
        }

        int end = 0;

        for (int i = 1; i < array.length; i++) {
            if (array[i] != array[end]) {
                array[++end] = array[i];
            }
        }
        return Arrays.copyOf(array, end + 1);
    }



}
