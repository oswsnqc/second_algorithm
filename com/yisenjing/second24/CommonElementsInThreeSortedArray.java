package com.yisenjing.second24;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yisen on 3/26/16.
 */
public class CommonElementsInThreeSortedArray {

    public List<Integer> common(int[] a, int[] b, int[] c) {
        List<Integer> result = new ArrayList<Integer>();
        int aIndex = 0;
        int bIndex = 0;
        int cIndex = 0;
        while (aIndex < a.length && bIndex < b.length && cIndex < c.length) {

            if (a[aIndex] == b[bIndex] && b[bIndex] == c[cIndex]) {
                result.add(a[aIndex]);
                aIndex++;
                bIndex++;
                cIndex++;
            } else {
                if (a[aIndex] <= b[bIndex] && a[aIndex] <= c[cIndex]) {
                    aIndex++;
                } else if (b[bIndex] <= c[cIndex] && b[bIndex] <= a[aIndex]) {
                    bIndex++;
                } else if (c[cIndex] <= a[aIndex] && c[cIndex] <= b[bIndex]) {
                    cIndex++;
                }
            }
        }
        return result;
    }
}
