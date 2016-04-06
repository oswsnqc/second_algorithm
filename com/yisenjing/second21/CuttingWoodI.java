package com.yisenjing.second21;

import java.util.Arrays;

/**
 * Created by Yisen on 3/25/16.
 */
public class CuttingWoodI {

    public int cutting(int[] cut, int length) {
        int newLen = cut.length + 2;
        int[][] memory = new int[newLen][newLen];
        int[] len = new int[newLen];
        len[0] = 0;
        len[newLen - 1] = length;

        for (int i = 0; i < newLen; i++) {
            for (int j = 0; j < newLen - i; j++) {
                if (i == 0) {
                    if (j < newLen - 1 && j > 0) {
                        len[j] = cut[j - 1];
                    }
                } else if (i >= 2) {
                    memory[j][j + i] = Integer.MAX_VALUE;
                    for (int k = 1; k < i; k++) {
                        memory[j][j + i] = Math.min(memory[j][j + i], memory[j][j + k] + memory[j + k][j + i] + len[i + j] - len[j]);
                    }
                }
            }
        }
        return memory[0][newLen - 1];
    }

}
