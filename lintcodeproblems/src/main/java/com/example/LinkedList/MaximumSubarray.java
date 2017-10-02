package com.example.LinkedList;

/**
 * Created by chenj240 on 8/29/17.
 * Given an array of integers, find a contiguous subarray which has the largest sum.
 * Given the array [−2,2,−3,4,−1,2,1,−5,3], the contiguous subarray [4,−1,2,1] has the largest sum = 6.
 */

public class MaximumSubarray {

    public static void main(String[] args) {
        int[] nums = new int[] {-2, 2, -3, 4, -1, 2, 1, -5, 3};
        Solution solution = new MaximumSubarray().new Solution();
        System.out.print(solution.maxSubArray(nums));
    }

    public class Solution {

        /**
         * @param nums: A list of integers
         *
         * @return: A integer indicate the sum of max subarray
         */
        public int maxSubArray(int[] nums) {
            // write your code
            if (nums == null || nums.length == 0) {
                return 0;
            }

            int max = Integer.MIN_VALUE, sum = 0, minSum = 0;
            for (int i = 0; i < nums.length; i++) {
                sum += nums[i];
                max = Math.max(max, sum - minSum);
                minSum = Math.min(sum, minSum);
            }
            return max;
        }
    }
}
