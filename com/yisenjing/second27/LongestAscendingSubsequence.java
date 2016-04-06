package com.yisenjing.second27;

import java.util.Arrays;

/**
 * Created by Yisen on 3/29/16.
 */
public class LongestAscendingSubsequence {

    public int longest(int[] array) {
        int N = array.length;
        if (N == 0) {
            return 0;
        }
        int[][] storage = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j + i < N; j++) {
                if (i == 0) {
                    storage[j][j + i] = 1;
                } else {
                    if (storage[j + 1][j + i] == storage[j][j + i - 1]) {
                        storage[j][j + i] = storage[j][j + i - 1];
                        if (array[i] > array[i - 1]) {
                            storage[j][j + i]++;
                        }
                    } else {
                        storage[j][j + i] = Math.max(storage[j + 1][j + i], storage[j][j + i - 1]);
                    }
                }
            }
        }
        return storage[0][N - 1];
    }

}
