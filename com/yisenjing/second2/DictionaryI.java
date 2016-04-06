package com.yisenjing.second2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yisen on 2/22/16.
 */
public class DictionaryI implements Dictionary {
    public Integer get(int index) {
        int[] array = new int[]{1, 2, 3, 4, 5, 7, 8, 9, 10};
        if (index < array.length && index >= 0) {
            return array[index];
        } else {
            return null;
        }
    }
}
