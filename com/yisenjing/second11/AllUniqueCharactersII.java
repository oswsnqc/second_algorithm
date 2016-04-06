package com.yisenjing.second11;

import java.util.HashSet;

/**
 * Created by Yisen on 3/19/16.
 */
public class AllUniqueCharactersII {

    public boolean helper(String word) {
        int[] vec = new int[8];
        char[] arr = word.toCharArray();
        for (char c : arr) {
            if ((vec[c / 32] >>> (c % 32) & 1) != 0) {
                return false;
            }
            vec[c / 32] |= 1 << (c % 32);
        }
        return true;
    }

}
