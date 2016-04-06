package com.yisenjing.second3;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by Yisen on 2/23/16.
 */
public class StackWithmin {

    private Deque<Integer> stack;
    private Deque<Integer> minstack;

    public StackWithmin() {
        stack = new LinkedList<Integer>();
        minstack = new LinkedList<Integer>();
    }

    public int top() {
        if (stack.isEmpty()) {
            return -1;
        }
        return stack.peekFirst();
    }

    public int min() {
        if (minstack.isEmpty()) {
            return -1;
        }
        return minstack.peekFirst();
    }

    public void push(int value) {
        stack.offerFirst(value);
        if (minstack.isEmpty() || value <= minstack.peekFirst()) {
            minstack.offerFirst(value);
        }
    }

    public int pop() {
        if (stack.isEmpty()) {
            return -1;
        }
        Integer result = stack.pollFirst();

        if (minstack.peekFirst().equals(result)) {
            minstack.pollFirst();
        }
        return result;
    }

}
