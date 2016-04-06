package com.yisenjing.second21;

import java.util.Arrays;

/**
 * Created by Yisen on 3/24/16.
 */
public class MergeStones {

    ///错误版

    public int stone(int[] stones) {
        if (stones.length == 0) {
            return 0;
        }
        int n = stones.length;
        int[][] storage = new int[n][n];
        int[][] sum = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j + i < n; j++) {
                if (i == 0) {
                    sum[j][j + i] = stones[j];
                    storage[j][j + i] = 0;
                } else {
                    sum[j][j + i] = sum[j][j + i - 1] + stones[j + i];
                    int min = Integer.MAX_VALUE;
                    for (int k = 0; k < i; k++) {
                        min = Math.min(min, storage[j][j + k] + storage[j + 1 + k][j + i] + sum[j][j + i]);
                    }
                    storage[j][j + i] = min;
                }

            }
        }

        return storage[0][n - 1];
    }


}
