package com.yisenjing.second25;

import java.util.*;

/**
 * Created by Yisen on 3/27/16.
 */
public class KthClosestPointTo000 {

    public List<Integer> closest(int[] a, int[] b, int[] c, int k) {

        PriorityQueue<List<Integer>> minHeap = new PriorityQueue<>(2 * k, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                long b1 = distance(o1, a, b, c);
                long b2 = distance(o2, a, b, c);
                if (b1 == b2) {
                    return 0;
                }
                return b1 < b2 ? -1 : 1;
            }
        });
        List<Integer> cur = Arrays.asList(0, 0, 0);
        minHeap.offer(cur);

        Set<List<Integer>> set = new HashSet<>();

        set.add(cur);

        while (k > 0) {
            cur = minHeap.poll();
            List<Integer> n = Arrays.asList(cur.get(0) + 1, cur.get(1), cur.get(2));
            if (n.get(0) < a.length && set.add(n)) {
                minHeap.offer(n);
            }
            n = Arrays.asList(cur.get(0), cur.get(1) + 1, cur.get(2));
            if (n.get(1) < b.length && set.add(n)) {
                minHeap.offer(n);
            }
            n = Arrays.asList(cur.get(0), cur.get(1), cur.get(2) + 1);
            if (n.get(2) < c.length && set.add(n)) {
                minHeap.offer(n);
            }
            k--;
        }
        cur.set(0, a[cur.get(0)]);
        cur.set(1, b[cur.get(1)]);
        cur.set(2, c[cur.get(2)]);
        return cur;
    }


    private long distance(List<Integer> coor, int[] a, int[] b, int[] c) {
        long dis = 0;
        dis += a[coor.get(0)] * a[coor.get(0)];
        dis += b[coor.get(1)] * b[coor.get(1)];
        dis += c[coor.get(2)] * c[coor.get(2)];
        return dis;
    }



}
