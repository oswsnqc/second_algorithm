package com.yisenjing.second8;

/**
 * Created by Yisen on 3/6/16.
 */
import java.util.*;
public class LongestSubstringWithoutRepeatingCharacters {

    public int repeat(String input) {
        HashSet<Character> set = new HashSet<>();
        char[] array = input.toCharArray();
        int fast = 0;
        int slow = 0;
        int length = 0;
        while (fast < array.length) {
            if (set.contains(array[fast])) {
                set.remove(array[slow++]);
            } else {
                set.add(array[fast++]);
                length = Math.max(length, fast - slow);
            }
        }
        return length;
    }

}
