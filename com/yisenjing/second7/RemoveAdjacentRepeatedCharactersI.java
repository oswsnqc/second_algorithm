package com.yisenjing.second7;

/**
 * Created by Yisen on 3/4/16.
 */
public class RemoveAdjacentRepeatedCharactersI {

    public String adjacent(String input) {
        input = input + " ";
        char[] array = input.toCharArray();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < array.length; i++) {
            if (i + 1 < array.length) {
                char temp = array[i + 1];
                if (temp != array[i]) {
                    sb.append(array[i]);
                }
            }
        }
        return sb.toString();
    }
}
