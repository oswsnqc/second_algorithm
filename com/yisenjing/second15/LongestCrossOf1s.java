package com.yisenjing.second15;

/**
 * Created by Yisen on 3/21/16.
 */
public class LongestCrossOf1s {

    public int longestCross(int[][] matrix) {

        if (matrix.length == 0) {
            return 0;
        }

        if (matrix[0].length == 0) {
            return 0;
        }


        int result = 0;

        int[][] up = new int[matrix.length][matrix[0].length];
        int[][] left = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 1) {
                    if (i == 0 || j == 0) {
                        left[i][j] = 1;
                        up[i][j] = 1;
                    } else {
                        left[i][j] = left[i][j - 1] + 1;
                        up[i][j] = up[i - 1][j] + 1;
                    }
                }
            }
        }


        int[][] down = new int[matrix.length][matrix[0].length];
        int[][] right = new int[matrix.length][matrix[0].length];

        for (int i = matrix.length - 1; i >= 0; i--) {
            for (int j = matrix[0].length - 1; j >= 0; j--) {
                if (matrix[i][j] == 1) {
                    if (i == matrix.length - 1 || j == matrix[0].length - 1) {
                        right[i][j] = 1;
                        down[i][j] = 1;
                    } else {
                        right[i][j] = right[i][j + 1] + 1;
                        down[i][j] = down[i + 1][j] + 1;
                    }
                }
            }
        }


        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int temp = Math.min(Math.min(left[i][j], right[i][j]), Math.min(up[i][j], down[i][j]));
                result = Math.max(result, temp);
            }
        }
        return result;
    }




}
