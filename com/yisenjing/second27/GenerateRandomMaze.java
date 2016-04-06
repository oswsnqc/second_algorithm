package com.yisenjing.second27;

/**
 * Created by Yisen on 3/29/16.
 */
public class GenerateRandomMaze {

    public int[][] maze(int n) {
        int[][] result = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    result[i][j] = 0;
                } else {
                    result[i][j] = 1;
                }
            }
        }

        generate(0, 0, result);

        return result;
    }



    private void generate(int x, int y, int[][] result) {

        Dir[] dirs = Dir.values();

        shuffle(dirs);


        for (Dir dis : dirs) {

            int nextX = dis.moveX(x, 2);
            int nextY = dis.moveY(y, 2);

            if (canBreakWall(result, nextX, nextY)) {
                result[dis.moveX(x, 1)][dis.moveY(y, 1)] = 0;
                result[nextX][nextY] = 0;
                generate(nextX, nextY, result);
            }
        }
    }

    protected boolean canBreakWall(int[][] result, int x, int y) {
        return x >= 0 && x < result.length && y >= 0 && y < result.length && result[x][y] == 1;
    }

    private void shuffle(Dir[] dirs) {
        for (int i = 0; i < dirs.length; i++) {
            int inx = (int) (Math.random() * (dirs.length - i));
            Dir temp = dirs[i];
            dirs[i] = dirs[i + inx];
            dirs[i + inx] = temp;
        }
    }

    enum Dir {
        NORTH(-1, 0), SOURTH(1, 0), EAST(0, -1), WEST(0, 1);
        int deltaX;
        int deltaY;
        Dir(int deltaX, int deltaY) {
            this.deltaX = deltaX;
            this.deltaY = deltaY;
        }
        public int moveX(int x, int times) {
            return x + times * deltaX;
        }
        public int moveY(int y, int times) {
            return y + times * deltaY;
        }
    }




}
