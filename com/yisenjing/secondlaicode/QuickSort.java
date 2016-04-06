package com.yisenjing.secondlaicode;

/**
 * Created by Yisen on 2/20/16.
 */
public class QuickSort {

    public int[] quickSort(int[] array) {

        if (array == null) {
            return array;
        }

        quickSort(array, 0, array.length - 1);
        return array;
    }

    private void quickSort(int[] array, int left, int right) {

        if (left >= right) {
            return;
        }

        int pivote = partition(array, left, right);
        quickSort(array, left, pivote - 1);
        quickSort(array, pivote + 1, right);
    }

    private int partition(int[] array, int left, int right) {

        int pivotIndex = pivotGenerator(left, right);
        int povot = array[pivotIndex];

        swap(array, pivotIndex, right);

        int leftBound = left;
        int rightBound = right - 1;

        while (leftBound <= rightBound) {
            if (array[leftBound] <= povot) {
                leftBound++;
            } else if (array[rightBound] >= povot) {
                rightBound--;
            } else {
                swap(array, leftBound++, rightBound--);
            }
        }

        swap(array, leftBound, right);
        return leftBound;
    }


    private int pivotGenerator(int left, int right) {
        return left + (int)(Math.random() * (right - left + 1));
    }

    private void swap(int[] array, int left, int right) {
        int tmp = array[left];
        array[left] = array[right];
        array[right] = tmp;
    }

}
