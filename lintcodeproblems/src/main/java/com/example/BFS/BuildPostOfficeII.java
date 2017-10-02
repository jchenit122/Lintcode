package com.example.BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by chenj240 on 8/21/17.
 * Given a 2D grid, each cell is either a wall 2, an house 1 or empty 0 (the number zero, one, two),
 * find a place to build a post office so that the sum of the distance from the post office to all the houses is smallest.
 * Return the smallest sum of distance. Return -1 if it is not possible.
 */

public class BuildPostOfficeII {

    public static void main(String[] args) {

        int[][] grid = {{0, 1, 0, 0, 0},
                {1, 0, 0, 2, 1},
                {0, 1, 0, 0, 0}};

        Solution solution = new BuildPostOfficeII().new Solution();
        System.out.print(solution.shortestDistance(grid));
    }

    public class Solution {

        private static final int EMPTY = 0;
        private static final int HOUSE = 1;

        /**
         * @param grid a 2D grid
         *
         * @return an integer
         */
        public int shortestDistance(int[][] grid) {
            // Write your code here

            if (grid == null || grid.length == 0 || grid[0].length == 0) {
                return -1;
            }

            int n = grid.length;
            int m = grid[0].length;
            List<Coordinate> houseList = getCoordinates(grid, HOUSE);
            List<Coordinate> emptyList = getCoordinates(grid, EMPTY);

            int[][] distanceSum = new int[n][m];
            int[][] visitedTimes = new int[n][m];

            for (Coordinate houseNode : houseList) {
                bfs(houseNode, distanceSum, visitedTimes, grid);
            }

            int shortestDistance = Integer.MAX_VALUE;

            for (Coordinate emptyNode : emptyList) {
                if (visitedTimes[emptyNode.x][emptyNode.y] != houseList.size()) {
                    continue;
                }
                shortestDistance = Math.min(shortestDistance, distanceSum[emptyNode.x][emptyNode.y]);
            }

            if (shortestDistance != Integer.MAX_VALUE) {
                return shortestDistance;
            }

            return -1;
        }

        private void bfs(Coordinate startNode, int[][] distanceSum, int[][] visitedTimes, int[][] grid) {

            // coordinate definition
            int[] deltaX = {0, -1, 0, 1};
            int[] deltaY = {-1, 0, 1, 0};

            Queue<Coordinate> queue = new LinkedList<>();
            boolean[][] set = new boolean[grid.length][grid[0].length];
            queue.add(startNode);
            int steps = 0;

            while (!queue.isEmpty()) {
                int size = queue.size();
                steps++;
                for (int j = 0; j < size; j++) {
                    Coordinate point = queue.poll();
                    for (int i = 0; i < 4; i++) {
                        Coordinate newPoint = new Coordinate(point.x + deltaX[i], point.y + deltaY[i]);
                        if (!inBound(newPoint, grid)) {
                            continue;
                        }
                        if (set[newPoint.x][newPoint.y]) {
                            continue;
                        }
                        queue.add(newPoint);
                        set[newPoint.x][newPoint.y] = true;
                        visitedTimes[newPoint.x][newPoint.y]++;
                        distanceSum[newPoint.x][newPoint.y] += steps;
                    }
                }
            }
        }

        private boolean inBound(Coordinate newPoint, int[][] grid) {
            if (newPoint.x < 0 || newPoint.x > grid.length - 1) {
                return false;
            }
            if (newPoint.y < 0 || newPoint.y > grid[0].length - 1) {
                return false;
            }
            return grid[newPoint.x][newPoint.y] == EMPTY;
        }

        private List<Coordinate> getCoordinates(int[][] grid, int type) {
            List<Coordinate> list = new ArrayList<>();
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == type) {
                        list.add(new Coordinate(i, j));
                    }
                }
            }
            return list;
        }

        class Coordinate {
            int x, y;

            public Coordinate(int x, int y) {
                this.x = x;
                this.y = y;
            }
        }

    }
}
