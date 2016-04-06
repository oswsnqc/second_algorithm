package com.yisenjing.second11;

/**
 * Created by Yisen on 3/8/16.
 */
public class PowerOfTwo {

    public boolean bit(int number) {

        if (number <= 0) {
            return false;
        }


        while ((number & 1) == 0) {
            number >>>= 1;
        }
        return number == 1;
    }

}
