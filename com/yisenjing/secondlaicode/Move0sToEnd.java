package com.yisenjing.secondlaicode;

/**
 * Created by Yisen on 2/20/16.
 */
public class Move0sToEnd {

    public int[] movezeros(int[] array) {
        if (array == null) {
            return array;
        }

        int end = array.length - 1;
        int begin = 0;

        while (begin <= end) {
            if (array[begin] != 0) {
                begin++;
            } else if (array[end] == 0) {
                end--;
            } else {
                swap(array, begin++, end--);
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
