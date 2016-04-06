package com.yisenjing.second25;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by Yisen on 3/27/16.
 */
public class MaxWaterTrappedII {

    public int maxTrapped(int[][] matrix) {

        int M = matrix.length;
        int N = matrix[0].length;

        if (M < 3 || N < 3) {
            return 0;
        }

        boolean[][] visited = new boolean[M][N];

        PriorityQueue<Pair> minHeap = new PriorityQueue<Pair>();
        int result = 0;

        processBoarder(matrix, minHeap, visited);

        while (!minHeap.isEmpty()) {
            Pair cur = minHeap.poll();
            List<Pair> neis = getNeis(cur, matrix);
            for (Pair nei : neis) {
                if (visited[nei.i][nei.j]) {
                    continue;
                }
                visited[nei.i][nei.j] = true;

                result += Math.max(0, cur.height - nei.height);
                nei.height = Math.max(nei.height, cur.height);
                minHeap.add(nei);
            }
        }
        return result;
    }


    private void processBoarder(int[][] matrix, PriorityQueue<Pair> minHeap, boolean[][] visited) {
        int M = matrix.length;
        int N = matrix[0].length;
        for (int i = 0; i < M; i++) {
            minHeap.offer(new Pair(i, 0, matrix[i][0]));
            minHeap.offer(new Pair(i, N - 1, matrix[i][N - 1]));
            visited[i][0] = true;
            visited[i][N - 1] = true;
        }
        for (int j = 1; j < N - 1; j++) {
            minHeap.offer(new Pair(0, j, matrix[0][j]));
            minHeap.offer(new Pair(M - 1, j, matrix[M - 1][j]));
            visited[0][j] = true;
            visited[M - 1][j] = true;
        }
    }


    private List<Pair> getNeis(Pair cur, int[][] matrix) {
        List<Pair> result = new ArrayList<Pair>();
        int M = matrix.length;
        int N = matrix[0].length;
        int i = cur.i;
        int j = cur.j;
        if (i + 1 < M) {
            result.add(new Pair(i + 1, j, matrix[i + 1][j]));
        }
        if (j + 1 < N) {
            result.add(new Pair(i, j + 1, matrix[i][j + 1]));
        }
        if (i - 1 >= 0) {
            result.add(new Pair(i - 1, j, matrix[i - 1][j]));
        }
        if (j - 1 >= 0) {
            result.add(new Pair(i, j - 1, matrix[i][j - 1]));
        }
        return result;
    }


    static class Pair implements Comparable<Pair> {
        int i;
        int j;
        int height;
        Pair(int i, int j, int height) {
            this.i = i;
            this.j = j;
            this.height = height;
        }

        @Override
        public int compareTo(Pair another) {
            if (this.height == another.height) {
                return 0;
            }
            return this.height < another.height ? -1 : 1;
        }

    }
}
