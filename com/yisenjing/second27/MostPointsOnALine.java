package com.yisenjing.second27;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Yisen on 3/29/16.
 */
public class MostPointsOnALine {

    public int most(Point[] points) {
        if (points == null) {
            return 0;
        }
        int result = 0;
        for (int i = 0; i < points.length; i++) {
            Point seed = points[i];
            int same = 1;
            int sameX = 0;
            int max = 0;
            Map<Double, Integer> slops = new HashMap<Double, Integer>();
            for (int j = i + 1; j < points.length; j++) {
                Point cur = points[j];
                if (seed.x == cur.x && seed.y == cur.y) {
                    same++;
                } else if (seed.x == cur.x) {
                    sameX++;
                } else {
                    double slop = (seed.y - cur.y + 0.0) / (seed.x - cur.x);
                    if (!slops.containsKey(slop)) {
                        slops.put(slop, 1);
                    } else {
                        slops.put(slop, slops.get(slop) + 1);
                    }
                    max = Math.max(max, slops.get(slop));
                }

            }
            max = Math.max(max, sameX) + same;
            result = Math.max(result, max);
        }
        return result;
    }


}
