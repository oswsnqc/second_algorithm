package com.yisenjing.second26;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Yisen on 3/28/16.
 */
public class MaximumValuesOfSizeKSlidingWindows {


    public List<Integer> maxWindows(int[] array, int k) {
        List<Integer> result = new ArrayList<Integer>();
        Deque<Integer> stack = new LinkedList<Integer>();

        for (int i = 0; i < array.length; i++) {
            while (!stack.isEmpty() && array[stack.peekLast()] <= array[i]) {
                stack.pollLast();
            }

            if (!stack.isEmpty() && stack.peekFirst() <= i - k) {
                stack.pollFirst();
            }
            stack.offerLast(i);

            if (i >= k - 1) {
                result.add(array[stack.peekFirst()]);
            }
        }
        return result;
    }
}
