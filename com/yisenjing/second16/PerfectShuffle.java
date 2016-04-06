package com.yisenjing.second16;

/**
 * Created by Yisen on 3/22/16.
 */
public class PerfectShuffle {

    public void shuffle(int[] array) {
        if (array.length <= 1) {
            return;
        }

        for (int i = array.length; i >= 1; i--) { //此处不减去1是为了保证后面随机数恰好落在数组范围内
            int inx = (int)(Math.random() * i);
            swap(array, i - 1, inx); //此处是为了弥补刚才不减1
        }
    }

    private void swap(int[] array, int inx, int i) {
        int temp = array[i];
        array[i] = array[inx];
        array[inx] = temp;
    }
}
