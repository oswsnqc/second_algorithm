package com.yisenjing.second12;

/**
 * Created by Yisen on 3/20/16.
 */
public class MaxProductOfCuttingRope {

    public int maxProduct(int length) {

        if (length == 2) {
            return 1;
        }

        int[] array = new int[length + 1];
        array[1] = 0;
        array[2] = 1;
        for (int i = 3; i < array.length; i++) {
            for (int j = 1; j <= i / 2; j++) {
                array[i] = Math.max(array[i], j * Math.max(i - j, array[i - j]));
            }
        }
        return array[length];
    }

}
