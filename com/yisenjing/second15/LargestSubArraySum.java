package com.yisenjing.second15;

import java.util.Arrays;

/**
 * Created by Yisen on 3/21/16.
 */
public class LargestSubArraySum {

    public int longestSum(int[] array) {

        if (array.length == 0) {
            return 0;
        }

        int[][] record = new int[array.length][array.length];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            for (int j = i; j < array.length; j++) {
                if (j == i) {
                    record[i][j] = array[i];
                } else {
                    record[i][j] = record[i][j - 1] + array[j];
                }
                max = Math.max(max, record[i][j]);
            }
        }
        for (int i = 0; i < record.length; i++) {
            System.out.println(Arrays.toString(record[i]));
        }
        return max;
    }
}
