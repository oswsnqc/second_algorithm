package com.yisenjing.secondlaicode;

/**
 * Created by Yisen on 2/20/16.
 */
public class RainbowSort {


    public int[] rainbow(int[] array) {
        if (array == null) {
            return array;
        }

        int zero = 0;
        int netative = 0;
        int one = array.length - 1;

        while (zero <= one) {
            if (array[zero] == 1) {
                swap(array, zero, one--);
            } else if (array[zero] == 0) {
                zero++;
            } else {
                swap(array, netative++, zero++);
            }
        }
        return array;
    }

    private void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

}
