package com.yisenjing.second8;

/**
 * Created by Yisen on 3/6/16.
 */
import java.security.PrivateKey;
import java.util.*;
public class AllAnagrams {
    public List<Integer> anagrams(String s, String l) {
        List<Integer> result = new ArrayList<>();
        Map<Character, Integer> map = count(s);
        int match = 0;

        for (int i = 0; i < l.length(); i++) {
            char tmp = l.charAt(i);
            Integer counter = map.get(tmp);
            if (counter != null) {
                map.put(tmp, counter - 1);
                if (counter == 1) {
                    match++;
                }
            }
            if (i >= s.length()) {
                tmp = l.charAt(i - s.length());
                counter = map.get(tmp);
                if (counter != null) {
                    map.put(tmp, counter + 1);
                    if (counter == 0) {
                        match--;
                    }
                }
            }
            if (match == map.size()) {
                result.add(i - s.length() + 1);
            }
        }
        return result;
    }

    private Map<Character, Integer> count(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (char c : s.toCharArray()){
            Integer count = map.get(c);
            if (count == null) {
                map.put(c, 1);
            } else {
                map.put(c, count + 1);
            }
        }
        return map;
    }

}
