package com.yisenjing.second2;

/**
 * Created by Yisen on 2/21/16.
 */
public class LastOccurance {
    public int lastO(int[] array, int target) {

        if (array == null || array.length == 0) {
            return -1;
        }

        int start = 0;
        int end = array.length - 1;

        while (start < end - 1) {
            int middle = start + (end - start) / 2;
            if (array[middle] > target) {
                end = middle;
            } else {
                start = middle;
            }
        }

        if (array[start] == array[end] && array[start] == target) {
            return end;
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
