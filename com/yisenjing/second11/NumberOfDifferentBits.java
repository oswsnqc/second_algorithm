package com.yisenjing.second11;

/**
 * Created by Yisen on 3/19/16.
 */
public class NumberOfDifferentBits {

    public int diffbits(int a, int b) {
        a = a ^ b;
        int count = 0;
        while (a != 0) {
            count += a & 1;
            a >>>= 1;
        }
        return count;
    }


}
