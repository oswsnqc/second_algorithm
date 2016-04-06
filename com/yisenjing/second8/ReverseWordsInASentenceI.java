package com.yisenjing.second8;

/**
 * Created by Yisen on 3/5/16.
 */
import java.util.*;
public class ReverseWordsInASentenceI {

    public String reverseWords(String input) {
        if (input == null) {
            return input;
        }
        char[] array = input.toCharArray();
        StringBuilder sb = new StringBuilder();
        Deque<String> r = new LinkedList<>();
        for (int i = 0; i < array.length; i++) {
            if (array[i] != ' '){
                sb.append(array[i]);
            }
            if ((array[i] == ' ' && sb.length() != 0) || i == array.length - 1) {
                r.offerFirst(sb.toString());
                sb = new StringBuilder();
            }
        }
        sb = new StringBuilder();
        while (!r.isEmpty()) {
            sb.append(r.pollFirst());
            if (!r.isEmpty()) {
                sb.append(' ');
            }
        }
        return sb.toString();
    }
}
