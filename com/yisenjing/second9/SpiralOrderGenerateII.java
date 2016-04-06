package com.yisenjing.second9;

/**
 * Created by Yisen on 3/8/16.
 */
public class SpiralOrderGenerateII {

    public int[][] generatorII(int m, int n) {
        int[][] result = new int[m][n];
        if (m == 0 || n == 0) {
            return result;
        }
        int num = 1;
        int left = 0;
        int right = n - 1;
        int up = 0;
        int down = m - 1;
        while (left < right && up < down) {
            for (int i = left; i <= right; i++) {
                result[up][i] = num++;
            }
            for (int i = up + 1; i <= down - 1; i++) {
                result[i][right] = num++;
            }
            for (int i = right; i >= left; i--) {
                result[down][i] = num++;
            }
            for (int i = down - 1; i >= up + 1; i--) {
                result[i][left] = num++;
            }
            left++;
            right--;
            up++;
            down--;
        }

        if (left > right || up > down) {
            return result;
        }

        if (left == right) {
            for (int i = up; i <= down; i++) {
                result[i][left] = num++;
            }
        } else {
            for (int i = left; i <= right; i++) {
                result[up][i] = num++;
            }
        }
        return result;
    }
}
