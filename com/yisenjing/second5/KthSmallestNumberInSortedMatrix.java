package com.yisenjing.second5;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by Yisen on 3/2/16.
 */
public class KthSmallestNumberInSortedMatrix {

    public int kmatrix(int[][] matrix, int k) {
        int vertical = matrix.length;
        int horizen = matrix[0].length;

        PriorityQueue<Cell> storage = new PriorityQueue<Cell>(k, new Comparator<Cell>() {
            @Override
            public int compare(Cell o1, Cell o2) {
                if (o1.value == o2.value) {
                    return 0;
                }
                return o1.value < o2.value ? -1 : 1;
            }
        });

        boolean[][] visited = new boolean[vertical][horizen];
        storage.offer(new Cell(0, 0, matrix[0][0]));
        visited[0][0] = true;

        for (int i = 0; i < k - 1; i++) {
            Cell cur = storage.poll();
            if (cur.horizental + 1 < horizen && !visited[cur.vertical][cur.horizental + 1]) {
                storage.offer(new Cell(cur.horizental + 1, cur.vertical, matrix[cur.vertical + 1][cur.horizental + 1]));
                visited[cur.vertical][cur.horizental + 1] = true;
            }

            if (cur.vertical + 1 < vertical && !visited[cur.vertical + 1][cur.horizental]) {
                storage.offer(new Cell(cur.horizental, cur.vertical + 1, matrix[cur.vertical + 1][cur.horizental]));
                visited[cur.vertical + 1][cur.horizental] = true;
            }
        }
        return storage.peek().value;
    }


    static class Cell {
        int horizental;
        int vertical;
        int value;

        Cell(int horizental, int vertical, int value) {
            this.horizental = horizental;
            this.vertical = vertical;
            this.value = value;
        }
    }

}
