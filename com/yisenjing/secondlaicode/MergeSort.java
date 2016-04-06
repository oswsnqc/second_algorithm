package com.yisenjing.secondlaicode;

import java.util.Arrays;

/**
 * Created by Yisen on 2/20/16.
 */
public class MergeSort {

    public int[] mergeMain(int[] array) {
        int[] tmp = new int[array.length];
        merge(array, tmp, 0, array.length - 1);
        return array;
    }

    private void merge(int[] array, int[] tmp, int left, int right) {
        if (left < right) {
            int middle = left + (right - left) / 2;
            merge(array, tmp, left, middle);
            merge(array, tmp, middle + 1, right);
            sort(array, tmp, left, middle, right);
        }
    }

    private void sort(int[] array, int[] tmp, int left, int middle, int right) {
        int i = left;
        int j = middle + 1;
        int k = 0;

        while (i <= middle && j <= right) {
            if (array[i] < array[j]) {
                tmp[k++] = array[i++];
            } else {
                tmp[k++] = array[j++];
            }
        }

        while (i <= middle) {
            tmp[k++] = array[i++];
        }

        while (j <= right) {
            tmp[k++] = array[j++];
        }

        for (int p = 0; p < k; p++) {
            array[left + p] = tmp[p];
        }
    }

}
