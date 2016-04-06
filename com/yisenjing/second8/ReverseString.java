package com.yisenjing.second8;

/**
 * Created by Yisen on 3/6/16.
 */
public class ReverseString {
    public String reverse(String input) {
        char[] array = input.toCharArray();
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            char temp = array[left];
            array[left++] = array[right];
            array[right--] = temp;
        }
        return new String(array);
    }
}
