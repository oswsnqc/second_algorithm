package com.yisenjing.second20;

import java.util.Arrays;

/**
 * Created by Yisen on 3/23/16.
 */
public class MinimumCutsForPalindromes {

    public int minCuts(String input) {

        if (input.length() <= 1) {
            return 0;
        }
        int n = input.length();
        int[][] storage = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; i + j < n; j++) {

                if (i == 0) {
                    storage[j][j + i] = 0;
                } else if (i == 1) {
                    if (input.charAt(j) == input.charAt(i + j)) {
                        storage[j][j + i] = 0;
                    } else {
                        storage[j][j + i] = 1;
                    }
                } else {
                    if (input.charAt(j) == input.charAt(i + j) && storage[j + 1][j + i - 1] == 0) {
                        storage[j][j + i] = 0;
                    } else {
                        int min = Integer.MAX_VALUE;
                        for (int p = 0; p < i; p++) {
                            min = Math.min(min, storage[j][j + p] + storage[j + 1 + p][j + i] + 1);
                        }
                        storage[j][j + i] = min;
                    }
                }
            }
        }

        return storage[0][n - 1];
    }


}
