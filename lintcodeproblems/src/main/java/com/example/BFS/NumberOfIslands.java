package com.example.BFS;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by chenj240 on 8/16/17.
 * Given a boolean 2D matrix, 0 is represented as the sea, 1 is represented as the island. If two 1 is adjacent, we consider them in the same
 * island. We only consider up/down/left/right adjacent.
 * Find the number of islands.
 */

public class NumberOfIslands {


    public static void main(String[] args) {
        boolean[][] grid = {{true, true, false, false, false},
                            {false, true, false, false, true},
                            {false, false, false, true, true},
                            {false, false, false, false, false},
                            {false, false, false, false, true}};
        Solution solution = new NumberOfIslands().new Solution();
        System.out.println(solution.numIslands(grid));

        boolean[][] gridOne = {{true, true, false, false, false},
                               {false, true, false, false, true},
                               {false, false, true, false, true},
                               {false, false, false, false, false},
                               {false, false, false, false, true}};
        Solution solutionOne = new NumberOfIslands().new Solution();
        System.out.print(solutionOne.numIslands(gridOne));


    }

    public class Solution {
        /**
         * @param grid a boolean 2D matrix
         *
         * @return an integer
         */
        public int numIslands(boolean[][] grid) {
            // Write your code here
            if (grid == null || grid.length == 0) {
                return 0;
            }
            int x = grid.length;
            int y = grid[0].length;
            int numOfIslands = 0;
            for (int i = 0; i < x; i++) {
                for (int j = 0; j < y; j++) {
                    if (grid[i][j]) {
                        bfs(grid, i, j);
                        numOfIslands++;
                    }
                }
            }
            return numOfIslands;
        }

        private void bfs(boolean[][] grid, int x, int y) {
            // coordinate definition
            int[] deltaX = {0, -1, 0, 1};
            int[] deltaY = {-1, 0, 1, 0};
            Coordinate coordinateIn = new Coordinate(x, y);
            Queue<Coordinate> queue = new LinkedList<>();
            queue.offer(coordinateIn);
            while (!queue.isEmpty()) {
                Coordinate coordinateOut = queue.poll();
                for (int i = 0; i < 4; i++) {
                    if (inBound(grid, coordinateOut.x + deltaX[i], coordinateOut.y + deltaY[i])) {
                        if (grid[coordinateOut.x + deltaX[i]][coordinateOut.y + deltaY[i]]) {
                            queue.offer(new Coordinate(coordinateOut.x + deltaX[i], coordinateOut.y + deltaY[i]));
                            grid[coordinateOut.x + deltaX[i]][coordinateOut.y + deltaY[i]]=false;
                        }
                    }
                }
            }

        }

        private boolean inBound(boolean[][] grid, int x, int y) {
            return x >= 0 && x < grid.length && y >= 0 && y < grid[0].length;
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
