package com.yisenjing.second15;

/**
 * Created by Yisen on 3/21/16.
 */
public class LargestXOf1s {

    public int largestX(int[][] matrix) {

        if (matrix.length == 0) {
            return 0;
        }
        if (matrix[0].length == 0) {
            return 0;
        }

        int[][] leftUp = new int[matrix.length][matrix[0].length];
        int[][] leftDown = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 1) {
                    if (i == 0 || j == 0) {
                        leftUp[i][j] = 1;
                    } else {
                        leftUp[i][j] = leftUp[i - 1][j - 1] + 1;
                    }
                }
            }
            for (int j = matrix[0].length - 1; j >= 0; j--) {
                if (matrix[i][j] == 1) {
                    if (i == 0 || j == matrix[0].length - 1) {
                        leftDown[i][j] = 1;
                    } else {
                        leftDown[i][j] = leftDown[i - 1][j + 1] + 1;
                    }
                }
            }
        }

        int[][] rightUp = new int[matrix.length][matrix[0].length];
        int[][] rightDown = new int[matrix.length][matrix[0].length];

        for (int i = matrix.length - 1; i >= 0; i--) {
            for (int j = matrix[0].length - 1; j >= 0; j--) {
                if (matrix[i][j] == 1) {
                    if (i == matrix.length - 1 || j == matrix[0].length - 1) {
                        rightDown[i][j] = 1;
                    } else {
                        rightDown[i][j] = rightDown[i + 1][j + 1] + 1;
                    }
                }
            }

            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 1) {
                    if (i == matrix.length - 1 || j == 0) {
                        rightUp[i][j] = 1;
                    } else {
                        rightUp[i][j] = rightUp[i + 1][j - 1] + 1;
                    }
                }
            }
        }

        int result = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int temp = Math.min(Math.min(leftUp[i][j], leftDown[i][j]), Math.min(rightUp[i][j], rightDown[i][j]));
                result = Math.max(result, temp);
            }
        }
        return result;
    }

}
