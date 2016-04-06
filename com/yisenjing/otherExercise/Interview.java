package com.yisenjing.otherExercise;

import java.util.*;

/**
 * Created by Yisen on 3/16/16.
 */
public class Interview {

    public int helper(int[] arr) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        int l = sc.nextInt();
        int m = sc.nextInt();
        String theString = sc.next();

        if (n < 2 || n > 100000) {
            return 0;
        }


        Hashtable<String, Integer> storage = new Hashtable<>();


        PriorityQueue<HashMap.Entry<String, Integer>> priQueue = new PriorityQueue<>(1, new Comparator<HashMap.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {

                if (o1.getValue() == o2.getValue()) {
                    return 0;
                }
                return o1.getValue() > o2.getValue() ? -1 : 1;
            }
        });

        for (int i = 0; i < theString.length(); i++) {
            int subLength = i;

            if (subLength <= 26 && subLength >= 2) {
                for (int j = 0; j < theString.length(); j++) {

                    if (j + subLength <= theString.length()) {
                        String subString = theString.substring(j, j + subLength);
                        if (storage.containsKey(subString)) {
                            storage.put(subString, storage.get(subString) + 1);
                        } else {
                            storage.put(subString, 1);
                        }
                    }
                }
            }
        }


        for (Map.Entry<String, Integer> entry : storage.entrySet()) {
            priQueue.offer(entry);
        }

        while (priQueue.size() != 0 && priQueue.peek().getKey().length() > 100000 ) {
            priQueue.poll();
        }

        int result = 0;

        if (priQueue.size() != 0) {
            if (priQueue.peek().getKey().length() >= 2 ) {
                result = priQueue.peek().getValue();
            }
        }

        return result;
    }


}
