package com.yisenjing.secondlaicode;

/**
 * Created by Yisen on 2/20/16.
 */
public class SelectionSort {
    public int[] selsctSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    int tmp = array[i];
                    array[i] = array[j];
                    array[j] = tmp;
                }
            }
        }
        return array;
    }
}
