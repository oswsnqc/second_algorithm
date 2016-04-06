package com.yisenjing.second24;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Yisen on 3/26/16.
 */
public class AllValidPermutationsOfParenthesesII {

    private static final char[] signal = new char[]{'(', ')', '[', ']', '{', '}'};

    public List<String> validParentheses(int l, int m, int n) {
        List<String> result = new ArrayList<String>();
        int[] remain = new int[]{l, l, m, m, n, n};
        int totalLength = (l + m + n) * 2;
        StringBuilder sb = new StringBuilder();
        Deque<Character> stack = new LinkedList<Character>();
        advancedDFS(remain, sb, totalLength, result, stack);
        return result;
    }


    private void advancedDFS(int[] remain, StringBuilder sb, int totalLength, List<String> result, Deque<Character> stack) {

        if (sb.length() == totalLength) {
            result.add(sb.toString());
            return;
        }

        for (int i = 0; i < remain.length; i++) {
            if (i % 2 == 0) {
                if (remain[i] > 0) {
                    stack.offerFirst(signal[i]);
                    sb.append(signal[i]);
                    remain[i]--;
                    advancedDFS(remain, sb, totalLength, result, stack);
                    remain[i]++;
                    sb.deleteCharAt(sb.length() - 1);
                    stack.pollFirst();
                }
            } else {
                if (!stack.isEmpty() && stack.peekFirst() == signal[i - 1]) {
                    stack.pollFirst();
                    remain[i]--;
                    sb.append(signal[i]);
                    advancedDFS(remain, sb, totalLength, result, stack);
                    sb.deleteCharAt(sb.length() - 1);
                    remain[i]++;
                    stack.offerFirst(signal[i - 1]);
                }
            }
        }
    }

}
