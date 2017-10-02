package com.example.GoogleInterviews;

import java.util.Arrays;

/**
 * Created by chenj240 on 9/6/17.
 * Given an array contains N numbers of 0 .. N, find which number doesn't exist in the array.
 * <p>
 * Example
 * Given N = 3 and the array [0, 1, 3], return 2.
 * <p>
 * Challenge
 * Do it in-place with O(1) extra memory and O(n) time.
 */

public class FindTheMissingNumber {
    public static void main(String[] args) {
        int[] nums = new int[] {0, 2, 3};
        Solution solution = new FindTheMissingNumber().new Solution();
        System.out.print(solution.findMissing(nums));
        // 0 3 1 2
        // 0 2 1 3
        // 0 1  2
    }

    public class Solution {
        /**
         * @param nums: an array of integers
         *
         * @return: an integer
         */
        public int findMissing(int[] nums) {
            // write your code here
            if (nums == null || nums.length == 0) {
                return 0;
            }

            Arrays.sort(nums);
            int length = nums.length;
            if (nums[0]!=0){
                return 0;
            }
            for (int i = 1; i < length; i++) {
                if (nums[i] != nums[i - 1] + 1) {
                    return nums[i - 1] + 1;
                }
            }

            return nums.length;
        }
    }
}
