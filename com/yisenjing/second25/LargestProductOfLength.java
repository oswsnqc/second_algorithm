package com.yisenjing.second25;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Yisen on 3/27/16.
 */
public class LargestProductOfLength {

    public int largestProduct(String[] dict) {
        Map<String, Integer> determine = getMask(dict);
        int largest = 0;
        for (int i = 1; i < dict.length; i++) {
            for (int j = 0; j < i; j++) {
                int curPro = dict[i].length() * dict[j].length();
                int x = determine.get(dict[i]);
                int y = determine.get(dict[j]);
                if ((x & y) == 0) {
                    largest = curPro > largest ? curPro : largest;
                }
            }
        }
        return largest;
    }


    private Map<String, Integer> getMask(String[] dict) {
        Map<String, Integer> result = new HashMap<String, Integer>();
        for (int i = 0; i < dict.length; i++) {
            int bitMask = 0;
            char[] theWords = dict[i].toCharArray();
            for (int j = 0; j < theWords.length; j++) {
                bitMask = bitMask | 1 << (theWords[j] - 'a');
            }
            result.put(dict[i], bitMask);
        }
        return result;
    }

}
