package com.yisenjing.second18;

import java.util.Arrays;

/**
 * Created by Yisen on 3/23/16.
 */
public class ArrayDeduplicationIV {

    public int[] dedup(int[] array) {

        if (array == null || array.length <= 1) {
            return array;
        }

        int end = -1;

        for (int i = 0; i < array.length; i++) {
            if (end == -1 || array[end] != array[i]) {
              array[++end] = array[i]; // 此为
            } else {
                while (i + 1 < array.length && array[i + 1] == array[end]) {//保留i还为正常数值,此时i + 1 为预测数值
                    i++; //i不一定限制于外界for loop,可以内部改数值, 此为跳过重复的
                }
                end--; //从里到外扩散,很聪明,没必要将end归0,此为退回上一层,发现新的重复的
            }
        }
        return Arrays.copyOf(array, end + 1);
    }

}
