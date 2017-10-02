package com.example.BFS;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by chenj240 on 8/20/17.
 * Given a 2D grid, each cell is either a wall 2, a zombie 1 or people 0 (the number zero, one, two).
 * Zombies can turn the nearest people(up/down/left/right) into zombies every day, but can not through wall.
 * How long will it take to turn all people into zombies? Return -1 if can not turn all people into zombies.
 */

public class ZombieInMatrix {

    public static void main(String[] args) {
        int[][] grid = {{0, 1, 2, 0, 0},
                        {1, 0, 0, 2, 1},
                        {0, 1, 0, 0, 0}};

        Solution solution = new ZombieInMatrix().new Solution();
        System.out.print(solution.zombie(grid));
    }

    public class Solution {
        private static final int PEOPLE = 0;
        private static final int ZOMBIE = 1;
        private static final int WALL = 2;

        /**
         * @param grid a 2D integer grid
         *
         * @return an integer
         */
        public int zombie(int[][] grid) {
            // Write your code here
            if (grid == null || grid.length == 0 || grid[0].length == 0) {
                return -1;
            }

            int[] deltaX = {0, -1, 0, 1};
            int[] deltaY = {-1, 0, 1, 0};
            // find all people
            int m = grid.length;
            int n = grid[0].length;
            int people = 0;
            Queue<Coordinate> queue = new LinkedList<>();

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == PEOPLE) {
                        people++;
                    }
                    if (grid[i][j] == ZOMBIE) {
                        queue.add(new Coordinate(i, j));
                    }
                }
            }

            if (people == 0) {
                return 0;
            }

            int dayCount = 0;
            while (!queue.isEmpty()) {
                if (people==0){
                    return dayCount;
                }
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    Coordinate zombieCoordinate = queue.poll();
                    for (int j = 0; j < 4; j++) {
                        int x = zombieCoordinate.x + deltaX[j];
                        int y = zombieCoordinate.y + deltaY[j];
                        if (inBound(grid, x, y)) {
                            people--;
                            grid[x][y] = ZOMBIE;
                            queue.add(new Coordinate(x,y));
                        }
                    }
                }
                dayCount++;
            }


            return -1;
        }

        private boolean inBound(int[][] grid, int x, int y) {
            int m = grid.length - 1;
            int n = grid[0].length - 1;
            if (x < 0 || x > m) {
                return false;
            }
            if (y < 0 || y > n) {
                return false;
            }
            return grid[x][y] == PEOPLE;
        }

        class Coordinate {
            int x, y;

            Coordinate(int x, int y) {
                this.x = x;
                this.y = y;
            }
        }
    }
}
