package com.example.dynamic_programming;

/**
 * Created by chenj240 on 9/12/17.
 * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
 * Notice
 * Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
 * Example
 * Given the following triangle:
 * [
 * [2],
 * [3,4],
 * [6,5,7],
 * [4,1,8,3]
 * ]
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 */

public class Triangle {
    public static void main(String[] args) {
        int[][] triangle = new int[][] {
                {2},
                {3, 4},
                {6,5,7},
                {4,1,8,3}
        };
        Solution solution = new Triangle().new Solution();
        System.out.print(solution.minimumTotal(triangle));
    }

    public class Solution {
        /**
         * @param triangle: a list of lists of integers.
         *
         * @return: An integer, minimum path sum.
         */
        public int minimumTotal(int[][] triangle) {
            // write your code here
            //            if (triangle == null) {
            //                return -1;
            //            }
            //            if (triangle.length == 0 || triangle[0].length == 0) {
            //                return 0;
            //            }
            //
            //            int n = triangle.length;
            //            int[][] f = new int[n][n];
            //            f[0][0] = triangle[0][0];
            //
            //            for (int i = 1; i < n; i++) {
            //                f[i][0] = f[i - 1][0] + triangle[i][0];
            //                f[i][i] = f[i-1][i - 1] + triangle[i][i];
            //            }
            //
            //            for (int i = 1; i < n; i++) {
            //                for (int j = 1; j < i; j++) {
            //                    f[i][j] = Math.min(f[i - 1][j], f[i - 1][j - 1]) + triangle[i][j];
            //                }
            //            }
            //
            //            int min = Integer.MAX_VALUE;
            //            for (int i = 0; i < n; i++) {
            //                if (min > f[n - 1][i]) {
            //                    min = f[n - 1][i];
            //                }
            //            }
            //            return min;

            if (triangle == null) {
                return -1;
            }
            if (triangle.length == 0 || triangle[0].length == 0) {
                return 0;
            }

            int n = triangle.length;
            return helper (triangle, n, 0 ,0);


        }

        private int helper(int[][] triangle, int n, int x, int y) {
            if (n == 0){
                return 0;
            }
            return Math.min(helper(triangle, n-1,x+1,y),helper(triangle, n-1,x+1,y+1))+triangle[x][y];
        }
    }

}
