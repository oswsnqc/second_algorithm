package com.yisenjing.second26;

import java.util.Arrays;

/**
 * Created by Yisen on 3/28/16.
 */
public class InterleaveStrings {


    public boolean canMerge(String a, String b, String c) {

        int alen = a.length();
        int blen = b.length();
        int clen = c.length();

        if (alen + blen != clen) {
            return false;
        }

        boolean[][] storage = new boolean[alen + 1][blen + 1];

        for (int i = 0; i <= alen; i++) {
            for (int j = 0; j <= blen; j++) {
                if (i == 0 && j == 0) {
                    storage[i][j] = true;
                }
                if (i > 0 && a.charAt(i - 1) == c.charAt(i + j - 1)) {
                    storage[i][j] |= storage[i - 1][j];
                }

                if (j > 0 && b.charAt(j - 1) == c.charAt(i + j - 1)) {
                    storage[i][j] |= storage[i][j - 1];
                }
            }
        }
        return storage[alen][blen];
    }
}
