package com.yisenjing.second18;

/**
 * Created by Yisen on 3/23/16.
 */
public class RotateMatrix {

    public void rotate(int[][] matrix) {

        if (matrix == null || matrix.length <= 1) {
            return;
        }
        roY(matrix);
        roYX(matrix);
    }

    private void roYX(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j + i < matrix.length - 1; j++) { //每行减1,同时不碰到对角线
                swap(matrix, i, j, matrix.length - 1 - j, matrix.length - 1 - i);
            }
        }
    }


    private void roY(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length / 2; j++) {
                swap(matrix, i, j, i, matrix.length - j - 1);
            }
        }
    }

    private void swap(int[][] matrix, int a1, int a2, int b1, int b2) {
        int temp = matrix[a1][a2];
        matrix[a1][a2] = matrix[b1][b2];
        matrix[b1][b2] = temp;
    }


}
