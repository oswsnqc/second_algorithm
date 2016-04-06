package com.yisenjing.second5;

/**
 * Created by Yisen on 3/1/16.
 */
import java.util.*;
public class KSmallestInUnsortedArray {

    public int[] ksmallest(int[] array, int k) {

        if (array.length == 0 || k == 0) {
            return new int[0];
        }

        PriorityQueue<Integer> pQueue  = new PriorityQueue<Integer>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1 == o2) {
                    return 0;
                }
                return o1 > o2 ? -1 : 1;
            }
        });


        for (int i = 0; i < array.length; i++) {
            if (i < k) {
                pQueue.add(array[i]);
            } else {
                if (array[i] < pQueue.peek()) {
                    pQueue.poll();
                    pQueue.add(array[i]);
                }

            }
        }

        int[] result = new int[k];

        for (int i = k - 1; i >= 0; i--) {
            result[i] = pQueue.poll();
        }
        return result;
    }


}
