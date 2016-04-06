package com.yisenjing.second2;

/**
 * Created by Yisen on 2/22/16.
 */
public class SearchInUnknownSizedSortedArray {

    public int unknownLength(Dictionary dict, int target) {

        if (dict == null) {
            return -1;
        }

        int left = 0;
        int right = 1;


        while (dict.get(right) != null && dict.get(right) < target) {
            left = right;
            right = right * 2;
        }


        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (dict.get(middle) == null || dict.get(middle) > target) {
                right = middle - 1;
            } else if (dict.get(middle) < target){
                left = middle + 1;
            } else if (dict.get(middle) == target){
                return middle;
            }
        }


        return -1;
    }




}
