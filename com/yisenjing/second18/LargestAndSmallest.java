package com.yisenjing.second18;

/**
 * Created by Yisen on 3/23/16.
 */
public class LargestAndSmallest {

    public int[] ls(int[] array) {
        if (array.length == 1) {
            return new int[]{array[0], array[0]};
        }
        int n = array.length;
        for (int i = 0; i < n / 2; i++) {
            if (array[i] < array[n - 1 - i]) {
                int temp = array[i];
                array[i] = array[n - 1 - i];
                array[n - 1 - i] = temp;
            }
        }
        return new int[]{largest(array, 0, (n - 1) / 2), smallest(array, n / 2, n - 1)};
    }

    private int largest(int[] array, int left, int right) {
        int largest = array[left];
        for (int i = left + 1; i <= right; i++) {
            largest = Math.max(largest, array[i]);
        }
        return largest;
    }

    private int smallest(int[] array, int left, int right) {
        int smallest = array[left];
        for (int i = left + 1; i <= right; i++) {
            smallest = Math.min(smallest, array[i]);
        }
        return smallest;
    }


}
