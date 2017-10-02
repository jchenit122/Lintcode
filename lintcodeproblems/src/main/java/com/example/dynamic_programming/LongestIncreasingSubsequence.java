package com.example.dynamic_programming;

/**
 * Created by chenj240 on 9/18/17.
 * Given a sequence of integers, find the longest increasing subsequence (LIS).
 * You code should return the length of the LIS.
 * <p>
 * Clarification
 * What's the definition of longest increasing subsequence?
 * The longest increasing subsequence problem is to find a subsequence of a given sequence in which the subsequence's elements are in sorted order,
 * lowest to highest, and in which the subsequence is as long as possible. This subsequence is not necessarily contiguous, or unique.
 * https://en.wikipedia.org/wiki/Longest_increasing_subsequence
 * Example
 * For [5, 4, 1, 2, 3], the LIS is [1, 2, 3], return 3
 * For [4, 2, 4, 5, 3, 7], the LIS is [2, 4, 5, 7], return 4
 * Challenge
 * Time complexity O(n^2) or O(nlogn)
 */

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        Solution solution = new LongestIncreasingSubsequence().new Solution();
        int[] nums = new int[] {4, 2, 4, 5, 3, 7};
        System.out.print(solution.longestIncreasingSubsequence(nums));
    }

    public class Solution {
        /**
         * @param nums: The integer array
         *
         * @return: The length of LIS (longest increasing subsequence)
         */
        public int longestIncreasingSubsequence(int[] nums) {
            // write your code here
            if (nums == null || nums.length == 0) {
                return 0;
            }
            int[] f = new int[nums.length];
            for (int i = 0; i < nums.length; i++) {
                f[i] = 1;
                for (int j = 0; j < i; j++) {
                    if (f[j] + 1 > f[i] && nums[i] > nums[j]) {
                        f[i] = f[j] + 1;
                    }
                }
            }

            int max = 0;
            for (int i : f) {
                if (max < i) {
                    max = i;
                }
            }
            return max;
        }
    }
}
