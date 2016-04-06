package com.yisenjing.second16;

import com.yisenjing.second8.ReverseString;

/**
 * Created by Yisen on 3/22/16.
 */
public class ReservoirSampling {

    private int count;
    private Integer sample;


    public ReservoirSampling() {
        this.count = 0;
        this.sample = null;
    }


    public void read(int value) {
        count++;
        int prob = (int) (Math.random() * count);
        if (prob == 0) {
            sample = value;
        }
    }

    public Integer sample() {
        return sample;
    }




}
