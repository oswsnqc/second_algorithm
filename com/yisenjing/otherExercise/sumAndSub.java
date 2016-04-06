package com.yisenjing.otherExercise;
import java.util.*;
/**
 * Created by Yisen on 2/27/16.
 */
public class sumAndSub {
    public List<Integer> helper(int[] array, int sumTarget, int subTarget) {
        if (array == null) {
            return new ArrayList<>();  //没找到就返回这个
        }
        List<Integer> result = new ArrayList<Integer>();
        HashSet<Integer> sumTmp = new HashSet<Integer>();
        for (int i = 0; i < array.length; i++) {
            if (sumTmp.contains(array[i])) {
                if (Math.abs(sumTarget - array[i] - array[i]) == Math.abs(subTarget)) {
                    result.add(sumTarget - array[i]);
                    result.add(array[i]);
                    break;
                }
            } else {
                sumTmp.add(sumTarget - array[i]);
            }
        }
        return result; //time complecity: O(n)
    }
}
