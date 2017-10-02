package com.example.BFS;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Created by chenj240 on 8/18/17.
 * Given a knight in a chessboard (a binary matrix with 0 as empty and 1 as barrier) with a source position, find the shortest path to a
 * destination position, return the length of the route.
 * Return -1 if knight can not reached.
 */

public class KnightShortestPath {

    public static void main(String[] args) {

        //Point start = new KnightShortestPath().new Point(2,0);
        //Point end = new KnightShortestPath().new Point(2,2);

        boolean[][] grid = {{false, false, false},
                           {false, false, false},
                           {false, false, false}};
        Solution solution = new KnightShortestPath().new Solution();

        //System.out.println(solution.shortestPath(grid, start, end));

        boolean[][] gridOne = {{false, true, false},
                              {false, false, false},
                              {false, false, false}};
        Solution solutionOne = new KnightShortestPath().new Solution();

       // System.out.println(solutionOne.shortestPath(gridOne, start, end));

        boolean[][] gridTwo = {{false, true, false},
                              {false, false, true},
                              {false, false, false}};
        Solution solutionTwo = new KnightShortestPath().new Solution();

        //System.out.println(solutionTwo.shortestPath(gridTwo, start, end));

        Set<Point> set = new HashSet<>();
        set.add(new Point(1,1));
        Point point = new Point(1,1);
        System.out.println(set.contains(point));



    }

    /**
     * Definition for a point.
     */
    static class Point {
        int x, y;

        public Point() {
            x = 0; y = 0;
        }

        public Point(int a, int b) {
            x = a; y = b;
        }

        @Override
        public int hashCode() {
            return x*999999%1111+y*999999% 1111;
        }

        @Override
        public boolean equals(Object o) {
            return o instanceof Point? this.x==((Point) o).x&&this.y==((Point) o).y:false;
        }
    }

    public class Solution {
        /**
         * @param grid    a chessboard included 0 (false) and 1 (true)
         * @param source, destination a point
         *
         * @return the shortest path
         */
//        public int shortestPath(boolean[][] grid, Point source, Point destination) {
//            // Write your code here
//            // coordinate definition
//            int[] deltaX = {1, 1, -1, -1, 2, 2, -2, -2};
//            int[] deltaY = {2, -2, 2, -2, 1, -1, 1, -1};
//
//            if (grid == null || source == null || destination == null || grid.length == 0 || grid[0].length == 0) {
//                return -1;
//            }
//
//            Queue<Point> queue = new LinkedList<>();
//            Set<Point> set = new HashSet<>();
//            queue.add(source);
//            set.add(source);
//            int shortestPath = -1;
//            while (!queue.isEmpty()) {
//                shortestPath++;
//                int size =queue.size();
//                for (int j=0;j<size;j++){
//                    Point point = queue.poll();
//                    if (point.x == destination.x && point.y == destination.y) {
//                        return shortestPath;
//                    }
//                    for (int i = 0; i < 8; i++) {
//                        if (inBound(grid, point.x + deltaX[i], point.y + deltaY[i])) {
//                            Point one = new Point(point.x + deltaX[i], point.y + deltaY[i]);
//                            if (!grid[point.x + deltaX[i]][point.y + deltaY[i]] && !set.contains(one)) {
//                                queue.add(one);
//                                set.add(one);
//                            }
//                        }
//                    }
//                }
//            }
//            return -1;
//        }
//
//        private boolean inBound(boolean[][] grid, int x, int y) {
//            return x >= 0 && x < grid.length && y >= 0 && y < grid[0].length;
//        }

           public int shortestPath(boolean[][] grid, Point source, Point destination) {
               int[] deltaX = {1, 1, -1, -1, 2, 2, -2, -2};
               int[] deltaY = {2, -2, 2, -2, 1, -1, 1, -1};

               if (grid == null || source == null || destination == null || grid.length == 0 || grid[0].length == 0) {
                   return -1;
               }

               Queue<Point> queue = new LinkedList<>();
               queue.add(source);
               int shortestPath = -1;
               while (!queue.isEmpty()) {
                   shortestPath++;
                   int size = queue.size();
                   for (int j = 0; j < size; j++) {
                       Point point = queue.poll();
                       if (point.x == destination.x && point.y == destination.y) {
                           return shortestPath;
                       }
                       for (int i = 0; i < 8; i++) {
                           if (inBound(grid, point.x + deltaX[i], point.y + deltaY[i])) {
                               Point one = new Point(point.x + deltaX[i], point.y + deltaY[i]);
                                   queue.add(one);
                               grid[point.x + deltaX[i]][point.y + deltaY[i]]=true;
                           }
                       }
                   }
               }
               return -1;
           }

        private boolean inBound(boolean[][] grid, int x, int y) {
            int m = grid.length-1;
            int n = grid[0].length-1;
            if (x<0 || x >m){
                return false;
            }

            if (y<0 || y >n){
                return false;
            }
            return !grid[x][y];
        }
    }
}
