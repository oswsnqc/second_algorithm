package com.yisenjing.second18;

import java.util.Arrays;

/**
 * Created by Yisen on 3/23/16.
 */
public class ArrayDeduplicationIII {

    public int[] dedup(int[] array) {
        if (array.length <= 1) {
            return array;
        }
        int end = 0;

        boolean flag = false;

        for (int i = 1; i < array.length; i++) {
            if (array[i] == array[end]) { //什么都不做,用来跳过中间不需要的重复数组
                flag = true;
            } else if (flag) {      // 第一条不符合,但是第二条符合,也就是说虽然不等,但是目的是为了消除刚才凡是重复的
                array[end] = array[i];
                flag = false;
            } else {                // 消除以后全新的开始
                array[++end] = array[i];
            }
        }
        return Arrays.copyOf(array, flag ? end : end + 1);
    }
}
