package com.yisenjing.second15;

/**
 * Created by Yisen on 3/21/16.
 */
public class LongestConsecutive1s {

    public int consecutive(int[] array) {

        if (array.length == 0) {
            return 0;
        }
        int cur = 0;
        int longest = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 1) {
                cur++;
            } else {
                cur = 0;
            }
            longest = Math.max(longest, cur);
        }
        return longest;
    }


}
