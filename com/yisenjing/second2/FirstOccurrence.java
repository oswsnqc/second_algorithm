package com.yisenjing.second2;

/**
 * Created by Yisen on 2/21/16.
 */
public class FirstOccurrence {

    public int first(int[] array, int target) {

        if (array == null || array.length == 0) {
            return -1;
        }

        int start = 0;
        int end = array.length - 1;

        while (start < end - 1) {
            int middle = start + (end - start) / 2;
            if (array[middle] < target) {
                start = middle;
            } else {
                end = middle;
            }
        }

        if (array[start] == target) {
            return start;
        } else if (array[end] == target) {
            return end;
        } else {
            return -1;
        }
    }

}
