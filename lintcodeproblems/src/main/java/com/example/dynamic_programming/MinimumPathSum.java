package com.example.dynamic_programming;

/**
 * Created by chenj240 on 9/12/17.
 * Given a m x n grid filled with non-negative numbers,
 * find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 * Notice
 * You can only move either down or right at any point in time.
 */

public class MinimumPathSum {
    public static void main(String[] args) {
        int[][] grid = new int[][] {
                {0, 2, 3},
                {1, 1, 3},
                {1, 1, 1}
        };

        int[][] gridOne = new int[][] {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };
        Solution solution = new MinimumPathSum().new Solution();
        System.out.print(solution.minPathSum(gridOne));
    }
        public class Solution {
        /**
         * @param grid: a list of lists of integers.
         *
         * @return: An integer, minimizes the sum of all numbers along its path
         */
        public int minPathSum(int[][] grid) {
            // write your code here
            if (grid == null){
                return -1;
            }
            if (grid.length == 0 || grid[0].length==0){
                return 0;
            }

            int n = grid.length;
            int m = grid[0].length;
            int[][] f = new int[n][m];
            f[0][0] =grid[0][0];
            for (int i =1;i<n;i++){
                f[i][0] = f[i-1][0]+grid[i][0];
            }

            for (int i =1;i<m;i++){
                f[0][i] = f[0][i-1]+grid[0][i];
            }

            for (int i =1;i<n;i++){
                for(int j =1;j<m;j++){
                    f[i][j] = Math.min(f[i][j-1],f[i-1][j]) + grid[i][j];
                }
            }
            return f[n-1][m-1];
        }
    }

}
