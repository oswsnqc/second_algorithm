package com.yisenjing.second9;

/**
 * Created by Yisen on 3/7/16.
 */
import java.util.*;
public class SpiralOrderTraverseI {

    public List<Integer> spiral(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int start = 0;
        int end = matrix.length - 1;
        while (start < end) {
            for (int i = start; i <= end; i++) {
                result.add(matrix[start][i]);
            }

            for (int i = start + 1; i <= end - 1; i++) {
                result.add(matrix[i][end]);
            }

            for (int i = end; i >= start; i--) {
                result.add(matrix[end][i]);
            }

            for (int i = end - 1; i >= start + 1; i--) {
                result.add(matrix[i][start]);
            }
            end--;
            start++;
        }
        if (end == start) {
            result.add(matrix[start][end]);
        }
        return result;
    }


}
