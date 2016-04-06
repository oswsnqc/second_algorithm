package com.yisenjing.second12;

/**
 * Created by Yisen on 3/20/16.
 */
public class LongestAscendingSubArray {

    public int longest(int[] array) {
        int cur = 1;
        int result = 1;
        for (int i = 1; i < array.length; i++) {
            if (array[i] > array[i - 1]) {
                cur += 1;
                result = Math.max(cur, result);
            } else {
                cur = 1;
            }
        }
        return result;
    }
}
