package com.yisenjing.second21;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by Yisen on 3/25/16.
 */
public class MergeKSortedArray {


    public int[] arrays(int[][] arrayOfArrays) {

        if (arrayOfArrays.length == 0) {
            return new int[]{};
        }



        PriorityQueue<int[]> selecter = new PriorityQueue<>(1, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[2] == o2[2]) {
                    return 0;
                }
                return o1[2] < o2[2] ? -1 : 1;
            }
        });

        int length = 0;

        for (int i = 0; i < arrayOfArrays.length; i++) {
            length += arrayOfArrays[i].length;
            if (arrayOfArrays[i].length != 0) {
                selecter.offer(new int[]{i, 0, arrayOfArrays[i][0]});
            }
        }

        int[] result = new int[length];

        int index = 0;

        while (!selecter.isEmpty()) {
            int[] temp = selecter.poll();
            result[index++] = temp[2];
            if (temp[1] + 1 < arrayOfArrays[temp[0]].length) {
                selecter.offer(new int[]{temp[0], temp[1] + 1, arrayOfArrays[temp[0]][temp[1] + 1]});
            }
        }
        return result;
    }


}
