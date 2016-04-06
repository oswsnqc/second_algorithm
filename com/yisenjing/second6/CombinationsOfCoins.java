package com.yisenjing.second6;

import java.util.*;
/**
 * Created by Yisen on 3/4/16.
 */
public class CombinationsOfCoins {

    public List<List<Integer>> coins(int target, int[] coins) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> cur = new ArrayList<Integer>();
        coinHelper(cur, result, 0, target, coins);
        return result;
    }


    private void coinHelper(List<Integer> cur, List<List<Integer>> result, int index, int target, int[] coins) {

        if (index == coins.length - 1) {
            if (target % coins[coins.length - 1] == 0) {
                cur.add(target / coins[coins.length - 1]);
                result.add(new ArrayList<>(cur));
                cur.remove(cur.size() - 1);
            }
            return;
        }

        int max = target / coins[index];
        for (int i = 0; i <= max; i++) {
            cur.add(i);
            coinHelper(cur, result, index + 1, target - i * coins[i], coins);
            cur.remove(cur.size() - 1);
        }
    }





}
