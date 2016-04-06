package com.yisenjing.second9;

/**
 * Created by Yisen on 3/8/16.
 */
public class StringAbbreviationMatching {

    public boolean match(String input, String pattern) {
        int si = 0;
        int pi = 0;
        while (si < input.length() && pi < pattern.length()) {
            if (pattern.charAt(pi) < '0' || pattern.charAt(pi) > '9') {
                if (pattern.charAt(pi) != input.charAt(si)) {
                    return false;
                }
                si++;
                pi++;
            } else {
                int count = 0;
                while (pi < pattern.length() && pattern.charAt(pi) < '9' && pattern.charAt(pi) > '0') {
                    count = count * 10 + pattern.charAt(pi) - '0';
                    pi++;
                }
                si += count;
            }
        }
        return si == input.length() && pi == pattern.length();
    }

}
