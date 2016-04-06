package com.yisenjing.second7;

/**
 * Created by Yisen on 3/5/16.
 */
public class RemoveSpaces {

    public String removeSpace(String input) {
        if (input.length() == 0) {
            return input;
        }
        char[] array = input.toCharArray();
        StringBuilder sb = new StringBuilder();
        int index = 0;
        while (index < array.length) {
            while (index < array.length && array[index] != ' ') {
                sb.append(array[index++]);
            }
            if (index < array.length && array[index] == ' ') {
                while (index < array.length && array[index] == ' ') {
                    index++;
                }
                if (sb.length() != 0 && index != array.length) {
                    sb.append(' ');
                }
            }
        }
        return sb.toString();
    }

}
