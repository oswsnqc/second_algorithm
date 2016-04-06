package com.yisenjing.second2;

/**
 * Created by Yisen on 2/22/16.
 */
public class KClosestInSortedArray {


    public int[] kcloset(int[] array, int target, int k) {

        if (array == null || array.length == 0 || k == 0) {
            return new int[]{};
        }

        if (k > array.length) {
            k = array.length;
        }

        int start = 0;
        int end = array.length - 1;
        int[] result = new int[k];

        while (start < end - 1) {
            int middle = start + (end - start) / 2;
            if (array[middle] < target) {
                start = middle;
            } else {
                end = middle;
            }
        }

        int i = 0;
        while (i < k) {
            if (start >= 0 && end < array.length) {
                if (Math.abs(array[start] - target) < Math.abs(array[end] - target)) {
                    result[i++] = array[start--];
                } else {
                    result[i++] = array[end++];
                }
            } else if (start >= 0) {
                result[i++] = array[start--];
            } else if (end < array.length) {
                result[i++] = array[end++];
            }
        }
        return result;
    }
}
