package com.yisenjing.second2;

/**
 * Created by Yisen on 2/21/16.
 */
public class ClassicBinarySearch {
    public int binarySearch(int[] array, int target) {
        return binaryHelper(array, 0, array.length - 1, target);
    }

    private int binaryHelper(int[] array, int start, int end, int target) {
        if (start <= end) {
            int middle = start + (end - start) / 2;
            if (array[middle] < target) {
                return binaryHelper(array, middle + 1, end, target);
            } else if (array[middle] > target) {
                return binaryHelper(array, start, middle - 1, target);
            } else {
                return middle;
            }
        }
        return -1;
    }
}
