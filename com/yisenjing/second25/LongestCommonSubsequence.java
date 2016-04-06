package com.yisenjing.second25;

/**
 * Created by Yisen on 3/26/16.
 */
public class LongestCommonSubsequence {

    public int longest(String s, String t) {
        char[] sa = s.toCharArray();
        char[] ta = t.toCharArray();
        if (sa.length == 0 || ta.length == 0) {
            return 0;
        }
        int[][] storage = new int[sa.length][ta.length];

        for (int i = 0; i < sa.length; i++) {
            for (int j = 0; j < ta.length; j++) {

                if (i == 0 && j == 0) {
                    storage[i][j] = 0;
                } else if (i == 0) {
                    storage[i][j] = storage[i][j - 1];
                } else if (j == 0) {
                    storage[i][j] = storage[i - 1][j];
                } else {
                    storage[i][j] = Math.max(storage[i - 1][j], storage[i][j - 1]);
                }

                if (sa[i] == ta[j]) {
                    if (i - 1 >= 0 && j - 1 >= 0) {
                        storage[i][j] = storage[i - 1][j - 1] + 1;
                    } else {
                        storage[i][j] = 1;
                    }
                }
            }
        }
        return storage[sa.length - 1][ta.length - 1];
    }

}
