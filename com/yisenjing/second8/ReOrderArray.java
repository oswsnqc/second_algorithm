package com.yisenjing.second8;

/**
 * Created by Yisen on 3/6/16.
 */
public class ReOrderArray {

    public int[] reorder(int[] array) {
        if (array.length % 2 == 0) {
            reorder(array, 0, array.length - 1);
        } else {
            reorder(array, 0, array.length - 2);
        }
        return array;
    }

    private void reorder(int[] array, int left, int right) {
        int length = right - left + 1;
        if (length <= 2) {
            return;
        }
        int mid = left + length / 2;
        int lmid = left + length / 4;
        int rmid = left + 3 * length / 4;
        reverse(array, lmid, mid - 1);
        reverse(array, mid, rmid - 1);
        reverse(array, lmid, rmid - 1);
        reorder(array, left, left + (lmid - left) * 2 - 1);
        reorder(array, left + (lmid - left) * 2, right);
    }

    private void reverse(int[] array, int left, int right) {
        while (left < right) {
            int temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            left++;
            right--;
        }
    }
}
