package com.yisenjing.second27;
import java.util.Arrays;
import java.util.Comparator;
/**
 * Created by Yisen on 3/29/16.
 */
public class LargestSetOfPointsWithPositiveSlope {
    public int largest(Point[] points) {
        if (points == null) {
            return 0;
        }
        Arrays.sort(points, new yuxiCompare());

        int result = 0;

        int[] longest = new int[points.length];

        for (int i = 0; i < points.length; i++){
            for (int j = 0; j < i; j++) {
                if (points[i].y > points[j].y && points[i].x > points[j].x) {
                    longest[i] = Math.max(longest[i], longest[j]);
                }
            }
            longest[i]++;
            result = Math.max(result, longest[i]);
        }
        return result == 1 ? 0 : result;
    }

    static class yuxiCompare implements Comparator<Point> {
        @Override
        public int compare(Point p1, Point p2) {
            if (p1.y < p2.y) {
                return -1;
            } else if (p1.y > p2.y) {
                return 1;
            } else if (p1.x < p2.x) {
                return -1;
            } else if (p1.x > p2.x) {
                return 1;
            }
            return 0;
        }
    }


}
