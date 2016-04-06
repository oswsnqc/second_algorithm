package com.yisenjing.second16;

import java.util.List;

/**
 * Created by Yisen on 3/23/16.
 */
public class N95Percentile {


    public int percentage(List<Integer> lengths) {


        int[] count = new int[4097];


        for (int cur : lengths) {
            count[cur]++;
        }

        int sum = 0;
        int len = count.length;
        while (sum <= 0.05 * lengths.size()) { //用0.05而不是0.95可以更加高效的找出来,因为count里面已经是长度排序好的.
            sum += count[--len];
        }
        return len;
    }



}
