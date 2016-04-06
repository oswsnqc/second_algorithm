package com.yisenjing.second25;

/**
 * Created by Yisen on 3/27/16.
 */
public class LargestRectangleInHistogram {

    public int largest(int[] array) {


        if (array == null || array.length == 0) {
            return 0;
        }
        int result = 0;
        for (int i = 0; i < array.length; i++) {
            int curHeight = Integer.MAX_VALUE;
            for (int j = i; j < array.length; j++) {
                curHeight = Math.min(curHeight, array[j]);
                result = Math.max(result, curHeight * (j - i + 1));
            }
        }
        return result;
    }
}
