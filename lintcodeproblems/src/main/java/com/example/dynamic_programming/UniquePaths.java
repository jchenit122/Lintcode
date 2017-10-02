package com.example.dynamic_programming;

/**
 * Created by chenj240 on 9/12/17.
 * A robot is located at the top-left corner of a m x n grid.
 * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid.
 * How many possible unique paths are there?
 * Notice
 * <p>
 * m and n will be at most 100.
 * Have you met this question in a real interview? Yes
 * Example
 * Given m = 3 and n = 3, return 6.
 * Given m = 4 and n = 5, return 35.
 */

public class UniquePaths {
    public static void main(String[] args) {
        Solution solution = new UniquePaths().new Solution();
        System.out.print(solution.uniquePaths(4,5));
    }
    public class Solution {
        /**
         * @param n, m: positive integer (1 <= n ,m <= 100)
         * @return an integer
         */
        public int uniquePaths(int m, int n) {
            // write your code here
            int[][] f = new int[n][m];

            // init two sides
            for (int i =0; i<n;i++){
                f[i][0] =1;
            }

            for (int i =0; i<m;i++){
                f[0][i] =1;
            }

            for(int i =1;i<n;i++){
                for (int j=1;j<m;j++){
                    f[i][j] = f[i-1][j]+f[i][j-1];
                }
            }
            return f[n-1][m-1];
        }
    }

}
