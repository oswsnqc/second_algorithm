package com.yisenjing.second26;

/**
 * Created by Yisen on 3/28/16.
 */
public class MajorityNumberI {

    public int majority(int[] array) {
        int candidate = array[0];
        int count = 1;
        for (int i = 1; i < array.length; i++) {
            if (count == 0) {
                candidate = array[i];
                count++;
            } else if (array[i] == candidate) {
                count++;
            } else {
                count--;
            }
        }
        return candidate;
    }
}
