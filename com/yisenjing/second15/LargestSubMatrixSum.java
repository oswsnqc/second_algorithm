package com.yisenjing.second15;

/**
 * Created by Yisen on 3/21/16.
 */
public class LargestSubMatrixSum {

    public int subMatrixSum(int[][] matrix) {

        if (matrix.length == 0) {
            return 0;
        }

        if (matrix[0].length == 0) {
            return 0;
        }

        int result = Integer.MIN_VALUE;

        for (int i = 0; i < matrix.length; i++) {
            int[] sumArea = new int[matrix[0].length];
            for (int j = i; j < matrix.length; j++) {

                for (int a = 0; a < sumArea.length; a++) {
                    sumArea[a] += matrix[j][a];
                }

                int temp = sumArea[0];
                int sum = sumArea[0];
                for (int s = 1; s < sumArea.length; s++) {
                    temp = Math.max(temp + sumArea[s], sumArea[s]);
                    sum = Math.max(sum, temp);
                }
                result = Math.max(result, sum);
            }

        }

        return result;
    }
}
