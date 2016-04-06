package com.yisenjing.second12;

import java.util.Arrays;

/**
 * Created by Yisen on 3/20/16.
 */
public class ArrayHopperI {

    public boolean hopper(int[] array) {

        if (array.length == 1) {
            return true;
        }


        boolean[] canJump = new boolean[array.length];

        for (int i = 0; i < array.length; i++) {
            for (int j = 1; j <= array[i]; j++) {
                if (i + j <= array.length - 1) {
                    canJump[i + j] = true;
                }
            }
        }
        return canJump[array.length - 1];
    }


}
