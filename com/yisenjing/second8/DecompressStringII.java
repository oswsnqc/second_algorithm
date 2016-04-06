package com.yisenjing.second8;

/**
 * Created by Yisen on 3/5/16.
 */
public class DecompressStringII {

    public String decompress(String input) {
        if (input == null || input.length() == 0) {
            return input;
        }
        char[] array = input.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            if (i % 2 == 1) {
                for (int j = 0; j < Character.getNumericValue(array[i]); j++) {
                    sb.append(array[i - 1]);
                }
            }
        }
        return sb.toString();
    }

}
