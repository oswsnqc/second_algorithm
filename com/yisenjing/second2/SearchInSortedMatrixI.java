package com.yisenjing.second2;

/**
 * Created by Yisen on 2/22/16.
 */
public class SearchInSortedMatrixI {

    public int[] search(int[][] matrix, int target) {
        if (matrix == null || target < matrix[0][0] || target > matrix[matrix.length - 1][matrix[0].length - 1]) {
            return new int[]{-1, -1};
        }

        int down = 0;
        int up = matrix.length - 1;

        int left = 0;
        int right = matrix[0].length;

        while (down <= up) {
            int middle = down + (up - down) / 2;
            if (matrix[middle][left] < target) {
                down = middle + 1;
            } else if (matrix[middle][left] > target) {
                up = middle - 1;
            } else {
                return new int[]{middle, left};
            }
        }

        int value = Math.min(up, down);


        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (matrix[value][middle] < target) {
                left = middle + 1;
            } else if (matrix[value][middle] > target) {
                right = middle - 1;
            } else {
                return new int[]{value, middle};
            }
        }

        return new int[]{-1, -1};
    }

}
