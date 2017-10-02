package com.example.双指针_partition;

import java.util.Arrays;

/**
 * Created by chenj240 on 9/5/17.
 * Given an array nums of n integers, find two integers in nums such that the sum is closest to a given number, target.
 * Return the difference between the sum of the two integers and the target.
 * <p>
 * Example
 * Given array nums = [-1, 2, 1, -4], and target = 4.
 * The minimum difference is 1. (4 - (2 + 1) = 1).
 * Do it in O(nlogn) time complexity.
 */

public class TwoSumClosestToTarget {
    public static void main(String[] args) {
        int[] nums = new int[] {-1, 2, 1, -4};
        // -4, -1, 1, 2    target 4
        Solution solution = new TwoSumClosestToTarget().new Solution();
        System.out.print(solution.twoSumClosest(nums, 4));
    }

    public class Solution {
        /*
         * @param nums: an integer array
         * @param target: An integer
         * @return: the difference between the sum and the target
         */
        public int twoSumClosest(int[] nums, int target) {
            // write your code here
            if (nums == null || nums.length < 2) {
                return 0;
            }

            Arrays.sort(nums);
            int closet = Integer.MAX_VALUE;
            int left = 0;
            int right = nums.length - 1;
            while (left < right) {
                if (nums[left] + nums[right] == target) {
                    return 0;
                }
                closet = Math.min(closet, Math.abs(nums[left] + nums[right] - target));
                if (nums[left] + nums[right] < target) {
                    left++;
                } else {
                    right--;
                }
            }
            return closet;
        }
    }
}
