package com.yisenjing.second2;

/**
 * Created by Yisen on 2/22/16.
 */
public class ClosestInSortedArray {

    public int closestSorted(int[] array, int target) {

        if (array == null || array.length == 0) {
            return -1;
        }

        int start = 0;
        int end = array.length - 1;

        while (start < end - 1) {
            int middle = start + (end - start) / 2;
            if (array[middle] < target) {
                start = middle;
            } else if (array[middle] > target){
                end = middle;
            } else {
                return middle;
            }
        }

        if (Math.abs(array[start] - target) < Math.abs(array[end] - target)) {
            return start;
        }

        return end;
    }

}
