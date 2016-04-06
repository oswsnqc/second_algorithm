package com.yisenjing.second13;

import java.util.Arrays;

/**
 * Created by Yisen on 3/20/16.
 */
public class EditDistance {

    public int distance(String one, String two) {

        if (one.length() == 0) {
            return two.length();
        }

        if (two.length() == 0) {
            return one.length();
        }


        int[][] storage = new int[one.length()][two.length()];

        for (int i = 0; i < one.length(); i++) { //纵坐标

            for (int j = 0; j < two.length(); j++) { //横坐标
                if (i == 0 && j == 0) {
                    if (one.charAt(i) == two.charAt(j)) {
                        storage[i][j] = 0;
                    } else {

                        storage[i][j] = 1;
                    }
                } else if (i == 0) {
                    if (one.charAt(i) == two.charAt(j)) {
                        storage[i][j] = storage[i][j - 1];
                    } else {
                        storage[i][j] = storage[i][j - 1] + 1;
                    }
                } else if (j == 0) {
                    if (one.charAt(i) == two.charAt(j)) {
                        storage[i][j] = storage[i - 1][j];
                    } else {
                        storage[i][j] = storage[i - 1][j] + 1;
                    }
                } else {
                    if (one.charAt(i) == two.charAt(j)) {
                        storage[i][j] = Math.min(Math.min(storage[i - 1][j], storage[i - 1][j]), storage[i - 1][j - 1]);
                    } else {
                        storage[i][j] = Math.min(Math.min(storage[i - 1][j], storage[i - 1][j]), storage[i - 1][j - 1]) + 1;
                    }
                }
            }
        }

        for (int i = 0; i < storage.length; i++) {
            System.out.println(Arrays.toString(storage[i]));
        }

        return storage[one.length() - 1][two.length() - 1];
    }


}
