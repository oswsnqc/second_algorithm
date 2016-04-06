package com.yisenjing.second25;

import java.util.*;

/**
 * Created by Yisen on 3/27/16.
 */
public class PlaceToPutTheChairI {

    private static final char EQUI = 'E';
    private static final char OBS = 'O';

    public List<Integer> putChair(char[][] gym) {

        int M = gym.length;
        int N = gym[0].length;

        int[][] cost = new int[M][N];

        List<Integer> result = null;

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (EQUI == gym[i][j]) {
                    if (!addCost(i, j, cost, gym)) {
                        return null;
                    }
                }
            }
        }


        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (gym[i][j] != EQUI && gym[i][j] != OBS) {
                    if (result == null) {
                        result = Arrays.asList(i, j);
                    } else {
                        if (cost[result.get(0)][result.get(1)] > cost[i][j]) {
                            result.set(0, i);


                            Map<Integer, Integer> storage = new HashMap<>();

                            storage.replace();



                            result.set(1, j);
                        }
                    }
                }
            }
        }
        return result;
    }


    private boolean addCost(int i, int j, int[][] cost, char[][] gym) {
        int M = gym.length;
        int N = gym[0].length;
        boolean[][] visited = new boolean[M][N];
        visited[i][j] = true;
        Deque<Pair> stack = new LinkedList<>();
        stack.add(new Pair(i, j));
        int totalCost = 1;

        while (!stack.isEmpty()) {
            int size = stack.size();
            for (int x = 0; x < size; x++) {
                Pair cur = stack.pollFirst();
                List<Pair> neis = getNei(cur.i, cur.j, gym);
                for (Pair nei : neis) {
                    if (!visited[nei.i][nei.j]) {
                        visited[nei.i][nei.j] = true;
                        cost[nei.i][nei.j] += totalCost;
                        stack.offerLast(nei);
                    }
                }
            }
            totalCost++;
        }

        for (int p = 0; p < M; p++) {
            for (int q = 0; q < N; q++) {
                if (!visited[p][q] && EQUI == gym[p][q]) {
                    return false;
                }
            }
        }
        return true;
    }

    private List<Pair> getNei(int i, int j, char[][] gym) {

        List<Pair> result = new ArrayList<Pair>();

        int M = gym.length;
        int N = gym[0].length;

        if (i + 1 < M && OBS != gym[i + 1][j]) {
            result.add(new Pair(i + 1, j));
        }

        if (j + 1 < N && OBS != gym[i][j + 1]) {
            result.add(new Pair(i, j + 1));
        }

        if (i - 1 >= 0 && OBS != gym[i - 1][j]) {
            result.add(new Pair(i - 1, j));
        }

        if (j - 1 >= 0 && OBS != gym[i][j - 1]) {
            result.add(new Pair(i, j - 1));
        }

        return result;
    }

    private class Pair {
        public int i;
        public int j;
        public Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }


}
