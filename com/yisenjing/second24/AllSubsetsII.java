package com.yisenjing.second24;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Yisen on 3/26/16.
 */
public class AllSubsetsII {

    public List<String> subSets(String set) {
        List<String> result = new ArrayList<String>();
        if (set == null) {
            return result;
        }

        char[] setChar = set.toCharArray();
        Arrays.sort(setChar);
        DFS(result, 0, setChar, "");
        return result;
    }


    private String DFS(List<String> result, int index, char[] setChar, String builder) {

        if (index == setChar.length) {
            if (!result.contains(builder)) {
                result.add(builder);
            }
            return builder;
        }
        DFS(result, index + 1, setChar, builder);
        DFS(result, index + 1, setChar, builder + setChar[index]);
        return builder;
    }


}
