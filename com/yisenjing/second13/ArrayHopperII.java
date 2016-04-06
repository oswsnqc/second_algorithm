package com.yisenjing.second13;

/**
 * Created by Yisen on 3/20/16.
 */
public class ArrayHopperII {

    public int hopper(int[] array) {

        int length = array.length;

        int[] minJump = new int[length];

        minJump[0] = 0;

        for (int i = 1; i < length; i++) {
            minJump[i] = -1;
            for (int j = i - 1; j >= 0; j--) {
                if (j + array[j] >= i && minJump[j] != -1) {// 本身j能被前面的index reach到,同时此个位置也能reach到i
                    if (minJump[i] == -1 || minJump[i] > minJump[j] + 1) { //如果i还没有被定义,或者现在的移动步数比先前的更小的话
                        minJump[i] = minJump[j] + 1; //和cut rope一样,从后往前遍历,4
                    }
                }
            }
        }
        return minJump[length - 1];

    }

}
