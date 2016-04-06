package com.yisenjing.second25;

/**
 * Created by Yisen on 3/26/16.
 */
public class LongestCommonSubstring {

    public String longestCommon(String s, String t) {

        char[] sa = s.toCharArray();
        char[] ta = t.toCharArray();

        int[][] storage = new int[sa.length][ta.length];

        int start = 0;
        int longest = 0;
        for (int i = 0; i < sa.length; i++) {
            for (int j = 0; j < ta.length; j++) {
                if (sa[i] == ta[j]) {
                    if (i != 0 && j != 0) {
                        storage[i][j] = storage[i - 1][j - 1] + 1;
                    } else {
                        storage[i][j] = 1;
                    }
                    if (storage[i][j] > longest) {
                        longest = storage[i][j];
                        start = i - longest + 1;
                    }
                }
            }
        }
        return s.substring(start, start + longest);
    }
}
