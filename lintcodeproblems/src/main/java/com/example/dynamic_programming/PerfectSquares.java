package com.example.dynamic_programming;

import java.util.Arrays;

/**
 * Created by chenj240 on 9/18/17.
 * Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.
 * <p>
 * Example
 * Given n = 12, return 3 because 12 = 4 + 4 + 4
 * Given n = 13, return 2 because 13 = 4 + 9
 */

public class PerfectSquares {
    public static void main(String[] args) {
        Solution solution = new PerfectSquares().new Solution();
        System.out.print(solution.numSquares(13));
    }

    public class Solution {
        /*
         * @param n: a positive integer
         * @return: An integer
         */
        public int numSquares(int n) {
            // write your code here
            int[] f = new int[n + 1];
            Arrays.fill(f, Integer.MAX_VALUE);
            for (int i = 0; i * i <= n; i++) {
                f[i*i] = 1;
            }
            for (int i = 0; i <= n; i++) {
                for (int j = 1; j * j <= i; j++) {
                    f[i] = Math.min(f[i], f[i - j * j] + 1);
                }
            }
            return f[n];
        }
    }
}
