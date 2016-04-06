package com.yisenjing.second7;

import java.util.HashSet;

/**
 * Created by Yisen on 3/5/16.
 */
public class RemoveCertainCharacters {

    public String removeChar(String input, String t) {

        if (input.length() == 0) {
            return input;
        }
        char[] arrayI = input.toCharArray();
        char[] arrayT = t.toCharArray();
        HashSet<Character> storage = new HashSet<>();

        for (int i = 0; i < arrayT.length; i++) {
            storage.add(arrayT[i]);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arrayI.length; i++) {
            if (!storage.contains(arrayI[i])) {

                sb.append(arrayI[i]);
            }
        }
        System.out.println(sb);
        return sb.toString();
    }

}
