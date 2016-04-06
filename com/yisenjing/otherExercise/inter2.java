package com.yisenjing.otherExercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Yisen on 3/17/16.
 */
public class inter2 {

    public static String[] helper(String s, String t) {

        String[] stringS = s.split(" ");
        String[] stringT = t.split(" ");

        int indexS = 0;
        int indexT = 0;

        List<String> aResult = new ArrayList<>();


        while (indexS < stringS.length && indexT < stringT.length) {


            if (stringS[indexS].equals(stringT[indexT])) {

                indexS++;
                indexT++;
            } else {
                aResult.add(stringS[indexS]);
                indexS++;

            }
        }


        for (int i = indexS + 1; i < stringS.length; i++) {
            aResult.add(stringS[i]);
            System.out.println(stringS[i ]);
        }


        String[] result = new String[aResult.size()];
        for (int i = 0; i < aResult.size(); i++) {
            result[i] = aResult.get(i);

        }

        System.out.println(Arrays.toString(result));

        return result;

    }
}
