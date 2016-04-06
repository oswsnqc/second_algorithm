package com.yisenjing.second16;

import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Created by Yisen on 3/23/16.
 */
public class MedianTracker {


    private PriorityQueue<Integer> min;
    private PriorityQueue<Integer> max;

    public MedianTracker() {
        this.min = new PriorityQueue<>(1, Collections.reverseOrder());
        this.max = new PriorityQueue<>();
    }


    public void read(int value) {

        if (min.isEmpty() || value < min.peek()){
            min.offer(value);
        } else {
            max.offer(value);
        }


        if (min.size() - max.size() >= 2) {
            max.offer(min.poll());
        } else if (max.size() > min.size()) {
            min.offer(max.poll());
        }
    }


    public Double median() {

        int size = size();
        if (size == 0) {
            return null;
        } else if (size % 2 == 0) {
            return (min.peek() + max.peek()) / 2.0;
        } else {
            return (double) (min.peek());
        }
    }

    private int size() {
        return min.size() + max.size();
    }



}
