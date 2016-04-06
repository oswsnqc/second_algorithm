package com.yisenjing.second6;

import java.util.*;

/**
 * Created by Yisen on 3/3/16.
 */
public class AllSubsetsI {

    public List<String> subseti(String set) {

        List<String> result = new ArrayList<String>();
        if (set == null) {
            return result;
        }
        recursion(set, result, 0, "");
        return result;
    }


    private String recursion(String set, List<String> result, int index, String tmp) {

        if (index >= set.length()) {
            result.add(tmp);
            return tmp;
        }
        recursion(set, result, index + 1, tmp);
        recursion(set, result, index + 1, tmp + String.valueOf(set.charAt(index)));
        return tmp;
    }
}
