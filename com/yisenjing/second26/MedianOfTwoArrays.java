package com.yisenjing.second26;

import java.util.Arrays;

/**
 * Created by Yisen on 3/28/16.
 */
public class MedianOfTwoArrays {

    public double median(int[] a, int[] b) {

        Arrays.sort(a);
        Arrays.sort(b);

        int total = a.length + b.length;

        if (total % 2 == 0) {
            return (double)(helper(a, 0, b, 0, total / 2) + helper(a, 0, b, 0, total / 2 + 1)) / 2;
        } else {
            return (double)(helper(a, 0, b, 0, total / 2 + 1));
        }

    }


    private int helper(int[] a, int aleft, int[] b, int bleft, int k) {

        if (aleft >= a.length) {
            return b[bleft + k - 1];
        }

        if (bleft >= b.length) {
            return a[aleft + k - 1];
        }

        if (k == 1) {
            return Math.min(a[aleft], b[bleft]);
        }

        int amid = aleft + k / 2 - 1;
        int bmid = bleft + k / 2 - 1;
        int aval = aleft >= a.length ? Integer.MAX_VALUE : a[amid];
        int bval = bleft >= b.length ? Integer.MAX_VALUE : b[bmid];

        if (aval <= bval) {
            return helper(a, amid + 1, b, bleft, k - k / 2);
        } else {
            return helper(a, aleft, b, bmid + 1, k - k / 2);
        }
    }

}
