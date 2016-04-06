package com.yisenjing.second7;

/**
 * Created by Yisen on 3/4/16.
 */
import java.util.*;
public class CommonNumbersOfTwoSortedArrays {

    public List<Integer> sortedArray(List<Integer> A, List<Integer> B) {

        List<Integer> result = new ArrayList<Integer>();
        if (A.size() == 0 || B.size() == 0) {
            return result;
        }

        int aIndex = 0;
        int bIndex = 0;

        while (aIndex < A.size() && bIndex < B.size()) {
            if (A.get(aIndex) < B.get(bIndex)) {
                aIndex++;
            } else if (A.get(aIndex) > B.get(bIndex)) {
                bIndex++;
            } else {
                result.add(A.get(aIndex));
                aIndex++;
                bIndex++;
            }
        }
        return result;
    }


}
