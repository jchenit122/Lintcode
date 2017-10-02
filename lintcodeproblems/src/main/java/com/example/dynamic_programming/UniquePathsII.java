package com.example.dynamic_programming;

/**
 * Created by chenj240 on 9/11/17.
 * Follow up for "Unique Paths":
 * Now consider if some obstacles are added to the grids. How many unique paths would there be?
 * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
 * <p>
 * Notice
 * m and n will be at most 100.
 * For example,
 * There is one obstacle in the middle of a 3x3 grid as illustrated below.
 * [
 * [0,0,0],
 * [0,1,0],
 * [0,0,0]
 * ]
 * The total number of unique paths is 2.
 */

public class UniquePathsII {
    public static void main(String[] args) {
        int[][] obstacleGrid = new int[][] {
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        };

        int[][] obstacleGridOne = new int[][] {
                {0, 0},
                {0, 0},
                {0, 0},
                {1, 0},
                {0, 0}
        };

        Solution solution = new UniquePathsII().new Solution();
        System.out.print(solution.uniquePathsWithObstacles(obstacleGridOne));
    }

    public class Solution {
        /**
         * @param obstacleGrid: A list of lists of integers
         *
         * @return: An integer
         */
        public int uniquePathsWithObstacles(int[][] obstacleGrid) {
            // write your code here
            if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0) {
                return 0;
            }
            int n = obstacleGrid.length;
            int m = obstacleGrid[0].length;
            int[][] f = new int[n][m];

            // init two sides
            for (int i = 0; i < n; i++) {
                if (obstacleGrid[i][0] == 1) {
                    f[i][0] = 0;
                    break;
                } else {
                    f[i][0] = 1;
                }
            }

            for (int i = 0; i < m; i++) {
                if (obstacleGrid[0][i] == 1) {
                    f[0][i] = 0;
                    break;
                } else {
                    f[0][i] = 1;
                }
            }

            for (int i = 1; i < n; i++) {
                for (int j = 1; j < m; j++) {
                    if (obstacleGrid[i][j] == 1) {
                        f[i][j] = 0;
                    } else {
                        f[i][j] = f[i - 1][j] + f[i][j - 1];
                    }
                }
            }
            return f[n - 1][m - 1];
        }
    }
}
