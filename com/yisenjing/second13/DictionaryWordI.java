package com.yisenjing.second13;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Yisen on 3/20/16.
 */
public class DictionaryWordI {

    public boolean determine(String input, String[] dict) {
        Set<String> dictSet = toSet(dict);
        boolean[] canBreak = new boolean[input.length() + 1];
        canBreak[0] = true;
        for (int i = 1; i < canBreak.length; i++) {
            for (int j = 0; j < i; j++) {
                if (dictSet.contains(input.substring(j, i)) && canBreak[j]) {
                    canBreak[i] = true;
                    break;
                }
            }
        }
        return canBreak[canBreak.length - 1];
    }


    private Set<String> toSet(String[] dict) {
        Set<String> result = new HashSet<>();
        for (String s : dict) {
            result.add(s);
        }
        return result;
    }


}
