package com.yisenjing.second7;


import java.util.*;

/**
 * Created by Yisen on 3/4/16.
 */
public class TopKFrequentWords {

    public String[] frequent(String[] combo, int k) {

        if (combo.length == 0) {
            return new String[0];
        }

        HashMap<String, Integer> map = new HashMap<String, Integer>();

        PriorityQueue<HashMap.Entry<String, Integer>> queue = new PriorityQueue<>(k, new Comparator<HashMap.Entry<String, Integer>>() {
            @Override
            public int compare(HashMap.Entry<String, Integer> o1, HashMap.Entry<String, Integer> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });

        for (int i = 0; i < combo.length; i++) {
            if (!map.containsKey(combo[i])) {
                map.put(combo[i], 1);
            } else {
                map.put(combo[i], map.get(combo[i]) + 1);
            }
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (queue.size() < k) {
                queue.offer(entry);
            } else if (entry.getValue() > queue.peek().getValue()){
                queue.poll();
                queue.offer(entry);
            }
        }

        String[] result = new String[queue.size()];
        for (int i = queue.size() - 1; i >= 0; i--) {
            result[i] = queue.poll().getKey();
        }

        return result;
    }
}
