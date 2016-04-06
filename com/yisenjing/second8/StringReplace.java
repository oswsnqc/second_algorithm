package com.yisenjing.second8;

/**
 * Created by Yisen on 3/5/16.
 */
public class StringReplace {
    public String replace(String input, String s, String t) {
        if (input == null) {
            return input;
        }
        char[] array = input.toCharArray();
        char[] sAry = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < array.length) {
            int length = 0;
            if (array[i] == sAry[0]) {
                for (int j = 0; j < sAry.length; j++) {
                    if (i + j < array.length && array[i + j] == sAry[j]) {
                        length++;
                    }
                }
                if (length == sAry.length) {
                    sb.append(t);
                    i = i + length;
                } else {
                    sb.append(array[i++]);
                }
            } else {
                sb.append(array[i++]);
            }
        }
        return sb.toString();
    }



}
