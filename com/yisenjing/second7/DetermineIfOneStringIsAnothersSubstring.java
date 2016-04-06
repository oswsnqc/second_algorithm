package com.yisenjing.second7;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Yisen on 3/5/16.
 */
public class DetermineIfOneStringIsAnothersSubstring {

    public int determineSubString(String large, String small) {

        if (large.length() < small.length()) {
            return -1;
        }
        if (small.length() == 0) {
            return 0;
        }

        char[] arrayL = large.toCharArray();
        char[] arrayS = small.toCharArray();

        Queue<Integer> stack = new LinkedList<Integer>();

        for (int i = 0; i <= (arrayL.length - arrayS.length); i++) {
            if (arrayL[i] == arrayS[0]) {
                stack.offer(i);
            }
        }

        while (!stack.isEmpty()) {
            int sameLength = 0;
            int index = stack.poll();
            int result = index;
            for (int i = 0; i < arrayS.length; i++) {
                if (arrayL[index++] == arrayS[i]) {
                    sameLength++;
                }
            }
            if (sameLength == arrayS.length) {
                return result;
            }
        }
        return -1;
    }

}
