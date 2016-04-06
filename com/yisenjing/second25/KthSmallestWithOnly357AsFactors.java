package com.yisenjing.second25;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by Yisen on 3/27/16.
 */
public class KthSmallestWithOnly357AsFactors {

    public long kth(int k) {

        long seed = 3 * 5 * 7L;

        Deque<Long> de3 = new LinkedList<Long>();
        Deque<Long> de5 = new LinkedList<Long>();
        Deque<Long> de7 = new LinkedList<Long>();

        de3.add(seed * 3);
        de5.add(seed * 5);
        de7.add(seed * 7);
        long result = seed;

        while (k > 1) {
            if (de3.peekFirst() < de5.peekFirst() && de3.peekFirst() < de7.peekFirst()) {
                result = de3.pollFirst();
                de3.offerLast(result * 3);
                de5.offerLast(result * 5);
                de7.offerLast(result * 7);
            } else if (de5.peekFirst() < de3.peekFirst() && de5.peekFirst() < de7.peekFirst()) {
                result = de5.pollFirst();
                de5.offerLast(result * 5);
                de7.offerLast(result * 7);
            } else {            //此处可用的原因是理论上不会有重复元素
                result = de7.pollFirst();
                de7.offerLast(result * 7);
            }
            k--;
        }

        return result;
    }
}
