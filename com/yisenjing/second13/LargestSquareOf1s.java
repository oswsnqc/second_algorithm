package com.yisenjing.second13;

/**
 * Created by Yisen on 3/21/16.
 */
public class LargestSquareOf1s {


    public int largest(int[][] matrix) {

        int[][] storage = new int[matrix.length][matrix.length];

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < storage.length; i++) {
            for (int j = 0; j < storage.length; j++) {
                if (matrix[i][j] == 0) {
                    storage[i][j] = 0;
                } else {
                    if (i == 0 || j == 0) {
                        storage[i][j] = 1;
                    } else {
                        storage[i][j] = Math.min(storage[i - 1][j - 1], Math.min(storage[i - 1][j], storage[i][j - 1])) + 1;
                    }
                }
                max = Math.max(max, storage[i][j]);
            }
        }
        return max;
    }

}
